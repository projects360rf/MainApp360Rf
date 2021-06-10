package com.example.a360rfandroidapp.Department.DepartmentDetails;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a360rfandroidapp.R;

public class DepartmentDetails extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView mysavetext;
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_department_details, container, false);

        mysavetext=view.findViewById(R.id.mydeparname);

        String mydpat=this.getArguments().getString("mydepart");
        mysavetext.setText(mydpat);

        return view;
    }
}