package com.example.myapplicationdemo;

import android.os.Bundle;
import android.text.Html;

import androidx.appcompat.app.AppCompatActivity;

public class Doctwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctwo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"red\">"+ getString(R.string.app_name)+"</font>"));
    }
}