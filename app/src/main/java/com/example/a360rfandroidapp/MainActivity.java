package com.example.a360rfandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer_1;
    private NavigationView navigation_1;
    private Toolbar toolbar_1;
    private ActionBarDrawerToggle toggle_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer_1 = findViewById(R.id.drawer_1);
        navigation_1 = findViewById(R.id.side_navigation_1);
        toolbar_1 = findViewById(R.id.toolbar_1);


        setSupportActionBar(toolbar_1);

        toggle_1 = new ActionBarDrawerToggle(this, drawer_1, toolbar_1,
                R.string.open, R.string.close);

        drawer_1.addDrawerListener(toggle_1);
        toggle_1.syncState();

        navigation_1.setNavigationItemSelectedListener(this);


        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigation_1.setCheckedItem(R.id.home);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
        drawer_1.closeDrawer(GravityCompat.START);

        switch (item.getItemId()){

            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.department:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DepartmentFragment()).commit();
                break;
            case R.id.institution:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InstitutionFragment()).commit();
                break;
            case R.id.activity:
                Intent intent_1 = new Intent(this, mainNewsOurActivityPage.class);
                startActivity(intent_1);
                break;
            case R.id.join:
                Toast.makeText(getApplicationContext(), "Feature To Be Added Soon", Toast.LENGTH_SHORT).show();
                break;

            case R.id.internship:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InternshipFragment()).commit();
                break;

            case R.id.profile:
                Toast.makeText(getApplicationContext(), "Feature To Be Added Soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactFragment()).commit();
                break;
            case R.id.about:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AboutFragment()).commit();
                Intent intent_2 = new Intent(this, mainAboutPage.class);
                startActivity(intent_2);
                break;
            case R.id.website:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WebsiteFragment()).commit();
                break;

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer_1.isDrawerOpen(GravityCompat.START)){
            drawer_1.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}