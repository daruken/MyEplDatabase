package com.l2j.myepldatabase;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by daruken on 15. 12. 20..
 */
public class DatabaseHandler {
    ArrayList<StructEplClub> mArrayClub = new ArrayList<>();

    public void jsonHtmlParsing(String jsonHtml) {

        try {
            JSONArray ja = new JSONArray(jsonHtml);

            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = ja.getJSONObject(i);

                String playerName = jo.getString("player");
                String position = jo.getString("position");
                int number = jo.getInt("number");

                StructEplClub stEplClub =
                        new StructEplClub(playerName, position, number);

                mArrayClub.add(stEplClub);
            }

        }catch(JSONException e){
            e.printStackTrace();
        }
    }
}
