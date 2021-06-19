package com.example.a360rfandroidapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    // variable for our array list and context.
    private ArrayList<NewsData> newsDataArrayList;
    private Context context;

    // creating a constructor.
    public NewsAdapter(ArrayList<NewsData> newsDataArrayList, Context context) {
        this.newsDataArrayList = newsDataArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        NewsData newsData = newsDataArrayList.get(position);

        // on the below line we are setting data to our text view.
        holder.name.setText(newsData.getName());
        holder.date.setText(newsData.getDate());
        //Picasso.get().load(newsData.getImage()).into(holder.image);

        String s=newsData.getImage();
        if(s.contains("drive"))
        {
            //you have to get the part of the link 0B9nFwumYtUw9Q05WNlhlM2lqNzQ
            String[] p=s.split("/");
            //Create the new image link
            String imageLink="https://drive.google.com/uc?export=download&id="+p[5];
            Picasso.get().load(imageLink).into(holder.image);
        }
        else{
            Picasso.get().load(s).into(holder.image);
        }

    }

    @Override
    public int getItemCount() {
        return newsDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating a variable for our text view and image view.
        private TextView name, date;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our variables.
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.image);
            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getLayoutPosition();
                    String desc=newsDataArrayList.get(position).getDescription();
                    String title=newsDataArrayList.get(position).getName();
                    String date=newsDataArrayList.get(position).getDate();
                    String image=newsDataArrayList.get(position).getImage();
                    Intent intent=new Intent(context,DetailsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("desc",desc);
                    intent.putExtra("name",title);
                    intent.putExtra("date",date);
                    intent.putExtra("image",image);
                    context.startActivity(intent);
                    //Toast.makeText(context,String.valueOf(""),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}



