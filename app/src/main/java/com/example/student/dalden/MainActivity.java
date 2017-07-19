package com.example.student.dalden;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    TextView goldTotal;
    TextView dimondTotal;
    TextView gemTotal;
    int gold = 0;
    int dimond = 0;
    int gem = 0;

    Random rand = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextView = (TextView) findViewById(R.id.mainText);

        setup(savedInstanceState);

        mTextView.setText("Gold Rush");

        final Button button = (Button) findViewById(R.id.creditsButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                //mTextView.setText("Derrick Alden");

                Toast.makeText(getApplicationContext(), "Derrick Alden", Toast.LENGTH_SHORT).show();

            }

        });

        final Button shopButton = (Button) findViewById(R.id.shopButton);
        shopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Coming Soon...", Toast.LENGTH_SHORT).show();

            }

        });

        final Button mineGoldButton = (Button) findViewById(R.id.collect);
        mineGoldButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                goldTotal = (TextView) findViewById(R.id.goldText);
                dimondTotal = (TextView) findViewById(R.id.dimondText);
                gemTotal = (TextView) findViewById(R.id.gemText);

                gold++;
                goldTotal.setText(""+gold);

                int n = rand.nextInt(100);
                if (n == 1) {
                    Toast.makeText(getApplicationContext(), "Dimond Collected", Toast.LENGTH_SHORT).show();
                    dimond++;
                    dimondTotal.setText("Dimonds: " + dimond);
                }

                int n2 = rand.nextInt(50);
                if (n2 == 1) {
                    Toast.makeText(getApplicationContext(), "Gem Collected", Toast.LENGTH_SHORT).show();
                    gem++;
                    gemTotal.setText("Gems: " + gem);
                }



                //Toast.makeText(getApplicationContext(), "Gold Collected", Toast.LENGTH_SHORT).show();

            }

        });


    }

    protected void setup(Bundle savedInstanceState) {

        //gets the mainFact textview frm the main activity
        mTextView = (TextView) findViewById(R.id.mainText);

        //sets up custom font from asset folder
        Typeface mtypeFace = Typeface.createFromAsset(getAssets(),
                "fonts/caveman.ttf");

        mTextView.setTextSize(50);
        mTextView.setTypeface(mtypeFace);

    }
}
