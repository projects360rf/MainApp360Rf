package com.example.a360rfandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;
    private NavigationView navigation;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer);
        navigation = findViewById(R.id.side_navigation);
        toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.open, R.string.close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigation.setNavigationItemSelectedListener(this);


        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigation.setCheckedItem(R.id.home);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);

        switch (item.getItemId()){

            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.department:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DepartmentFragment()).commit();
                Toast.makeText(getApplicationContext(), "department", Toast.LENGTH_SHORT).show();
                break;
            case R.id.institution:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InstitutionFragment()).commit();
                Toast.makeText(getApplicationContext(), "institution", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity:
            case R.id.join:
            case R.id.profile:
                Toast.makeText(getApplicationContext(), "Feature To Be Added Soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactFragment()).commit();
                break;
            case R.id.about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutFragment()).commit();
                break;
            case R.id.nav_missionVision:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MissionVisionFragment()).commit();
                break;
            case R.id.nav_choose:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ChooseFragment()).commit();
                break;
            case R.id.nav_founder:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FounderFragment()).commit();
                break;
            case R.id.nav_body:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BodyFragment()).commit();
                break;
            case R.id.nav_board:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BoardFragment()).commit();
                break;

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}