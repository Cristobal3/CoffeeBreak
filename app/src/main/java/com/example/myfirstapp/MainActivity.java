package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /* Called when the user taps the Send button */

    /*Called when the user clicks on page1 button */
    public void redirect1(View view) {
        // Do something in response to button
        int id = view.getId();

        switch (id) {
            case R.id.button1:
                Intent intent = new Intent(this, Page1.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(this, Page2.class);
                startActivity(intent2);
                break;

        }
    }

}
