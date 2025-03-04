package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CalendarView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class HocCalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_calendar);


        Button btnToday = findViewById(R.id.btnToday);
        CalendarView myCalendar = findViewById(R.id.myCalendar);
        EditText edtDate = findViewById(R.id.edtDate);


        btnToday.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String todayDate = dateFormat.format(calendar.getTime());


            edtDate.setText(todayDate);
        });


        myCalendar.setOnDateChangeListener((view, year, month, dayOfMonth) -> {

            Calendar selectedDate = Calendar.getInstance();
            selectedDate.set(year, month, dayOfMonth);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String selectedDateString = dateFormat.format(selectedDate.getTime());

            edtDate.setText(selectedDateString);
        });
    }
}
