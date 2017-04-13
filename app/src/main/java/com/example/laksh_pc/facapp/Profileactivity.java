package com.example.laksh_pc.facapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Profileactivity extends Activity {

    private TextView tvEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity);
        tvEmail = (TextView) findViewById(R.id.emailprof);
        tvEmail.setText(getIntent().getExtras().getString("Email"));
    }
}
