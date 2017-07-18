package com.example.student.dalden;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextView = (TextView) findViewById(R.id.mainText);

        setup(savedInstanceState);

        mTextView.setText("Hello World");

        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                mTextView.setText("Derrick Alden WEW!");

                Toast.makeText(getApplicationContext(), "DAlden", Toast.LENGTH_SHORT).show();

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
