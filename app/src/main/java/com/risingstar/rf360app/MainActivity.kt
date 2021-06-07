package com.risingstar.rf360app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var frameLayout: FrameLayout
    lateinit var navMain : NavigationView
    lateinit var drawerMain : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerMain = findViewById(R.id.drawer_main)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        frameLayout = findViewById(R.id.frame)
        navMain = findViewById(R.id.navMain)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        openInstituionFragment()

        val actionBarDrawerToggle = ActionBarDrawerToggle(this@MainActivity,drawerMain,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navMain.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_institution->{
                    openInstituionFragment()
                }
                R.id.nav_join->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,JoinUsFragment()
                    ).commit()
                    supportActionBar?.title = "Join Us"
                    drawerMain.closeDrawers()
                }
            }
            return@setNavigationItemSelectedListener true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id==android.R.id.home){
            drawerMain.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openInstituionFragment() {
        supportFragmentManager.beginTransaction().replace(
            R.id.frame,InstitutionFragment()
        ).commit()
        supportActionBar?.title = "Institutions"
        drawerMain.closeDrawers()
    }

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frame)

        when(frag){
            !is InstitutionFragment -> openInstituionFragment()

            else -> super.onBackPressed()
        }
    }

}
