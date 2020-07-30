package com.trishasofttech.cricketlive;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataModel {

    public static String title [];
    public static String date [];

    public void dataparsing(String response) {
        try {
            JSONObject jo = new JSONObject(response);
            JSONArray ja = jo.getJSONArray("data");
            /*to pass the length for title*/
            title = new String[ja.length()];
            date = new String[ja.length()];

            /*parsing the jsonarray data*/
            for (int i=0; i<ja.length(); i++)
            {
                JSONObject jo1 = ja.getJSONObject(i);
                title[i] = jo1.getString("name");
                date[i] = jo1.getString("date");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
