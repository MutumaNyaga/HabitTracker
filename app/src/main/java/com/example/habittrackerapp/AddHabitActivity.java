package com.example.habittracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddHabitActivity extends AppCompatActivity {

    private EditText habitNameInput, reminderTimeInput;
    private HabitDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);

        habitNameInput = findViewById(R.id.habitNameInput);
        reminderTimeInput = findViewById(R.id.reminderTimeInput);
        Button saveHabitButton = findViewById(R.id.saveHabitButton);

        dbHelper = new HabitDatabaseHelper(this);

        saveHabitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = habitNameInput.getText().toString();
                String time = reminderTimeInput.getText().toString();

                if (name.isEmpty() || time.isEmpty()) {
                    Toast.makeText(AddHabitActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    dbHelper.addHabit(name, time);
                    Toast.makeText(AddHabitActivity.this, "Habit Added", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
