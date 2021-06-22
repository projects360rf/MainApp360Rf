package com.example.a360rfandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class JoinFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_join, container, false);

        CardView card_individual=root.findViewById(R.id.individualCard);
        CardView card_organisation=root.findViewById(R.id.organisationCard);
        Button btn_individual=root.findViewById(R.id.individual);
        Button btn_org=root.findViewById(R.id.org);

        btn_individual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity().getApplicationContext(), DifferentFormOptions.class);
                intent.putExtra("type","Individual");
                startActivity(intent);
            }
        });

        btn_org.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity().getApplicationContext(), OrganisationForm.class);
                intent.putExtra("type","Organisation");
                startActivity(intent);
            }
        });

        return root;
    }
}
