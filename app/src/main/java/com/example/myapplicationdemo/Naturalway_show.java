package com.example.myapplicationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Naturalway_show extends AppCompatActivity {
    ListView listView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naturalway_show);
        listView = findViewById(R.id.listViewId);
        textView = findViewById(R.id.textView1);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"red\">"+ getString(R.string.app_name)+"</font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<String> numbersList = (ArrayList<String>) getIntent().getSerializableExtra("strings");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Naturalway_show.this,R.layout.sampleview3,R.id.textViewId,numbersList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Intent intent = new Intent(Naturalway_show.this, com.example.myapplicationdemo.Reference.class);
                    startActivity(intent);



//                Intent intent = new Intent(Naturalway_show.this, com.example.myapplicationdemo.Reference.class);
//                startActivity(intent);


            }
        });


    }
}