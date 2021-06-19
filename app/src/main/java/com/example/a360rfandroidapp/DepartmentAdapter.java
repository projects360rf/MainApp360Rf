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

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.ViewHolder> {

    private ArrayList<DepartmentData> departmentDataArrayList;
    private Context context;

    public DepartmentAdapter(ArrayList<DepartmentData> departmentDataArrayList, Context context) {
        this.departmentDataArrayList = departmentDataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public DepartmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_department_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentAdapter.ViewHolder holder, int position) {
        DepartmentData departmentData = departmentDataArrayList.get(position);

        holder.name.setText(departmentData.getName());
        Picasso.get().load(departmentData.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return departmentDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating a variable for our text view and image view.
        private TextView name, date;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our variables.
            name = itemView.findViewById(R.id.name_department);
            image = itemView.findViewById(R.id.image_department);
            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getLayoutPosition();
                    String desc=departmentDataArrayList.get(position).getDescription();
                    String title=departmentDataArrayList.get(position).getName();
                    String image=departmentDataArrayList.get(position).getImage();

                    Intent intent=new Intent(context,DetailsDepartmentActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("desc",desc);
                    intent.putExtra("name",title);
                    intent.putExtra("image",image);
                    context.startActivity(intent);
                    //Toast.makeText(context,String.valueOf(""),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
