package ru.istislav.infrmr.data;

import android.app.VoiceInteractor;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;

import ru.istislav.infrmr.controller.AppController;

public class ArticleData {
    ArrayList<Article> articles = new ArrayList<>();

    public void getNewsList() {
        String url = "http://newsapi.org/v2/everything?q=bitcoin&from=2020-08-08&sortBy=publishedAt&apiKey=ae080eeb2454486b9a39f0dc5a4f9467";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }
}
