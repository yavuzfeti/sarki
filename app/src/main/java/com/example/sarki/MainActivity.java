package com.example.sarki;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.widget.Button;
import android.view.View;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer MuzikCalar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MuzikCalar =MediaPlayer.create(MainActivity.this, R.raw.dedubluman_merdiven);
        Button muzikcal=(Button)findViewById(R.id.muzikcalarbutton);
        Button reset=(Button)findViewById(R.id.reset);
        Button muzikdur=(Button)findViewById(R.id.musicdur);
        TextView durum=(TextView)findViewById(R.id.textView);
        String sarkiismistring=(String)"dedubluman_merdiven";
        String oynatstring=(String)"Oynatılıyor: "+sarkiismistring;
        String duraklatstring=(String)"Duraklatıldı: "+sarkiismistring;
        String resetstring=(String)"Oynat: "+sarkiismistring;

        durum.setText(sarkiismistring);

        muzikcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                MuzikCalar.start();
                durum.setText(oynatstring);
            }
        });

        muzikdur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                MuzikCalar.pause();
                durum.setText(duraklatstring);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                MuzikCalar.reset();
                MuzikCalar =MediaPlayer.create(MainActivity.this, R.raw.dedubluman_merdiven);
                durum.setText(resetstring);
            }
        });
    }
}