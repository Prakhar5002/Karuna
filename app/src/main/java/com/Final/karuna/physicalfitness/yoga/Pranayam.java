package com.Final.karuna.physicalfitness.yoga;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Final.karuna.R;
import com.google.android.youtube.player.YouTubePlayerView;

public class Pranayam extends AppCompatActivity{

    private Button bhramari, anulomVilom, naadiShodhan, pranakarshan, suryaBhedi, kapaalbhati;
    Dialog dialog;
    private TextView tile, content;
    YouTubePlayerView youTubePlayerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.physical_pranayam);

        bhramari = findViewById(R.id.btn_bhramari);
        anulomVilom = findViewById(R.id.btn_Anulom_vilom);
        naadiShodhan = findViewById(R.id.btn_naadi_shodhan);
        pranakarshan = findViewById(R.id.btn_praanakarshan);
        suryaBhedi = findViewById(R.id.btn_suryabhedi);
        kapaalbhati = findViewById(R.id.btn_kapaalbhati);

        View view = getLayoutInflater().inflate(R.layout.dialog_fullscreen_ytvideo, null);
        dialog = new Dialog(this, android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        dialog.setContentView(view);
        tile = dialog.findViewById(R.id.fullscreen_dialog_title);
        content = dialog.findViewById(R.id.fullscreen_dialog_content);

        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    finish();
                    dialog.cancel();
                    startActivity(new Intent(Pranayam.this, Pranayam.class));
                }
                return true;
            }
        });

    }
}