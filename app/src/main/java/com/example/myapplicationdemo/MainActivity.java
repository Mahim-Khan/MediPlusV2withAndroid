package com.example.myapplicationdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button medicine_details,search,reference,about_us,disease_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"red\">"+ getString(R.string.app_name)+"</font>"));
        medicine_details = findViewById(R.id.medicine_details);
        search = findViewById(R.id.searchbtn);
        reference = findViewById(R.id.reference);
        about_us = findViewById(R.id.about_us);
        disease_btn = findViewById(R.id.disease_btn);

        medicine_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Medicine_book.class);
                startActivity(intent);

            }
        });
        disease_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.myapplicationdemo.Disease_book.class);
                startActivity(intent);

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.myapplicationdemo.Search.class);
                startActivity(intent);


            }
        });
        reference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,com.example.myapplicationdemo.Reference.class);
                startActivity(intent);


            }
        });
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,com.example.myapplicationdemo.About_us.class);
                startActivity(intent);


            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.gotourl){
            gotoUrl("https://sites.google.com/diu.edu.bd/medipluse/home");
            return true;
        }
        if (item.getItemId()==R.id.Feedbackid) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"mediplus2k21@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "Feedback to MediPlus");
            i.putExtra(Intent.EXTRA_TEXT   , "");
            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        if (item.getItemId()==R.id.contact_us){
            Intent intent = new Intent(MainActivity.this,com.example.myapplicationdemo.Contactus.class);
            startActivity(intent);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }


    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}

// Instantiate the RequestQueue.


//                // Request a string response from the provided URL.
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                // Display the first 500 characters of the response string.
//                                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity.this, "Error Acure", Toast.LENGTH_SHORT).show();
//                    }
//                });