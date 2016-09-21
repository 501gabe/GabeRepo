package com.gabe.android.aca.magicball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random randGenerator = new Random();
    Button Ballbutton;
    Button Dicebutton;
    TextView ResultText;
    TextView DiceResults;


    public int RandomNumber;
    int dice1;
    int dice2;
    int dicesum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ballbutton = (Button) findViewById(R.id.Ballbutton);
        ResultText = (TextView) findViewById(R.id.ResultText);
        Dicebutton = (Button) findViewById(R.id.Dicebutton);
        DiceResults = (TextView) findViewById(R.id.DiceResults);


        Ballbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                RandomNumber = randGenerator.nextInt(20);


                switch (RandomNumber) {

                    case 1:
                        ResultText.setText("It is certain");
                        break;

                    case 2:
                        ResultText.setText("It is decidedly so");
                        break;

                    case 3:
                        ResultText.setText("Without a doubt");
                        break;

                    case 4:
                        ResultText.setText("Yes, definitely");
                        break;

                    case 5:
                        ResultText.setText("You may rely on it");
                        break;

                    case 6:
                        ResultText.setText("As I see it, yes");
                        break;

                    case 7:
                        ResultText.setText("Most likely");
                        break;

                    case 8:
                        ResultText.setText("Outlook good");
                        break;

                    case 9:
                        ResultText.setText("Yes");
                        break;

                    case 10:
                        ResultText.setText("Signs point to yes");
                        break;

                    case 11:
                        ResultText.setText("Reply hazy try again");
                        break;

                    case 12:
                        ResultText.setText("Ask again later");
                        break;

                    case 13:
                        ResultText.setText("Better not tell you now");
                        break;

                    case 14:
                        ResultText.setText("Cannot predict now");
                        break;

                    case 15:
                        ResultText.setText("Concentrate and ask again");
                        break;

                    case 16:
                        ResultText.setText("Don't count on it");
                        break;

                    case 17:
                        ResultText.setText("My reply is no");
                        break;

                    case 18:
                        ResultText.setText("My sources say no");
                        break;

                    case 19:
                        ResultText.setText("Outlook not so good");
                        break;

                    case 20:
                        ResultText.setText("Very doubtful");
                        break;


                }


            }


        });
        Dicebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                dice1 = randGenerator.nextInt(6);
                dice2 = randGenerator.nextInt(6);

               // dicesum = dice1 + dice2;

                if (dice1 == 0) {

                    dice1 = dice1 + 1;
                    dicesum = dice1 + dice2;
                } else {

                    DiceResults.setText("You rolled" + " " + dice1 + "and " + dice2 + " " + "\n" + "Your point is" + " " + dicesum);
                }

                if (dice2 == 0) {

                    dice2 = dice2 + 1;
                    dicesum = dice1 + dice2;
                } else {

                    DiceResults.setText("You rolled" + " " + dice1 + "and " + dice2 + " " + "\n" + "Your point is" + " " + dicesum);
                }
                dicesum = dice1 + dice2;



                DiceResults.setText("You rolled" + " " + dice1 + " and " + dice2 + " " + "\n" + "Your point is" + " " + dicesum);

            }
        });
    }
}