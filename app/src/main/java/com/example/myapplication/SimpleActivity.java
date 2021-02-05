package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

//appcompatactivity to be compatible with older devices
public class SimpleActivity extends AppCompatActivity {

    //final means its not changeable
    private final String LOG_STR = "Help!";
    private final String ON_CREATE = "in OnCreate!";
    private final String S_TAG = "in OnStart";
    private final String R_TAG = "in OnResume";
    private final String P_TAG = "in OnPaused";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //saved on solid state drive
        super.onCreate(savedInstanceState);

        Log.i(ON_CREATE, "Started onCreate");

        //setContentView to activity simple
        setContentView(R.layout.activity_simple);

        //bars
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //-------------------------------

        //android creates a resource class
        Button altButton = findViewById(R.id.alt_button);

        altButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent is way to communicate with other activity
                Intent intent = new Intent(SimpleActivity.this,AltActivity.class);
                startActivity(intent);
            }
        });

        //bind button to the screen the bacon button  we want it to do something
        Button baconButton = findViewById(R.id.b_button);

        //do something *unfinished*
        baconButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Hello!", Toast.LENGTH_LONG).show();
            }
        });


        //floating circle button (floating action bar)
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Log.i(LOG_STR,"Im Drowning!");

            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i(S_TAG, "Stopped to Pause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i(R_TAG, "Paused to resumed");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i(P_TAG, "Resumed to Paused");
    }

}