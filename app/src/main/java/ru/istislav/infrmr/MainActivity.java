package ru.istislav.infrmr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.istislav.infrmr.data.ArticleData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ArticleData().getNewsList();
    }
}