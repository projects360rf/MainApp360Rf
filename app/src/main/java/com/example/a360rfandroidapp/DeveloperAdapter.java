package com.example.a360rfandroidapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.ViewHolder> {

    private ArrayList<DeveloperData> developerDataArrayList;
    private Context context;

    public DeveloperAdapter(ArrayList<DeveloperData> developerDataArrayList, Context context) {
        this.developerDataArrayList = developerDataArrayList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public DeveloperAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_developer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DeveloperAdapter.ViewHolder holder, int position) {
        DeveloperData developerData = developerDataArrayList.get(position);

        holder.name.setText(developerData.getName());
        holder.post.setText(developerData.getPost());
        //holder.mail.setText(developerData.getMail());
        //holder.linkdin.setText(developerData.getLinkedin());
        holder.linkdin.setContentDescription(developerData.getLinkedin());
        holder.mail.setContentDescription(developerData.getMail());

        /*
        holder.mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"+holder.mail.getHint().toString()));
                context.startActivity(intent);
            }
        });

        holder.linkdin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(holder.linkdin.getHint().toString()));
                context.startActivity(intent);
            }
        });*/

        String s = developerData.getImage();
        if (s.contains("drive")) {
            String[] p = s.split("/");
            String imageLink = "https://drive.google.com/uc?export=download&id="+p[5];
            Picasso.get().load(imageLink).into(holder.image);
        } else {
            Picasso.get().load(s).into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return developerDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, post;
        private ImageView mail, linkdin, image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.developer_name);
            post = itemView.findViewById(R.id.developer_post);
            mail = itemView.findViewById(R.id.developer_email_image);
            linkdin = itemView.findViewById(R.id.developer_linkedin_image);
            image = itemView.findViewById(R.id.developer_image);
        }
    }
}
