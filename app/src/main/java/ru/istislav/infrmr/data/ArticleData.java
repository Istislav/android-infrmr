package ru.istislav.infrmr.data;

import android.app.VoiceInteractor;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import ru.istislav.infrmr.controller.AppController;

public class ArticleData {
    ArrayList<Article> articles = new ArrayList<>();

    public void getNewsList() {
        String url = "http://newsapi.org/v2/everything?q=bitcoin&from=" + getDateLine() + "&sortBy=publishedAt&apiKey=ae080eeb2454486b9a39f0dc5a4f9467";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // Log.d("NEWSSSSSSSSSSSSS:", response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        // my class AppController will write Json result to the request queue
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }

    private String getDateLine() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // modern method (API 26)
            date = Date.from(ZonedDateTime.now().minusDays(7).toInstant());
        } else { // old method
            Calendar calendar = Calendar.getInstance();
            // calendar.add(Calendar.HOUR_OF_DAY, 24*7);
            calendar.add(Calendar.DAY_OF_MONTH, -7);
            date = calendar.getTime();
        }
        return formatter.format(date);
    }

}
