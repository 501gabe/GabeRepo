package com.gabe.android.aca.temperatureconeversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mFah;
    TextView mCel;
    TextView mOutputTextView;
    Button mConvertButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFah = (TextView) findViewById(R.id.FahText);
        mCel = (TextView) findViewById(R.id.CelText);
        mOutputTextView = (TextView) findViewById(R.id.outputText);
        mConvertButton = (Button) findViewById(R.id.calcbutton);


        mConvertButton.setOnClickListener(new View.OnClickListener() {
            String  currentFah;
            String  convertedTemp;
            String currentCel;

            public void onClick(View view) {

                if(!mFah.getText().toString().equals ("")) {
                    currentFah = mFah.getText().toString();
                    int fahValue = Integer.parseInt(currentFah);

                    fahValue = fahValue - 32;
                    fahValue = fahValue / 9;
                    fahValue = fahValue * 5;

                    convertedTemp = String.valueOf(fahValue);

                    mOutputTextView.setText(currentFah + "fahrenheit is " + convertedTemp + " celsius.");
                    mFah.setText("");

                    mCel.setText(convertedTemp);

                } else if (!mCel.getText().toString().equals("")) {
                    currentCel = mCel.getText().toString();
                    int celValue = Integer.parseInt(currentCel);

                    celValue = celValue * 9;
                    celValue = celValue / 5;
                    celValue = celValue + 32;

                    convertedTemp = String.valueOf(celValue);

                    mOutputTextView.setText(currentCel + "celsius is " + convertedTemp + "fahrenheit");
                    mCel.setText("");


                }


            }

        });

        mFah.getText();

        float fah = 86; //fahrenheit
        System.out.println(fah + "degrees in Fahrenheit is....");
        //to convert Faherenheit to Celsius
        //begin by subtracting 32
        fah = fah - 32;
        //Divide the answer by 9
        fah = fah/9;
        //Multiply that answer by 5
        fah = fah * 5;
        System.out.println(fah + "degrees Celsius \n");


        float cel = 33; //Celsius
        System.out.println(cel + "degrees Celsius is ...");
        //To convert Celsius into Fahrenheit
        // begin by multipling by 9
        cel = cel + 32;
        System.out.println(cel + "degrees Fahrenheit");

Student student1 = new Student(1234, "David");




    }
private class Student {
    int id;
    double balance;
    String studentName;



ç
        Student (int i, String name, double balance ){
            id = 1;
            studentName = name;
            lunchBalance = balance;

    }

}





