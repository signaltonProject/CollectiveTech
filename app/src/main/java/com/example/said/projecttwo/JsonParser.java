package com.example.said.projecttwo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JsonParser {
    Double latitude,longitude;
    String toplam;

    //gelen json-string objesini parcalayarak istedigimiz bilgilere ulasma
    public String objectParse(String jObj){
        if(jObj!=null){
            try{
                JSONArray contacts=new JSONArray(jObj);
                JSONObject jsonObj=contacts.getJSONObject(0);
                latitude=jsonObj.getDouble("latitude");
                longitude=jsonObj.getDouble("longitude");
                toplam="latitude:"+String.valueOf(latitude)+" longitude:"+String.valueOf(longitude);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return toplam;
    }

    //overloading islemi yapılacak
    public String objectParse(String jObj, int a){
        if(jObj!=null){
            try{
                JSONArray contacts=new JSONArray(jObj);
                JSONObject jsonObj=contacts.getJSONObject(0);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return toplam;
    }
}
