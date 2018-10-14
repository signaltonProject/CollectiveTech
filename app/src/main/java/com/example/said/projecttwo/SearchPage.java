package com.example.said.projecttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Text;

public class SearchPage extends AppCompatActivity {

    JSONObject jObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        final String reqUrl=getResources().getString(R.string.server_url)+"/search";

        final EditText searchText=(EditText) findViewById(R.id.searchPageText);
        Button btnSearch = (Button) findViewById(R.id.butonSearch);
        ListView listView=(ListView) findViewById(R.id.searchResultListview);

        ImageButton homeButton,searchButton,addButton,profileButton;
        homeButton= (ImageButton) findViewById(R.id.homeButton);
        searchButton= (ImageButton) findViewById(R.id.searchButton);
        addButton= (ImageButton) findViewById(R.id.addButton);
        profileButton= (ImageButton) findViewById(R.id.profileButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goHomePage=new Intent(SearchPage.this,Anasayfa.class);
                startActivity(goHomePage);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goAddPage=new Intent(SearchPage.this,AddPage.class);
                startActivity(goAddPage);
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goProfilPage=new Intent(SearchPage.this,Profil.class);
                startActivity(goProfilPage);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=searchText.getText().toString();
                try{
                    jObj.put("user_name",name);
                }catch (Exception e){
                    e.printStackTrace();
                }
                HttpConnection connection=new HttpConnection();
                connection.sendDataHttpConnection(reqUrl,jObj);
            }
        });
    }
}
