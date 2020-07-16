package com.Final.karuna.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.Final.karuna.R;
import com.Final.karuna.SetArticlesData;

public class AddPhysicalArticles extends AppCompatActivity {

    EditText title, content;
    String stitle, scontent;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_physical_articles);

        title = findViewById(R.id.add_p_article_title);
        content = findViewById(R.id.add_p_article_content);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null && networkInfo.isConnected()){
            //textview.setVisibility(View.INVISIBLE);
        }
        else {
            //otherwise hide all the content
        }

        save = findViewById(R.id.save_physical_article);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stitle = title.getText().toString();
                scontent = content.getText().toString();
                String method = "physical_articles";
                SetArticlesData setArticlesData = new SetArticlesData(AddPhysicalArticles.this);
                setArticlesData.execute(method, stitle, scontent);
                finish();
            }
        });
    }
}