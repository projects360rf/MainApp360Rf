package com.example.a360rfandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailsInstitutionActivity extends AppCompatActivity {

    TextView title_inst,desc_inst;
    ImageView imageView;
    Button backBtn,joinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institutions_details);

        Bundle extras = this.getIntent().getExtras();
        String title = extras.getString("name");
        String desc = extras.getString("desc");
        String img = extras.getString("image");

        title_inst = findViewById(R.id.title_institution);
        desc_inst = findViewById(R.id.desc_institution);
        imageView = findViewById(R.id.img_institution);

        backBtn = findViewById(R.id.backbtn_institution);
        joinBtn = findViewById(R.id.demoTestingButton);

        title_inst.setText(title);
        desc_inst.setText(desc);
        //Picasso.get().load(img).into(imageView);
        //joinBtn.setVisibility(View.VISIBLE);

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
                DetailsInstitutionActivity.super.onBackPressed();
            }
        });
    }
}
