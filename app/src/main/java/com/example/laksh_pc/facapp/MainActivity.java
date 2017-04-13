package com.example.laksh_pc.facapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn1_Click(View v)  {
       Intent i = new Intent(MainActivity.this, Registrationactivity.class);
        startActivity(i);
    }
    public void btn2_Click(View v) {
        Intent i = new Intent(MainActivity.this, Loginactivity.class);
        startActivity(i);
    }
}
