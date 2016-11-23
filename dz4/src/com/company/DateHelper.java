package com.company;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by lushi on 21.11.2016.
 */

public class DateHelper {
   private Calendar calendar = Calendar.getInstance();

    private int day = calendar.get(Calendar.DAY_OF_MONTH);
    private int month = calendar.get(Calendar.MONTH)+1; //тк месяца нумеруются от 0
    private int year = calendar.get(Calendar.YEAR)-1500;
    private int hour = calendar.get(Calendar.HOUR);
    private int minute = calendar.get(Calendar.MINUTE);

    private int counterMin = 0;//календарь и так может хранить время и изменять его. это изобретение велосипеда.
    private int counterHour = 0;
    private int counterDay = 0;
    private int counterMonth = 0;
    private int counterYear =  0;

    public String getFormattedStartDate(){  //возвращает дату начала сражения
     return Integer.toString(day)+"."+Integer.toString(month)+"."+Integer.toString(year)+ " " + hour +":"+minute;
}
    public void skipTime() { //все это решается одной строчкой - calendar.add(Calendar.MINUTE, 30);
        counterMin += 30;

        if(counterMin >= 60){
            counterHour++;
            counterMin -= 60;
        }

        if(counterHour >= 24){
            counterDay++;
            counterHour -= 24;
        }

        if(counterDay == 30){
            counterDay -= 30;
            counterMonth++;
        }
        if(counterMonth == 12){
            counterMonth = 0;
            counterYear++;
        }

    }
    public String getFormattedDiff(){
        return counterDay + "." + counterMonth + "." + counterYear + " " + counterHour + ":" + counterMin;
    }
}
