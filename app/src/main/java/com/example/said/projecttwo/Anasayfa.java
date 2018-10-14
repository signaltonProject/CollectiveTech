package com.example.said.projecttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Anasayfa extends AppCompatActivity {

    ImageButton homeButton,searchButton,addButton,profileButton;
    List<User> users=new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);
        homeButton= (ImageButton) findViewById(R.id.homeButton);
        searchButton= (ImageButton) findViewById(R.id.searchButton);
        addButton= (ImageButton) findViewById(R.id.addButton);
        profileButton= (ImageButton) findViewById(R.id.profileButton);

        String reqUrl=getResources().getString(R.string.server_url)+"/login";


        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSearchPage=new Intent(Anasayfa.this,SearchPage.class);
                startActivity(intentSearchPage);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAddPage=new Intent(Anasayfa.this,AddPage.class);
                startActivity(intentAddPage);
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfile=new Intent(Anasayfa.this,Profil.class);
                startActivity(intentProfile);
            }
        });

        users.add(new User("Fethi Çetin", 8, 3));
        users.add(new User("Said TOKMAK", 8, 3));
        users.add(new User("Gözde Yaşar", 2, 3));
        users.add(new User("Hüseyin Coşkun", 11, 0));
        users.add(new User("Seda Karataş", 5, 0));
        users.add(new User("Fatih Keskin", 18, 0));
        users.add(new User("Betül Çiçek", 3, 2));
        users.add(new User("Fatih Ballı", 2, 0));
        users.add(new User("Hanife Bakal", 8, 3));

        final ListView listView=(ListView) findViewById(R.id.listView);
        CustomAdapter adapter=new CustomAdapter(this,users);
        listView.setAdapter(adapter);

        /*Intent goMap=new Intent(AddPage.this,MapsActivity.class);
               goMap.putExtra("latitude",latitude);
               goMap.putExtra("longitude",longitude);
               startActivity(goMap);*/
    }
}
