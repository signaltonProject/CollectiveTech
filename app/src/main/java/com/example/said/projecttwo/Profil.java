package com.example.said.projecttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        ImageButton homeButton,searchButton,addButton,profileButton;
        Button btnLastLocation=(Button) findViewById(R.id.btnUserGpsDatas);
        Button btnLastImage=(Button) findViewById(R.id.btnUserImageDatas);
        Button btnSetting=(Button) findViewById(R.id.btnSetting);
        Button btnExit=(Button) findViewById(R.id.btnExit);

        homeButton= (ImageButton) findViewById(R.id.homeButton);
        searchButton= (ImageButton) findViewById(R.id.searchButton);
        addButton= (ImageButton) findViewById(R.id.addButton);
        profileButton= (ImageButton) findViewById(R.id.profileButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goHome=new Intent(Profil.this,Anasayfa.class);
                startActivity(goHome);
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goSearch=new Intent(Profil.this,SearchPage.class);
                startActivity(goSearch);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goAddPage=new Intent(Profil.this,AddPage.class);
                startActivity(goAddPage);
            }
        });

        btnLastLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpConnection connection=new HttpConnection();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goLogin=new Intent(Profil.this,LoginPage.class);
                startActivity(goLogin);
            }
        });
    }
}
