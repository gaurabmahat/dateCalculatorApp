package com.gaurav.datecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
    CalendarView calendarView;
    View screenView; //the main wallpaper
    TextView days, nextDateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        int number = intent.getIntExtra(MainActivity.EXTRA_NUMBER, 0);

        calendarView = findViewById(R.id.calendarViewMainActivity2);
        days = findViewById(R.id.days); //print the number given by the user
        nextDateView = findViewById(R.id.nextDate); //future date

        if(number == 1) {
            days.setText("AFTER 1 DAY IT IS");
        } else {
            days.setText("AFTER " + number +  " DAYS IT IS");
        }
        //add the number of days to the calendar
        Date futureDate = new Date();
        //prints the future date
        nextDateView.setText(futureDate.addDate(number));
        //future wallpaper
        screenView = findViewById(R.id.mainView);
        //set the calendar to show the future date
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, futureDate.yearNumber());
        calendar.set(Calendar.MONTH, futureDate.monthNumber());
        calendar.set(Calendar.DATE, futureDate.dayOfTheMonth());
        //set the future date in the calendar
        long showFutureDate = calendar.getTimeInMillis();
        calendarView.setDate(showFutureDate, true, true);

        /**if(futureDate.isNewYear()){
            screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.firework));
            days.setTextColor(Color.RED);
            days.setTextSize(35);
            nextDateView.setTextColor(Color.RED);
            nextDateView.setTextSize(50);

        }else if(futureDate.isWinter()){
            //set the wallpaper
           screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.winter));
        }else if(futureDate.isSpring()){
            //set the wallpaper
            screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.spring));
            //set the wallpaper
        }else if(futureDate.isSummer()){
            //set the wallpaper
            screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.summer));
        }else{
            //set the wallpaper
            screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.autumn));
        }**/

    }
}
