package com.example.a360rfandroidapp.Department.DepartmentDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.a360rfandroidapp.R;

public class DepartScreen extends AppCompatActivity {
    TextView mysavetext,detailss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depart_screen);
        mysavetext=findViewById(R.id.mydeparname);
        detailss=findViewById(R.id.details);
        Bundle mycatch=getIntent().getExtras();
        String mydpat=mycatch.getString("mydepart");


        mysavetext.setText(mydpat);



    }
}