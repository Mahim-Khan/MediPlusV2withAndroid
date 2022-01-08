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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Medicinebook_details extends AppCompatActivity {
    ListView listView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinebook_details);
        listView =  findViewById(R.id.listViewId);
        textView = findViewById(R.id.textViewId1);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"red\">"+ getString(R.string.app_name)+"</font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            String value = bundle.getString("sample_name");
            textView.setText(value);
        }

        RequestQueue queue = Volley.newRequestQueue(Medicinebook_details.this);

        String url= "https://mahim2798.000webhostapp.com/medicine_details.php?name='"+textView.getText().toString()+"'&type='Medicine'";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        List<String> NameArray = new ArrayList<String>();

                        try {
                            JSONArray array = response.getJSONArray("data");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject jsonObject = array.getJSONObject(i);

                                String id = jsonObject.getString("id");
                                String dise_id = jsonObject.getString("dise_id");
                                String prefecture = jsonObject.getString("prefecture");
                                String medicine_n = jsonObject.getString("medicine_n");
                                String dose = jsonObject.getString("dose");
                                String prize = jsonObject.getString("prize");
                                String doctorDetails = jsonObject.getString("doctorDetails");

//                                        ArrayList<Object> list = new ArrayList <>();
//                                        list.add(medicine_n);
//                                        list.add(dose);
//                                        list.add(prize);
//                                        list.add(doctorDetails);
//                                        list;
                                NameArray.add(dose+"\n"+prize+"\n"+doctorDetails);
//                                NameArray.add(dose);
//                                NameArray.add(prize);
//                                NameArray.add(doctorDetails);



                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Medicinebook_details.this,R.layout.sampleview3,R.id.textViewId,NameArray);
                        listView.setAdapter(adapter);




                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String sm = error.getMessage();
                        Toast.makeText(Medicinebook_details.this,sm, Toast.LENGTH_SHORT).show();

                    }
                });
        queue.add(jsonObjectRequest);

    }
}