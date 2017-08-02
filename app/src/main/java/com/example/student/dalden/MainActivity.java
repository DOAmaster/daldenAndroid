package com.example.student.dalden;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    TextView goldTotal;
    TextView dimondTotal;
    TextView gemTotal;
    int gold = 0;
    int dimond = 0;
    int gem = 0;

    int data;
    private String file = "mydata";

    Random rand = new Random();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextView = (TextView) findViewById(R.id.mainText);

        setup(savedInstanceState);



    //saves the game
        final Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    data=gold;
                    try {
                        FileOutputStream fOut = openFileOutput(file,MODE_WORLD_READABLE);
                        fOut.write(data);
                        fOut.close();
                        Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });


        final Button loadButton = (Button) findViewById(R.id.saveButton);
        loadButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fin = openFileInput(file);
                    int c;
                    String temp="";
                    while( (c = fin.read()) != -1){
                        temp = temp + Character.toString((char)c);
                    }
                    //tv.setText(temp);
                    try {
                        gold = Integer.parseInt(temp);
                    } catch(NumberFormatException nfe) {
                        System.out.println("Could not parse " + nfe);
                    }

                    goldTotal = (TextView) findViewById(R.id.goldText);
                    goldTotal.setText(gold);
                    //gold = temp;
                    Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                }
            }
        });


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
                goldTotal.setText("" + gold);

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


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.student.dalden/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.student.dalden/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
