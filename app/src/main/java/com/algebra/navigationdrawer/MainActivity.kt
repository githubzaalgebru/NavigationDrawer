package com.algebra.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity( ) {

    private  lateinit var mDrawerLayout : DrawerLayout

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        mDrawerLayout = findViewById( R.id.driver_layout )
        val toolbar : Toolbar = findViewById( R.id.toolbar )
        setSupportActionBar( toolbar )

        val actionbar : ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled( true )
            setHomeAsUpIndicator( R.mipmap.ic_launcher_round )
        }

        val navigationView : NavigationView = findViewById( R.id.nav_view )
        navigationView.setNavigationItemSelectedListener { menuItem ->
           when( menuItem.itemId ) {
               R.id.nav_profile -> {
                    supportFragmentManager
                        .beginTransaction( )
                        .replace( R.id.fragment_container, GreenFragment( ) )
                        .commit( )

               }
               R.id.nav_offer -> {
                   supportFragmentManager.fragments.forEach {
                       supportFragmentManager
                           .beginTransaction( )
                           .remove( it )
                           .commit( )
                   }
               }
               R.id.nav_wallet -> {
                   supportFragmentManager
                       .beginTransaction( )
                       .replace( R.id.fragment_container, GreenFragment( ) )
                       .commit( )

               }
               R.id.nav_settings -> {
                   supportFragmentManager.fragments.forEach {
                       supportFragmentManager
                           .beginTransaction( )
                           .remove( it )
                           .commit( )
                   }
               }
           }
            menuItem.isChecked = true
            mDrawerLayout.closeDrawers( )
            true
        }
    }

    override fun onOptionsItemSelected( item : MenuItem ): Boolean {
        if( item.itemId==android.R.id.home ) {
            mDrawerLayout.openDrawer( ( GravityCompat.START ) )
            return true
        }
        return super.onOptionsItemSelected( item )
    }
}