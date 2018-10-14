package com.example.said.projecttwo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

public class LoginPage extends AppCompatActivity {
    EditText editUsername,editPassword,signuserName,signPassword;
    TextView txtForgetPassword,txtSingIn;
    Button btnLogin;
    String line,userName="",password="";
    public String res;
    JSONObject json,jobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        btnLogin = (Button) findViewById(R.id.button);
        txtForgetPassword = (TextView) findViewById(R.id.textForgetPass);
        txtSingIn = (TextView) findViewById(R.id.textSignUp);
        json = new JSONObject();

        final String reqUrl = getResources().getString(R.string.server_url);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userName=editUsername.getText().toString();
                password=editPassword.getText().toString();
                if(userName.isEmpty() || password.isEmpty()){
                    Toast.makeText(LoginPage.this, "Fill empty fields.", Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        json.put("userName", userName);
                        json.put("password", password);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    //new baglantı(json).execute("http://192.168.1.101:3002/login");
                    /*new postData(json).execute("http://192.168.1.102:3002/login");
                    Toast.makeText(LoginPage.this, res, Toast.LENGTH_SHORT).show();*/
                    Intent login = new Intent(LoginPage.this, Anasayfa.class);
                    startActivity(login);

                }
            }
        });

        //sifre yenileme islemleri
        txtForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginPage.this, "Service no available yet.", Toast.LENGTH_SHORT).show();
            }
        });

        //yeni kayıt işlemleri
        txtSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(LoginPage.this);
                View mView=getLayoutInflater().inflate(R.layout.custom_signin,null);
                signuserName=(EditText) findViewById(R.id.signinUsername);
                signPassword=(EditText) findViewById(R.id.signinPassword);
                Button btnSignIn=(Button) mView.findViewById(R.id.butonSign);
                btnSignIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if(!signuserName.getText().toString().isEmpty() && !signPassword.getText().toString().isEmpty()){

                            try{
                                jobj.put("username",userName);
                                jobj.put("password",password);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }else {
                            Toast.makeText(LoginPage.this, "fill empty spaces", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog=mBuilder.create();
                dialog.show();
            }
        });
    }
    class postData extends AsyncTask<String,String,String>{
        JSONObject jObj;

        //constructor ile verilerimizi jsonobject objesine atıyoruz
        public postData(JSONObject postDatas) {
            if(postDatas!=null){
                this.jObj=postDatas;
            }
        }

        @Override
        protected String doInBackground(String... strings) {

            HttpConnection connection = new HttpConnection();
            res = connection.sendDataHttpConnection(strings[0], jObj);
            if (res != null) {
                Intent login = new Intent(LoginPage.this, Anasayfa.class);
                login.putExtra("id", res);
                startActivity(login);
            } else {
                return res;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
