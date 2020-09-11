package ru.istislav.infrmr.data;

import java.util.ArrayList;

interface ArticleListAsynResponse {
    void processFinish(ArrayList<Article> articles);
}
