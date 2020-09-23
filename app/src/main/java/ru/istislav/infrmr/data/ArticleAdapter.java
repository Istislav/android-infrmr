package ru.istislav.infrmr.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ru.istislav.infrmr.R;
import ru.istislav.infrmr.util.Util;

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
    public void onBindViewHolder(@NonNull final ArticleAdapter.ViewHolder holder, int position) {
        Article article = articles.get(position);
        // this is our viewholder with class ViewHolder at the bottom
        holder.title.setText(article.getTitle());
        holder.description.setText(article.getDescription());
        holder.date.setText(Util.dateFormatted(article.getPublishedDate()));
        holder.author.setText(article.getAuthor());

        Picasso.get().load(article.getImageUrl()).into(holder.articleImage);


        BitmapDrawable bitmapDrawable = (BitmapDrawable) holder.articleImage.getDrawable();
        if(bitmapDrawable != null) {
            Bitmap photo = bitmapDrawable.getBitmap();
            Palette.from(photo).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(@Nullable Palette palette) {
                    int bgColor = palette.getVibrantColor(ContextCompat.getColor(context, android.R.color.black));
                    holder.date.setBackgroundColor(bgColor);
                    holder.author.setTextColor(bgColor);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return articles.size(); // Important! If this returns 0, adapter will be empty!
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView articleImage;
        public TextView author, description, title, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this); // registering clicking on the view

            articleImage = itemView.findViewById(R.id.newsImageId);
            author = itemView.findViewById(R.id.author);
            description = itemView.findViewById(R.id.descriptionNews);
            title = itemView.findViewById(R.id.newsTitle);
            date = itemView.findViewById(R.id.date);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Preved Medved", Toast.LENGTH_SHORT).show();
        }
    }
}
