package com.example.a360rfandroidapp.Department.ModelClass;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a360rfandroidapp.Department.DepartmentDetails.DepartScreen;
import com.example.a360rfandroidapp.Department.DepartmentDetails.DepartmentDetails;
import com.example.a360rfandroidapp.Department.DepartmentFragment;
import com.example.a360rfandroidapp.R;

import java.util.ArrayList;

public class AdapterforDepartment extends RecyclerView.Adapter<AdapterforDepartment.viewModel> {
    ArrayList<ModelClassForDepart> list;
    Context context;

    public AdapterforDepartment(ArrayList<ModelClassForDepart> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.departmentdesign,null,false);


        return new viewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewModel holder, int position) {
        ModelClassForDepart mysen=list.get(position);
        holder.mydepartm.setText(mysen.getDepaname());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mydepin=new Intent(context, DepartScreen.class);
                mydepin.putExtra("mydepart",holder.mydepartm.getText());

                mydepin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(mydepin);


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class viewModel extends RecyclerView.ViewHolder {
        TextView mydepartm;
        public viewModel(@NonNull View itemView) {
            super(itemView);
            mydepartm=itemView.findViewById(R.id.deparname);


        }
    }
}
