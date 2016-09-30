package com.mapyo.findtravel;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.mapyo.findtravel.databinding.ActivityMainBinding;
import com.mapyo.findtravel.ui.widget.adapter.MainPagerAdapter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(binding.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.navigationView.setNavigationItemSelectedListener(this);


        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        binding.viewPager.setAdapter(mainPagerAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        binding.tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        binding.drawerLayout.closeDrawer(GravityCompat.START);

        // todo 選択されたメニューによってどうするか決める
        return true;
    }
}
