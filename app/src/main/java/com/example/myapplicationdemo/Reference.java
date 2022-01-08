package com.example.myapplicationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Reference extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"red\">"+ getString(R.string.app_name)+"</font>"));
        listView = findViewById(R.id.listViewId1);
        String[] Reference_Name = getResources().getStringArray(R.array.Reference);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Reference.this,R.layout.sampleview1,R.id.textView1,Reference_Name);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    String value = Reference_Name[position];

                }
                if (position==1){
                    String value = Reference_Name[position];

                }
                if (position==2){
                    String value = Reference_Name[position];
                }
            }
        });
    }
}