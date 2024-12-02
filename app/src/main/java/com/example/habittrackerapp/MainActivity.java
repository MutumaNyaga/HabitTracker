package com.example.habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addHabitButton = findViewById(R.id.addHabitButton);
        Button viewHistoryButton = findViewById(R.id.viewHistoryButton);
        RecyclerView habitRecyclerView = findViewById(R.id.habitRecyclerView);

        addHabitButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddHabitActivity.class);
            startActivity(intent);
        });

        viewHistoryButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);
        });

        habitRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        HabitAdapter adapter = new HabitAdapter(getSampleHabits());
        habitRecyclerView.setAdapter(adapter);
    }

    private List<Habit> getSampleHabits() {
        List<Habit> habits = new ArrayList<>();
        habits.add(new Habit("Exercise", "7:00 AM", false));
        habits.add(new Habit("Read a Book", "9:00 PM", true));
        return habits;
    }
}
