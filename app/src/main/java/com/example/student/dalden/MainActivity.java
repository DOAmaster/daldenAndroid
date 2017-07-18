package com.example.student.dalden;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView mTextView = (TextView) findViewById(R.id.mainText);
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
}
