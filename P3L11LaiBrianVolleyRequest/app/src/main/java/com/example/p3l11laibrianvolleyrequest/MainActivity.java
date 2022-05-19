package com.example.p3l11laibrianvolleyrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    RequestQueue queue;
    String URL = "https://blaivolley.sites.tjhsst.edu/data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject("{\"data\":"+response+"}");
                    JSONArray array = object.getJSONArray("data");
                    String toPrint = "";
                    for (int id = 0;id<=3;id++)
                    {
                        JSONObject currentData = array.getJSONObject(id);
                        toPrint += "id: "+currentData.getString("id")+" | category: "+currentData.getString("category")+" / "+currentData.getString("increment")+"-"+currentData.getString("decrement")+"\n";
                    }
                    textView.setText(toPrint);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Volley error"+error.toString());
            }
        });
        queue.add(request);
    }
}