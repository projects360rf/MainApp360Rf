package com.example.a360rfandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chivorn.smartmaterialspinner.SmartMaterialSpinner;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class DifferentFormOptions extends AppCompatActivity {
    private SmartMaterialSpinner<String> individualSpinner;
    private List<String> individualList;
    Button individualBtn;
    String individual;
    int positionIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different_form_options);
        TextView typeEt=findViewById(R.id.type);
        individualBtn=findViewById(R.id.individualBtn);
        String type=getIntent().getStringExtra("type");
        typeEt.setText("Join As "+type);
        initSpinner();
        individualBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(individualSpinner.getSelectedItem()!=null)
                {
                    individual=individualSpinner.getSelectedItem().toString();
                    Intent intent = new Intent(DifferentFormOptions.this, IndividualForm.class);
                    intent.putExtra("positionIn",positionIn);
                    startActivity(intent);
                }
                else {
                    individualSpinner.setErrorText("Please Choose any of the above");
                }
            }
        });

    }
    private void initSpinner() {

        individualSpinner = findViewById(R.id.individualSpinner);
        individualList = new ArrayList<>();
        individualList.add("Youth Volunteer Form");
        individualList.add("First Aid (Membership)");
        individualList.add("360 Research and Innovation (Group Registration)");
        individualList.add("The Kraft Lady (StartUp support Application Form)");
        individualList.add("Team A (Membership Form)");
        individualList.add("Gurukul Coaching Center");
        individualList.add("Master English Classes");
        individualList.add("The Life Savers");
        individualList.add("Join Our Departments");
        individualSpinner.setItem(individualList);

        individualSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //Toast.makeText(DifferentOptions.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                individualSpinner.setErrorText("");
                positionIn=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}