package com.gaurav.datecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView currentDateView;
    EditText noOfDaysAdded;
    Button submitButton, buttonSelection;

    public static final String EXTRA_NUMBER = "com.gaurav.datecalculator.EXTRA_NUMBER";

    int item_selection = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentDateView = findViewById(R.id.currentDate); //displays today's date
        submitButton = findViewById(R.id.submitButton); //submit button
        buttonSelection = findViewById(R.id.button_selection); //select button
        noOfDaysAdded = findViewById(R.id.number);  //the number given by the user

        //new object currentDate
        Date currentDate = new Date();
        //print the current date
        currentDateView.setText(currentDate.getCalendar());

        //make the enter key call the MainActivity2
        noOfDaysAdded.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                //is it the right action
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN)
                    //is it the right key
                    if(i == KeyEvent.KEYCODE_ENTER){
                       openMainActivity2();
                       return true;
                    }
                return false;
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }
        });
    }

    public void openMainActivity2(){
        if(!noOfDaysAdded.getText().toString().isEmpty()){
            int date = Integer.valueOf(noOfDaysAdded.getText().toString()); //convert the string to number
            int dateIncrease = date; //calculate no. of days

            if(item_selection == 1){
                dateIncrease = date * 7; //increase the days by 7
            }else if(item_selection == 2){
                dateIncrease = date * 30; //increase the days by 30

            }else if(item_selection == 3){
                dateIncrease = date * 365; //increase the days by 365
            }

            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra(EXTRA_NUMBER, dateIncrease); //send the number to mainActivity2
            startActivity(intent);
        }else{
            //Error message
            Toast.makeText(getApplicationContext(), "Invalid Input!", Toast.LENGTH_LONG).show();
        }


    }

    public void selectDate(View view){
        registerForContextMenu(view);
        openContextMenu(view);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_options,menu);
        MenuItem item_days = menu.findItem(R.id.id_days);
        MenuItem item_weeks = menu.findItem(R.id.id_weeks);
        MenuItem item_months = menu.findItem(R.id.id_months);
        MenuItem item_years = menu.findItem(R.id.id_years);

        if(item_selection == 3){
            item_years.setChecked(true);
        }else if(item_selection == 1){
            item_weeks.setChecked(true);
        }else if(item_selection == 2){
            item_months.setChecked(true);
        }else if(item_selection == 0){
            item_days.setChecked(true);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_days:

                Toast.makeText(getApplicationContext(), "Days Selected", Toast.LENGTH_LONG).show();
                item.setChecked(true);
                item_selection = 0;
                return true;

            case R.id.id_weeks:

                Toast.makeText(getApplicationContext(), "Weeks Selected", Toast.LENGTH_LONG).show();
                item.setChecked(true);
                item_selection = 1;
                buttonSelection.setText("Weeks");
                return true;

            case R.id.id_months:

                Toast.makeText(getApplicationContext(), "Months Selected", Toast.LENGTH_LONG).show();
                item.setChecked(true);
                item_selection = 2;
                buttonSelection.setText("Months");
                return true;

            case R.id.id_years:

                Toast.makeText(getApplicationContext(), "Years Selected", Toast.LENGTH_LONG).show();
                item.setChecked(true);
                item_selection = 3;
                buttonSelection.setText("Years");
                return true;
        }
        return super.onContextItemSelected(item);
    }
}