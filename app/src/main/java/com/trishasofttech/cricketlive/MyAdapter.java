package com.trishasofttech.cricketlive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
/*declare the global objects for recieve the data from data model*/
    String [] title/*pawan*/;
    String [] date;
    Context context;

    public MyAdapter(Context context, String[] title/*pawan*/, String[] date) {
        super();
        this.context = context;
        this.title/*pawan*/ = title/*pawan*/;
        this.date = date;
    }

    /*to attach the design item xml file*/
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_allmatch,parent, false);
        MyHolder myHolder = new MyHolder(v);
        return myHolder;
    }
    /*to display the multiple data into recyclerview and attach the data from data source to view source*/
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
    /*to show the data in viewsource*/
        holder.tv_title.setText(title[position]);
        holder.tv_date.setText(date[position]);
    }
    /*to return the data size*/
    @Override
    public int getItemCount() {
        return date.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        /*declare the item layout ui components*/
        TextView tv_title, tv_date;
        public MyHolder(@NonNull View pawan) {
            super(pawan);
            /*intilize the xml components from xml to java objects*/
            tv_title = pawan.findViewById(R.id.tv_title);
            tv_date = pawan.findViewById(R.id.tv_date);
        }
    }
}
