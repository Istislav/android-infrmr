package ru.istislav.infrmr.data;

import android.app.VoiceInteractor;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import ru.istislav.infrmr.controller.AppController;
import ru.istislav.infrmr.util.Util;

public class ArticleData {
    ArrayList<Article> articles = new ArrayList<>();

    public void getNewsList(final ArticleListAsyncResponse callback) {
        String url = "http://newsapi.org/v2/everything?q=bitcoin&from=" + Util.getCurrentDateLine() + "&sortBy=publishedAt&apiKey=ae080eeb2454486b9a39f0dc5a4f9467";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // Log.d("NEWSSSSSSSSSSSSS:", response.toString());
                try {
                    JSONArray articleArray = response.getJSONArray("articles");

                    for (int i=0; i<articleArray.length(); i++) {
                        JSONObject articleObject = articleArray.getJSONObject(i);
                        Article article = new Article();

                        article.setAuthor(articleObject.getString("author"));
                        article.setTitle(articleObject.getString("title"));
                        article.setDescription(articleObject.getString("description"));
                        article.setNewsUrl(articleObject.getString("url"));
                        article.setImageUrl(articleObject.getString("urlToImage"));
                        article.setPublishedDate(articleObject.getString("publishedAt"));

                        articles.add(article);
                    }
                    //Log.v("Article Object:", articles.toString());

                    if(callback != null) callback.processFinish(articles);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        // my class AppController will write Json result to the request queue
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }

}
