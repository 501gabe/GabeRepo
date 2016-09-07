package com.gabe.android.aca.daycounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int yearIn = 2016;

        //int monthIn = 1;

        for (int month = 1; month < 13; month ++) {
            for (int days = 1; days <= countDays(month, yearIn); days ++)
                System.out.println(month + "/" + days + "/ " + yearIn);
            }

       // while (days < 32) {;
        //    days++;
        }
        //System.out.println(monthIn + "/" + yearIn + "has " + countDays(monthIn, yearIn) + " days.");



    private int countDays(int month, int year) {
        int count = -1;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;
            case 2:
                if (year % 4 == 0) {
                    count = 29;
                } else {
                    count = 28;
                }

                if ((year % 100 == 0) && (year % 400 != 0)) {
                    count = 28;
                }
        }
        return count;


    }


}

/*  constuctor for this program

public class Daycounter {
private int mMonth;
private int mYear;

DayCounter (int m, int y) {
    mMonth = m;
    mYear = y;
}
 */

