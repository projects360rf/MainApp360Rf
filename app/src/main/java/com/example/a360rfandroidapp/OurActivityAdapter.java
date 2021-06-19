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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class OurActivityAdapter extends RecyclerView.Adapter<OurActivityAdapter.ViewHolder> {


    private ArrayList<OurActivityData> activityDataArrayList;
    private Context context;

    // creating a constructor.
    public OurActivityAdapter(ArrayList<OurActivityData> activityDataArrayList, Context context) {
        this.activityDataArrayList = activityDataArrayList;
        this.context = context;
    }


    @NonNull
    @NotNull
    @Override
    public OurActivityAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_ouractivities_item, parent, false);
        return new ViewHolder(view);
    }

    @NonNull


    @Override
    public void onBindViewHolder(@NonNull @NotNull OurActivityAdapter.ViewHolder holder, int position) {
        OurActivityData activityData = activityDataArrayList.get(position);

        // on the below line we are setting data to our text view.
        holder.name.setText(activityData.getName());
        //Picasso.get().load(activityData.getImage()).into(holder.image);

        String s=activityData.getImage();
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
        return activityDataArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating a variable for our text view and image view.
        private TextView name, date;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our variables.
            name = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getLayoutPosition();
                    String desc=activityDataArrayList.get(position).getDescription();
                    String title=activityDataArrayList.get(position).getName();
                    String date=activityDataArrayList.get(position).getDate();
                    String image=activityDataArrayList.get(position).getImage();
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
