package com.example.myapplicationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

public class Disease_book extends AppCompatActivity {
    ListView listViewId1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_book);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"red\">"+ getString(R.string.app_name)+"</font>"));
        listViewId1 =  findViewById(R.id.listViewId);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RequestQueue queue = Volley.newRequestQueue(Disease_book.this);
        String url ="https://mahim2798.000webhostapp.com/test.php";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        /*arrayList = new ArrayList<>();*/
                        //create an array by ashraful
                        List<String> NameArray = new ArrayList<String>();

                        try {
                            JSONArray array = response.getJSONArray("data");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject jsonObject = array.getJSONObject(i);

                                String id = jsonObject.getString("id");
                                String name = jsonObject.getString("disease_name");
                                /*itemModel model = new itemModel();
                                model.setId(id)
;
                                model.setName(name);
                                arrayList.add(model);*/
                                NameArray.add(name);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //CustomAdapter adapter = new CustomAdapter(MainActivity2.this, arrayList);
                        //listViewId1.setAdapter(adapter);
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Disease_book.this,R.layout.sample_view,R.id.textViewId,NameArray);
                        listViewId1.setAdapter(adapter);

//                        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(Medicine_details.this, android.R.layout.simple_list_item_1,NameArray);
//                        listViewId1.setAdapter(myAdapter);
                        // ArrayAdapter

                        // Toast.makeText(MainActivity2.this, "Abcd", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String sm = error.getMessage();
                        Toast.makeText(Disease_book.this,sm, Toast.LENGTH_SHORT).show();

                    }
                });
        queue.add(jsonObjectRequest);
        listViewId1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String fullname =listViewId1.getAdapter().getItem(position).toString();
                //long abc =listViewId1.getAdapter().getItemId(position);

                //Toast.makeText(MainActivity2.this,fullname, Toast.LENGTH_SHORT).show();
                Intent bucket = new Intent(Disease_book.this, Medicine_type.class);
                bucket.putExtra("sample_name", fullname);
//                Bundle b = new Bundle();
//                b.putString("fullname", fullname);
//                bucket.putExtra("key",b);
                //bucket.putExtras(b);
                startActivity(bucket);

            }
        });
    }
}