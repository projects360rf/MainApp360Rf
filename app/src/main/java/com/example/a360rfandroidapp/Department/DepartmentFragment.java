package com.example.a360rfandroidapp.Department;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a360rfandroidapp.Department.ModelClass.AdapterforDepartment;
import com.example.a360rfandroidapp.Department.ModelClass.ModelClassForDepart;
import com.example.a360rfandroidapp.R;

import java.util.ArrayList;

public class DepartmentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView;

        View view= inflater.inflate(R.layout.fragment_department, container, false);
        recyclerView=view.findViewById(R.id.deparrecy);
        ArrayList<ModelClassForDepart> mydepar=new ArrayList<>();
        mydepar.add(new ModelClassForDepart("Agriculture"));
        mydepar.add(new ModelClassForDepart("Data Management and Analysis"));
        mydepar.add(new ModelClassForDepart("Department of Rural Development"));
        mydepar.add(new ModelClassForDepart("Energy"));
        mydepar.add(new ModelClassForDepart("Health"));
        mydepar.add(new ModelClassForDepart("Industries"));
        mydepar.add(new ModelClassForDepart("Enviromnet & Natural Resources"));
        mydepar.add(new ModelClassForDepart("Financial Resources"));
        mydepar.add(new ModelClassForDepart("Human Resources and Development"));
        mydepar.add(new ModelClassForDepart("Project Management & Appraisal"));
        mydepar.add(new ModelClassForDepart("Public Private Partnership"));
        mydepar.add(new ModelClassForDepart("Science & Technology"));
        mydepar.add(new ModelClassForDepart("Skill Development & Empolyment"));
        mydepar.add(new ModelClassForDepart("Social Justice and Empowerment"));
        mydepar.add(new ModelClassForDepart("Urban Development"));
        mydepar.add(new ModelClassForDepart("Voluantry Action Cell"));
        mydepar.add(new ModelClassForDepart("Water & Land Resources"));



        AdapterforDepartment myarrya=new AdapterforDepartment(mydepar,getContext());
        recyclerView.setAdapter(myarrya);
        LinearLayoutManager mylay=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(mylay);



        return view;
    }
}
