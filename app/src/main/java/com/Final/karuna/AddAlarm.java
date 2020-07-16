package com.Final.karuna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AddAlarm extends AppCompatActivity {

    SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_alarm);

        switchCompat = findViewById(R.id.remainder_switch);

        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCompat.isChecked()){
                    //
                }
                else {
                    //imageView.setImageDrawable(getResources().getDrawable(R.drawable.yog_pad_hastasana));
                }
            }
        });
    }
}