package com.example.a360rfandroidapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class mainAboutPage extends AppCompatActivity {

    Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_about_page);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        selectedFragment = new AboutFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_new,
                selectedFragment).commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.nav_missionVision:
                            selectedFragment = new MissionVisionFragment();
                            setTitle(getString(R.string.mission_and_vision_title));
                            break;
                        case R.id.nav_choose:
                            selectedFragment = new ChooseFragment();
                            setTitle(getString(R.string.why_choose_360_title));
                            break;
                        case R.id.nav_founder:
                            selectedFragment = new FounderFragment();
                            setTitle(getString(R.string.our_founder_title));
                            break;
                        case R.id.nav_body:
                            selectedFragment = new BodyFragment();
                            setTitle(getString(R.string.general_governing_body_title));
                            break;
                        case R.id.nav_board:
                            selectedFragment = new BoardFragment();
                            setTitle(getString(R.string.board_members_title));
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_new,
                            selectedFragment).commit();

                    return true;
                }
            };
}