package com.gabe.android.aca.marsrobot;

/**
 * Created by Gabe on 8/24/16.
 */
public class MarsRobot {


    String status;
    int speed;
    float temperature;
    int power;
    float battery;

    void checkTemperature() {
        if (temperature < -80) {
            status = "rerturning home";
            speed = 5;
        }
    }

    void showAttribute() {
        System.out.println("Status:  " + status);
        System.out.println("Speed:  " + speed);
        System.out.println("Temperature:  " + temperature);
        System.out.println("battery: " + battery);
        System.out.println("Power: " + power);
    }

    void checkPower() {
        if (power == 1) {
            status = "Robot is powered on, battery is good";
            battery = 4;
        }
    }


}





