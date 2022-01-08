package com.example.myapplicationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
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

public class Medicine_book extends AppCompatActivity {
    ListView listViewId1;
    SearchView searchView;
    ArrayList<itemModel> arrayList;
    private CustomAdapter  customAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine_book);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"red\">"+ getString(R.string.app_name)+"</font>"));
        listViewId1 =  findViewById(R.id.listViewId);
        searchView = findViewById(R.id.searchViewId);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RequestQueue queue = Volley.newRequestQueue(Medicine_book.this);
        String url ="https://mahim2798.000webhostapp.com/medicine_show.php";
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
                                String medicine_name = jsonObject.getString("medicine_name");
//                                String dose = jsonObject.getString("dose");
//                                String prize = jsonObject.getString("prize");
//                                String doctorDetails = jsonObject.getString("doctorDetails");
                                /*itemModel model = new itemModel();
                                model.setId(id)
;
                                model.setName(name);
                                arrayList.add(model);*/
                                NameArray.add(medicine_name);
//                                NameArray.add(dose);
//                                NameArray.add(prize);
//                                NameArray.add(doctorDetails);

                                //Toast.makeText(Medicine_details.this,response.toString(), Toast.LENGTH_SHORT).show();


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Medicine_book.this,R.layout.sample_view,R.id.textViewId,NameArray);
                        listViewId1.setAdapter(adapter);
//                        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(Search.this, android.R.layout.simple_list_item_1,NameArray);
//                        listView.setAdapter(myAdapter);
                        // ArrayAdapter

                        // Toast.makeText(MainActivity2.this, "Abcd", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String sm = error.getMessage();
                        Toast.makeText(Medicine_book.this,sm, Toast.LENGTH_SHORT).show();

                    }
                });
        queue.add(jsonObjectRequest);
        listViewId1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String fullname =listViewId1.getAdapter().getItem(position).toString();
                //long abc =listViewId1.getAdapter().getItemId(position);

                //Toast.makeText(MainActivity2.this,fullname, Toast.LENGTH_SHORT).show();
                Intent bucket = new Intent(Medicine_book.this, Medicinebook_details.class);
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