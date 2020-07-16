package com.Final.karuna.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.Final.karuna.R;

public class AdminAddArticles extends AppCompatActivity {

    private Button physicalfitness, mentalfitness, spiritualfitness;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_articles);

        spiritualfitness = findViewById(R.id.admin_s_articles);
        mentalfitness = findViewById(R.id.admin_m_articles);
        physicalfitness = findViewById(R.id.admin_p_articles);

        spiritualfitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminAddArticles.this, AddSpiritualArticles.class));
            }
        });

        mentalfitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminAddArticles.this, AddMentalArticles.class));
            }
        });

        physicalfitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminAddArticles.this, AddPhysicalArticles.class));
            }
        });
    }
}