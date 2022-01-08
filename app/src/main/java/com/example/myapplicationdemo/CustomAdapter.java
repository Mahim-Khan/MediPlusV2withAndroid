package com.example.myapplicationdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONObject;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<itemModel> arrayList;

    public CustomAdapter(Context context, ArrayList<itemModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public  View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView ==  null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.sample_view, parent, false);
        }
        TextView name,medicine_name,dose,prize,doctorDetails;
        name = (TextView) convertView.findViewById(R.id.textViewId);
        name.setText(arrayList.get(position).getName());
        medicine_name = (TextView)convertView.findViewById(R.id.textViewId);
        medicine_name.setText(arrayList.get(position).getMedicine_name());
        dose = (TextView)convertView.findViewById(R.id.textViewId);
        dose.setText(arrayList.get(position).getDose());
        prize = (TextView)convertView.findViewById(R.id.textViewId);
        prize.setText(arrayList.get(position).getPrize());
        doctorDetails = (TextView)convertView.findViewById(R.id.textViewId);
        doctorDetails.setText(arrayList.get(position).getDoctorDetails());

        return convertView;
    }
}