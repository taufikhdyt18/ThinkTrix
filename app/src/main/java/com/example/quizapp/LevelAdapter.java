package com.example.quizapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class LevelAdapter extends ArrayAdapter<LevelItem> {

    private Context context;
    private List<LevelItem> levelItems;
    private int selectedPosition = 0;

    public LevelAdapter(Context context, List<LevelItem> levelItems) {
        super(context, 0, levelItems);
        this.context = context;
        this.levelItems = levelItems;
    }

    static class ViewHolder {
        ImageButton btnLevelItem;
        TextView tvLevelText;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.level_item, parent, false);
            holder = new ViewHolder();
            holder.btnLevelItem = convertView.findViewById(R.id.btnLevelItem);
            holder.tvLevelText = convertView.findViewById(R.id.tvLevelText);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        LevelItem currentLevel = levelItems.get(position);
        holder.tvLevelText.setText(currentLevel.getLevelName());

        if (position == selectedPosition) {
            holder.btnLevelItem.setBackgroundResource(R.drawable.selected_button);
        } else {
            holder.btnLevelItem.setBackgroundResource(R.drawable.rounded_button);
        }

        return convertView;
    }

    public void setSelectedPosition(int position) {
        this.selectedPosition = position;
    }
}
