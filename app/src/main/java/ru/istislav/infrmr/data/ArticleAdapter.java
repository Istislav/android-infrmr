package ru.istislav.infrmr.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.istislav.infrmr.R;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    ArrayList<Article> articles = new ArrayList<>();
    Context context;

    public ArticleAdapter(ArrayList<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View articleRow = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_row, parent, false);
        return new ViewHolder(articleRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder holder, int position) {
        Article article = articles.get(position);
        // this is our viewholder with class ViewHolder at the bottom
        holder.title.setText(article.getTitle());
        holder.description.setText(article.getDescription());
        holder.date.setText(article.getPublishedDate());
        holder.author.setText(article.getAuthor());
    }

    @Override
    public int getItemCount() {
        return articles.size(); // Important! If this returns 0, adapter will be empty!
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView articleImage;
        public TextView author, description, title, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            articleImage = itemView.findViewById(R.id.newsImageId);
            author = itemView.findViewById(R.id.author);
            description = itemView.findViewById(R.id.descriptionNews);
            title = itemView.findViewById(R.id.newsTitle);
            date = itemView.findViewById(R.id.date);
        }
    }
}
