package com.Final.karuna.physicalfitness.yoga;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.Final.karuna.R;

public class YogaBeginner extends AppCompatActivity implements View.OnClickListener {

    private Button pragyaYog, suryaNamaskar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.physical_yoga_beginner);

        pragyaYog = findViewById(R.id.bn_pragya_yog);
        suryaNamaskar = findViewById(R.id.bn_surya_namaskar);
        pragyaYog.setOnClickListener(this);
        suryaNamaskar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bn_pragya_yog:
                startActivity(new Intent(YogaBeginner.this, PragyaYog.class));
                break;

            case R.id.bn_surya_namaskar:
                startActivity(new Intent(YogaBeginner.this, SuryaNamaskar.class));
                break;
        }
    }
}