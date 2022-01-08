package com.example.myapplicationdemo;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.text.Html;
        import android.view.View;
        import android.widget.Button;
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

public class Medicine_type extends AppCompatActivity {
    TextView textView;
    Button button,button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine_type);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"red\">"+ getString(R.string.app_name)+"</font>"));
        textView = findViewById(R.id.textViewId);
        button = findViewById(R.id.medicine_id);
        button1 = findViewById(R.id.Natural_id);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            String value = bundle.getString("sample_name");
            textView.setText(value);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(Medicine_type.this);

                String url= "https://mahim2798.000webhostapp.com/medicine_type_2.php?name='"+textView.getText().toString()+"'&type='Medicine'";

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
//                                try {
//                                    JSONArray array = response.getJSONArray("data");
//                                }catch (Exception e){
//
//                                }
                                // Log.d("Res",String.valueOf(response));
                                //ArrayList<Object> list = new ArrayList<>();

                               ArrayList NameArray = new ArrayList<String>();

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
                                        //NameArray.add(new itemModel(medicine_n,dose,prize,doctorDetails));
//                                        ArrayList<Object> list = new ArrayList <>();
//                                        list.add(medicine_n);
//                                        list.add(dose);
//                                        list.add(prize);
//                                        list.add(doctorDetails);
//                                        list;
                                        //String courseName = responseObj.getString("courseName");
                                       // String courseTracks = responseObj.getString("courseTracks");
                                       // String courseMode = responseObj.getString("courseMode");
                                       // String courseImageURL = responseObj.getString("courseimg");
                                       // ArrayList.add(new CourseModal(courseName, courseImageURL, courseMode, courseTracks));
                                        //buildRecyclerView();




                                        NameArray.add(medicine_n+"\n"+dose+"\n"+prize+"\n"+doctorDetails);

//                                        NameArray.add(dose);
//                                        NameArray.add(prize);
//                                        NameArray.add(doctorDetails);
                                        //Name.add(NameArray);
                                        //ArrayList Name = new ArrayList<String>();
                                        //itemModel stationItem = new itemModel(medicine_n,dose,prize,doctorDetails);
                                       // NameArray.listIterator();

//                                        ArrayList dataList = NameArray;
//                                        Intent intent = new Intent(Medicine_type.this, Medicine_show.class);
//                                        Bundle bundle = new Bundle();
//                                        bundle.putParcelableArrayList("data", dataList);
//                                        intent.putExtras(bundle);
//                                        startActivity(intent);
                                        //String str =""+medicine_n+"\n"+"\n"+dose+"\n"+prize+"\n"+doctorDetails;
                                        //Toast.makeText(MainActivity3.this,response.toString(), Toast.LENGTH_LONG).show();

                                       Intent intent = new Intent(Medicine_type.this, Medicine_show.class);
                                        //String[] myStrings = new String[] {"NameArray"};

                                        intent.putStringArrayListExtra("strings",NameArray);
                                        startActivity(intent);

                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }



                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                String sm = error.getMessage();
                                Toast.makeText(Medicine_type.this,sm, Toast.LENGTH_SHORT).show();

                            }
                        });
                queue.add(jsonObjectRequest);

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            String type, name;
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(Medicine_type.this);

                String url= "https://mahim2798.000webhostapp.com/medicine_type_2.php?name='"+textView.getText().toString()+"'&type='Natural way'";

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
//                                try {
//                                    JSONArray array = response.getJSONArray("data");
//                                }catch (Exception e){
//
//                                }
                                // Log.d("Res",String.valueOf(response));

                                ArrayList NameArray = new ArrayList<String>();

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

                                        //NameArray.add(dise_id);
                                        //NameArray.add(prefecture);
                                        NameArray.add(medicine_n+"\n"+doctorDetails);
//                                        NameArray.add(medicine_n);
////                                        NameArray.add(dose);
////                                        NameArray.add(prize);
//                                        NameArray.add(doctorDetails);

                                        //Toast.makeText(MainActivity3.this,response.toString(), Toast.LENGTH_LONG).show();
                                        // List<String> fullname= NameArray;
//                                        Bundle b=new Bundle();
//                                        b.putStringArray("Key",fullname);
//                                        Intent intent=new Intent(MainActivity3.this, MainActivity4.class);
//                                        intent.putExtras(b);
//                                        ArrayList<String> myStringArrayList =NameArray.t;


//                                        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
//                                        intent.putStringArrayListExtra("string-array",new ArrayList[]{ response.toString()});
//                                        startActivity(intent);
                                        Intent intent = new Intent(Medicine_type.this, Naturalway_show.class);
                                        //String[] myStrings = new String[] {"NameArray"};
                                        intent.putStringArrayListExtra("strings", NameArray);
                                        startActivity(intent);

                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }



                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                String sm = error.getMessage();
                                Toast.makeText(Medicine_type.this,sm, Toast.LENGTH_SHORT).show();

                            }
                        });
                queue.add(jsonObjectRequest);

            }
        });
    }
}
