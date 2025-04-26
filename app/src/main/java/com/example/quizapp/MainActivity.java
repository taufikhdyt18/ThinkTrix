package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView listViewLevels;
    private ImageView btnStart;
    private ImageView ivUserProfile, ivSettings;
    private TextView tvUsername;

    private int currentLevel = 1; // Default selected level
    private LevelAdapter levelAdapter;
    private List<LevelItem> levelItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        initializeViews();


        // Setup level list
        setupLevelList();

        // Set click listeners
        setClickListeners();
    }

    private void initializeViews() {
        listViewLevels = findViewById(R.id.listViewLevels);
        btnStart = findViewById(R.id.btnStart);

        ivUserProfile = findViewById(R.id.ivUserProfile);
        ivSettings = findViewById(R.id.ivSettings);
        tvUsername = findViewById(R.id.tvUsername);
    }

    private void setupLevelList() {
        levelItems = new ArrayList<>();

        // Add level items (you can add as many as you want)
        for (int i = 1; i <= 20; i++) {
            levelItems.add(new LevelItem("Level " + i, i));
        }

        levelAdapter = new LevelAdapter(levelItems);
        listViewLevels.setAdapter(levelAdapter);

        // Set default selection
        updateSelectedLevel(currentLevel);
    }

    private void setClickListeners() {
        btnStart.setOnClickListener(this);
        ivUserProfile.setOnClickListener(this);
        ivSettings.setOnClickListener(this);

        listViewLevels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LevelItem selectedItem = levelItems.get(position);
                updateSelectedLevel(selectedItem.getLevelNumber());
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnStart) {
            startGame();
        } else if (v.getId() == R.id.ivUserProfile) {
            openUserProfile();
        } else if (v.getId() == R.id.ivSettings) {
            openSettings();
        }
    }

    private void updateSelectedLevel(int level) {
        currentLevel = level;

        // Update all item states and notify adapter
        for (LevelItem item : levelItems) {
            item.setSelected(item.getLevelNumber() == level);
        }

        levelAdapter.notifyDataSetChanged();
    }

    private void startGame() {
        // Start the selected level
        Toast.makeText(this, "Starting Level " + currentLevel, Toast.LENGTH_SHORT).show();

        // Logic to launch the appropriate QuizActivity based on level
        Intent gameIntent;

        // For demonstration, we'll just launch QuizActivity1 for all levels
        // You could modify this to launch different activities based on the level
        gameIntent = new Intent(MainActivity.this, QuizActivity1.class);
        gameIntent.putExtra("LEVEL", currentLevel);
        startActivity(gameIntent);
    }

    private void openUserProfile() {
        Toast.makeText(this, "Opening User Profile", Toast.LENGTH_SHORT).show();
        // Implement user profile navigation if needed
    }


    private void openSettings() {
        Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(settingsIntent);
    }

    // Model class for level items
    private static class LevelItem {
        private String levelName;
        private int levelNumber;
        private boolean selected;

        public LevelItem(String levelName, int levelNumber) {
            this.levelName = levelName;
            this.levelNumber = levelNumber;
            this.selected = false;
        }

        public String getLevelName() {
            return levelName;
        }

        public int getLevelNumber() {
            return levelNumber;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }

    // Custom adapter for level items
    // Custom adapter for level items
    private class LevelAdapter extends BaseAdapter {

        private List<LevelItem> items;

        public LevelAdapter(List<LevelItem> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.level_item, parent, false);

                holder = new ViewHolder();
                holder.imgBtnLevel = convertView.findViewById(R.id.btnLevelItem);
                holder.tvLevelText = convertView.findViewById(R.id.tvLevelText);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            LevelItem item = items.get(position);

            // Set the level text
            holder.tvLevelText.setText(item.getLevelName());

            // Apply appropriate styling based on selection state
            if (item.isSelected()) {
                holder.imgBtnLevel.setBackgroundResource(R.drawable.selected_button);
                holder.tvLevelText.setTextColor(getResources().getColor(android.R.color.black));
            } else {
                holder.imgBtnLevel.setBackgroundResource(R.drawable.rounded_button);
                holder.tvLevelText.setTextColor(getResources().getColor(android.R.color.white));
            }

            return convertView;
        }

        private class ViewHolder {
            ImageButton imgBtnLevel;
            TextView tvLevelText;
        }
    }
}