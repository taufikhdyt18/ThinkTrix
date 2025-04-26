package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    private ImageButton btnBack;
    private Button btnExitApp;
    private Switch switchSound, switchVibration;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initialize views
        initializeViews();

        // Load saved preferences
        loadSettings();

        // Set click listeners
        setClickListeners();
    }

    private void initializeViews() {
        btnBack = findViewById(R.id.btnBack);
        btnExitApp = findViewById(R.id.btnExitApp);
        switchSound = findViewById(R.id.switchSound);
        switchVibration = findViewById(R.id.switchVibration);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("QuizAppSettings", MODE_PRIVATE);
    }

    private void loadSettings() {
        // Load saved settings
        boolean soundEnabled = sharedPreferences.getBoolean("sound_enabled", true);
        boolean vibrationEnabled = sharedPreferences.getBoolean("vibration_enabled", true);

        switchSound.setChecked(soundEnabled);
        switchVibration.setChecked(vibrationEnabled);
    }

    private void setClickListeners() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save settings before going back
                saveSettings();
                finish();
            }
        });

        btnExitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExitConfirmationDialog();
            }
        });

        // Add listeners for the switches if needed
        switchSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // You could implement immediate sound feedback here
                Toast.makeText(SettingsActivity.this,
                        switchSound.isChecked() ? "Sound enabled" : "Sound disabled",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveSettings() {
        // Save settings to SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("sound_enabled", switchSound.isChecked());
        editor.putBoolean("vibration_enabled", switchVibration.isChecked());
        editor.apply();

        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
    }

    private void showExitConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit Application");
        builder.setMessage("Are you sure you want to exit the application?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                exitApplication();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void exitApplication() {
        // Save settings before exiting
        saveSettings();

        // This will close all activities and exit the app
        finishAffinity();

        // Alternative approach:
        // System.exit(0);
    }

    @Override
    public void onBackPressed() {
        // Save settings when back button is pressed
        saveSettings();
        super.onBackPressed();
    }
}