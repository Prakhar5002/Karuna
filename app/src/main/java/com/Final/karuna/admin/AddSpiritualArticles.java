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

public class AddSpiritualArticles extends AppCompatActivity {

    EditText title, content;
    String stitle, scontent;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_spiritual_articles);

        title = findViewById(R.id.add_s_article_title);
        content = findViewById(R.id.add_s_article_content);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null && networkInfo.isConnected()){
            //textview.setVisibility(View.INVISIBLE);
        }
        else {
            //otherwise hide all the content
        }

        save = findViewById(R.id.save_spiritual_article);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stitle = title.getText().toString();
                scontent = content.getText().toString();
                String method = "spiritual_articles";
                SetArticlesData setArticlesData = new SetArticlesData(AddSpiritualArticles.this);
                setArticlesData.execute(method, stitle, scontent);
                finish();
            }
        });
    }
}