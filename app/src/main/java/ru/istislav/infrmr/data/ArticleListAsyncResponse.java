package ru.istislav.infrmr.data;

import java.util.ArrayList;

public interface ArticleListAsyncResponse {
    void processFinish(ArrayList<Article> articles);
}
