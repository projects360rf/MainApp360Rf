package com.example.a360rfandroidapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.smarteist.autoimageslider.SliderView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private LinearLayout phone, mail_1, mail_2;
    private LinearLayout instagram, linkedin;
    SliderView sliderView_home;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        instagram = root.findViewById(R.id.home_instagram_section);
        linkedin = root.findViewById(R.id.home_linkedin_section);

        phone = root.findViewById(R.id.home_phonenumber_section);
        mail_1 = root.findViewById(R.id.home_mail1_section);
        mail_2 = root.findViewById(R.id.home_mail2_section);

        sliderView_home = root.findViewById(R.id.home_slider);
        ArrayList<HomeViewModel> sliderDataArrayList = new ArrayList<>();

        sliderDataArrayList.add(new HomeViewModel(R.drawable.slider_1));
        sliderDataArrayList.add(new HomeViewModel(R.drawable.slider_2));
        sliderDataArrayList.add(new HomeViewModel(R.drawable.slider_3));
        sliderDataArrayList.add(new HomeViewModel(R.drawable.slider_4));

        HomeSliderAdapter homeSliderAdapter = new HomeSliderAdapter(getContext(), sliderDataArrayList);
        sliderView_home.setAutoCycleDirection(sliderView_home.LAYOUT_DIRECTION_LTR);
        sliderView_home.setSliderAdapter(homeSliderAdapter);
        sliderView_home.setScrollTimeInSec(2);
        sliderView_home.setAutoCycle(true);
        sliderView_home.startAutoCycle();

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl1("https://www.linkedin.com/company/360rf/");
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl2("https://www.instagram.com/360_research_foundation/?hl=en");
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+91-9471040714"));
                startActivity(intent);
            }
        });

        mail_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:contact@360rf.in"));
                startActivity(intent);
            }
        });

        mail_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:hod@360rf.in"));
                startActivity(intent);
            }
        });

        return root;
    }

    private void gotoUrl1(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void gotoUrl2(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
