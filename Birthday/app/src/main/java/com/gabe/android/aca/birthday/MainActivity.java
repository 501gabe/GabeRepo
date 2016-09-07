package com.gabe.android.aca.birthday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int height;
        int weight;
        int depth;


        Class Birthday ;{
            String birthday = new String("01/03/1990");

            System.out.println(birthday);
            System.out.println(birthday.substring(0,2));
            System.out.println(birthday.substring(3,5));
            System.out.println(birthday.substring(6,10));






        }
    }

}
