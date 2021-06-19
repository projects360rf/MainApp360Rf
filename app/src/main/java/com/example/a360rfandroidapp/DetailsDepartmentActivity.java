package com.example.a360rfandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsDepartmentActivity extends AppCompatActivity {

    TextView title_dept,desc_dept;
    ImageView imageView;
    Button backBtn,joinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_details);

        Bundle extras = this.getIntent().getExtras();
        String title = extras.getString("name");
        String desc = extras.getString("desc");
        String img = extras.getString("image");

        title_dept = findViewById(R.id.title_department);
        desc_dept = findViewById(R.id.desc_department);
        imageView = findViewById(R.id.img_department);

        backBtn = findViewById(R.id.backbtn_department);
        joinBtn = findViewById(R.id.join_department);

        title_dept.setText(title);
        desc_dept.setText(desc);
        Picasso.get().load(img).into(imageView);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsDepartmentActivity.super.onBackPressed();
            }
        });
    }
}