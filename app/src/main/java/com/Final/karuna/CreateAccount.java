package com.Final.karuna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.Final.karuna.admin.AdminAddArticles;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CreateAccount extends AppCompatActivity {

    private TextInputEditText u_name, u_email, u_password;
    private AppCompatButton create, gotologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        u_name = findViewById(R.id.user_name);
        u_email = findViewById(R.id.user_email);
        u_password = findViewById(R.id.user_password);
        create = findViewById(R.id.create);
        gotologin = findViewById(R.id.bn_goto_login);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = u_name.getText().toString();
                String email = u_email.getText().toString();
                String password = u_password.getText().toString();

                String method = "register";
                BackGroundTask backGroundTask = new BackGroundTask(CreateAccount.this);
                backGroundTask.execute(method, username, email, password);
                finish();
            }
        });

        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateAccount.this, MainBottomNavigation.class));
            }
        });
    }


}