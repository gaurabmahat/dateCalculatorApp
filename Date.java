package com.gaurav.datecalculator;

import android.widget.CalendarView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Formatter;

public class Date {
    private Calendar calendar;
    private String futureDate;

    public Date(){
        this.calendar = Calendar.getInstance();
        this.futureDate = "";
    }

    //it will give the current date
    public String getCalendar(){
        String currentDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(this.calendar.getTime());
        return currentDate;
    }

    //it will add the number of days on the current date
    public String addDate(int number){
        this.calendar.add(Calendar.DATE,number);
        this.futureDate = DateFormat.getDateInstance(DateFormat.DEFAULT).format(this.calendar.getTime());
        return this.futureDate;
    }

    public String monthName(){
        String nameOfTheMonth = String.format("%tb", this.calendar);
        return nameOfTheMonth;

    }

    public int dayOfTheMonth(){
        int day = this.calendar.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    public int monthNumber(){
        int month = this.calendar.get(Calendar.MONTH);
        return month;
    }

    public int yearNumber(){
        int year = this.calendar.get(Calendar.YEAR);
        return year;
    }

    public boolean isNewYear(){
        return monthName().equals("Jan") && dayOfTheMonth() == 1;

    }

    public boolean isWinter(){
        return monthName().equals("Jan") || monthName().equals("Feb") || monthName().equals("Mar");
    }

    public boolean isSpring(){
        return monthName().equals("Apr") || monthName().equals("May");
    }

    public boolean isSummer(){
        return monthName().equals("Jun") || monthName().equals("Jul") || monthName().equals("Aug");
    }

    public boolean isAutumn(){
        return monthName().equals("Sep") || monthName().equals("Oct") || monthName().equals("Nov")
                || monthName().equals("Dec");
    }

}
