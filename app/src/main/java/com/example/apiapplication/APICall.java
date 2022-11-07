package com.example.apiapplication;

import android.app.Activity;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APICall {

    public static final List<Model> MODEL = new ArrayList<>();
    public static final Map<String, Model> MODEL_MAP = new HashMap<>();

    public void Retrieval(Activity activity)
    {
        RequestQueue q = Volley.newRequestQueue(activity);
        String url = "https://random-palette-generator.p.rapidapi.com/palette/1/5";

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
//                            JSONObject objeto = response.getJSONObject("type");
//                            JSONArray array = objeto.getJSONArray("palette");
//                            JSONArray palette = array.getJSONArray(0);
                            JSONArray data = response.getJSONArray("data");

                            MODEL.clear();
                            MODEL_MAP.clear();
                            for(int i = 0; i < data.length(); i++)
                            {
                                String json = String.valueOf(data.getJSONObject(i));
                                //System.console().printf(json);
                                Gson gson = new Gson();
                                Model model = gson.fromJson(json, Model.class);

                                MODEL.add(model);
                                MODEL_MAP.put(model.getName(), model);
                            }
                        }
                        catch(JSONException e){
                            e.printStackTrace();
                        }
                        }
                    },
                    new Response.ErrorListener(){
                                @Override
                                public void onErrorResponse(VolleyError error) {

                            }

                })

        {
            @Override
            public Map getHeaders() throws AuthFailureError{
                HashMap headers = new HashMap();
                headers.put("X-RapidAPI-Key", "a98d870eb6mshb108115e1a39e51p13879djsn413a0756c67f");
                headers.put("X-RapidAPI-Host", "random-palette-generator.p.rapidapi.com");
//                'X-RapidAPI-Key': 'a98d870eb6mshb108115e1a39e51p13879djsn413a0756c67f',
//                        'X-RapidAPI-Host': 'random-palette-generator.p.rapidapi.com'
                return headers;
            }
        };
        q.add(jsonRequest);


    }
}
