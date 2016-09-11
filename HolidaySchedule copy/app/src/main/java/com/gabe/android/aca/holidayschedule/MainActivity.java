package com.gabe.android.aca.holidayschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.BitSet;

public class MainActivity extends AppCompatActivity {

    private Button Button;
    private TextView ResultText;
    private EditText day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final HolidaySchedule calendar = new HolidaySchedule();



        Button = (Button) findViewById(R.id.Button);
        day = (EditText) findViewById(R.id.day);
        ResultText = (TextView) findViewById(R.id.ResultText);

        Button.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View view) {

                int whichDay;

                if (!day.equals(""))

                {
                    try {
                        whichDay = Integer.parseInt(day.getText().toString());
                        if (calendar.isHoliday(whichDay)) {
                            System.out.println("Day number " + whichDay + " is a holiday.");
                            ResultText.setText("Day number " + whichDay + " is a holiday.");
                        } else {
                            System.out.println("Day number " + whichDay + " is not a holiday.");
                            ResultText.setText("Day number " + whichDay + " is not a holiday.");
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error:" + nfe.getMessage());
                    }
                }

            }


        })
        ;
    }

    public class HolidaySchedule {
        BitSet sked;

        public HolidaySchedule() {//This a constructor
            sked = new BitSet(365);
            int[] holiday = {1, 15, 50, 148, 185, 2456, 281, 316, 326, 359};

            for (int i = 0; i < holiday.length; i++) {
                addHoliday(holiday[i]);
            }
        }

        public void addHoliday(int dayToAdd) {
            sked.set(dayToAdd);
        }

        public boolean isHoliday(int dayToCheck) {
            return sked.get(dayToCheck);

        }

    }


}
