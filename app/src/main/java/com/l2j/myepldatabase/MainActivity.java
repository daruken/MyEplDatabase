package com.l2j.myepldatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.apache.http.HttpException;
import org.apache.http.conn.HttpHostConnectException;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = new String("http://10.0.2.2/eplDB/eplclub.php?club=liverpool");
        mTextView = (TextView)findViewById(R.id.textView);

        try {
            PhpHandler phpHandler = new PhpHandler(new PhpHandler.AsyncResponse() {
                @Override
                public void processFinish(String jsonHtml) {
                    mTextView.setText(jsonHtml);
                }
            });

            phpHandler.execute(url);

        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}
