package com.trishasofttech.cricketlive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
/*Addtion of two no in c lanuage*/
    /*declare the variable*/
    /*int a,b,d;*/
    /*declare the java object from xml widgets*/
    String url = "http://cricapi.com/api/matchCalendar?apikey=QU2rB4akb2SbwAmUFTwtZQ8whBX2";
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        /*make recyclerview in list form*/
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        /*attach linearlayoutmanager to recyclerview for list form*/
        recyclerView.setLayoutManager(layoutManager);
        /*recyclerview fixed view size*/
        recyclerView.setHasFixedSize(true);

        /*GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);*/
        showdata();
    }
    private void showdata() {
        /*pass 3 parameters 1: url- api address, 2: Interface, Response.Listener<String> to show the server data*/
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                /*show the server data into textview*/
                DataModel dataModel = new DataModel();
                dataModel.dataparsing(response);

                /*to pass the data from data model to adapter class*/
                MyAdapter myAdapter = new MyAdapter(getApplicationContext(), DataModel.title/*pawan*/, DataModel.date);
                /*to display the data into recyclerview*/
                recyclerView.setAdapter(myAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue rq = Volley.newRequestQueue(MainActivity.this);
        rq.add(stringRequest);
    }
}
