package com.example.habittracker;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView historyRecyclerView;
    private HabitDatabaseHelper dbHelper;
    private HabitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        historyRecyclerView = findViewById(R.id.historyRecyclerView);
        dbHelper = new HabitDatabaseHelper(this);

        List<Habit> completedHabits = fetchCompletedHabits();

        adapter = new HabitAdapter(completedHabits);
        historyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        historyRecyclerView.setAdapter(adapter);
    }

    private List<Habit> fetchCompletedHabits() {
        List<Habit> habits = new ArrayList<>();
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM Habits WHERE is_completed = 1", null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String time = cursor.getString(cursor.getColumnIndex("reminder_time"));
                boolean isCompleted = cursor.getInt(cursor.getColumnIndex("is_completed")) == 1;

                habits.add(new Habit(name, time, isCompleted));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return habits;
    }
}
