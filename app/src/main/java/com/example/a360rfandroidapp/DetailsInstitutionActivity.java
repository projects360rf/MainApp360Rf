package com.example.a360rfandroidapp;

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
        joinBtn = findViewById(R.id.join_institution);

        title_inst.setText(title);
        desc_inst.setText(desc);
        Picasso.get().load(img).into(imageView);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailsInstitutionActivity.super.onBackPressed();
            }
        });
    }
}
