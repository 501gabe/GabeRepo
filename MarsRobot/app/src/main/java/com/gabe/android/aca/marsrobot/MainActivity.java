package com.gabe.android.aca.marsrobot;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MarsRobot spirit = new MarsRobot();
        spirit.status = "exploring";
        spirit.speed = 2;
        spirit.temperature = -60;


        spirit.showAttribute();
        System.out.println("Increasing speed to 3");
        spirit.speed = 3;

        spirit.showAttribute();
        System.out.println("Changing temperature to -90");
        spirit.temperature = -90;

        spirit.showAttribute();
        System.out.println("Checking the temperature");
        spirit.checkTemperature();
        spirit.showAttribute();


        MarsRobot rover = new MarsRobot();
        rover.status = "Resting";
        rover.power = 1;
        rover.battery = 4;


        spirit.showAttribute();
        System.out.println("Battery has Juice");
        rover.battery = 3;

        spirit.showAttribute();
        System.out.println("Power is On");
        rover.power = 1;
    }
}
