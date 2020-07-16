package com.Final.karuna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.Final.karuna.home.MainHomeFragment;
import com.Final.karuna.mentalfitness.MainMentalFitnessFragment;
import com.Final.karuna.physicalfitness.MainPhysicalFitnessFragment;
import com.Final.karuna.spiritualfitness.MainSpiritualFragment;
import com.Final.karuna.videos.MainVideosFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainBottomNavigation extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bottom_navigation);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_main);
        bottomNav.setOnNavigationItemSelectedListener(navlistener);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                new MainHomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.home_item:
                            selectedFragment = new MainHomeFragment();
                            break;

                        case R.id.physical_item:
                            selectedFragment = new MainPhysicalFitnessFragment();
                            break;

                        case R.id.mental_item:
                            selectedFragment = new MainMentalFitnessFragment();
                            break;

                        case R.id.spiritual_item:
                            selectedFragment = new MainSpiritualFragment();
                            break;

                        case R.id.videos_item:
                            selectedFragment = new MainVideosFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}