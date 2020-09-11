package ru.istislav.infrmr.data;

import java.util.ArrayList;

interface ArticleListAsyncResponse {
    void processFinish(ArrayList<Article> articles);
}
