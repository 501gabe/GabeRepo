package com.gabe.android.aca.variables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VariableTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable_test);


        byte energy = 100;
            System.out.println("energy:" + energy);

        short stipend = 1000;
            if( stipend> 50)
                    System.out.println("What is my stipend amount:" + stipend);

        int classhours = 8;
            System.out.println("How many hours are you taking:" + classhours);


        long excitemment = 100000000;
            System.out.println(excitemment);

        float grade =99.9f;
            if(grade > 89.9)
                System.out.println("You have an A");

        double a = 103.243d;
            System.out.println("A =:" + a);

        boolean attendance = true;
         if( attendance = true)
             System.out.println("keep it up");

        char c = 'C';
        System.out.println(c);







}

}
