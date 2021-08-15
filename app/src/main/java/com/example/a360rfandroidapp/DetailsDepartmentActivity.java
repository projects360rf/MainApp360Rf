package com.example.a360rfandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        joinBtn = findViewById(R.id.demoTestingButton);

        title_dept.setText(title);
        desc_dept.setText(desc);
        //Picasso.get().load(img).into(imageView);

        String s=img;
        if(s.contains("drive"))
        {
            //you have to get the part of the link 0B9nFwumYtUw9Q05WNlhlM2lqNzQ
            String[] p=s.split("/");
            //Create the new image link
            String imageLink="https://drive.google.com/uc?export=download&id="+p[5];
            Picasso.get().load(imageLink).into(imageView);
        }
        else{
            Picasso.get().load(s).into(imageView);
        }

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DifferentFormOptions.class);
                i.putExtra("type","Individual");
                startActivity(i);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsDepartmentActivity.super.onBackPressed();
            }
        });
    }
}