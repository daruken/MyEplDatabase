package com.l2j.myepldatabase;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by daruken on 15. 12. 20..
 */
public class PhpHandler extends AsyncTask <String, Void, String> {
    public AsyncResponse mDelegate;

    public PhpHandler(AsyncResponse delegate){
        this.mDelegate = delegate;
    }

    @Override
    protected String doInBackground(String... urls){
        try{
            URL url = new URL(urls[0]);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            StringBuilder jsonHtml = new StringBuilder();

            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(conn.getInputStream()));

            String json;
            while( (json = bufferedReader.readLine()) != null ){
                jsonHtml.append(json);
            }

            return jsonHtml.toString();

        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String jsonHtml){
        mDelegate.processFinish(jsonHtml);
    }

    public interface AsyncResponse {
        void processFinish(String output);
    }

}
