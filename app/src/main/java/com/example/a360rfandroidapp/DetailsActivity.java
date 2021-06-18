package com.example.a360rfandroidapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    TextView titleEt,dateEt,descEt;
    ImageView imageView;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle extras=this.getIntent().getExtras();
        String title=extras.getString("name");
        String desc=extras.getString("desc");
        String date=extras.getString("date");
        String img=extras.getString("image");
        titleEt=findViewById(R.id.title);
        dateEt=findViewById(R.id.date);
        descEt=findViewById(R.id.desc);
        imageView=findViewById(R.id.img);
        backBtn=findViewById(R.id.backbtn);
        titleEt.setText(title);
        dateEt.setText(" "+date);
        descEt.setText(desc);
        Picasso.get().load(img).into(imageView);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsActivity.super.onBackPressed();
            }
        });
    }

}