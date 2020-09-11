package ru.istislav.infrmr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import ru.istislav.infrmr.data.Article;
import ru.istislav.infrmr.data.ArticleAdapter;
import ru.istislav.infrmr.data.ArticleData;
import ru.istislav.infrmr.data.ArticleListAsyncResponse;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ArticleData().getNewsList(new ArticleListAsyncResponse() {
            @Override
            public void processFinish(ArrayList<Article> articles) {
                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                articleAdapter = new ArticleAdapter(articles, getApplicationContext());

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(articleAdapter);
            }
        });
    }
}