package com.example.appcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
TextView login,password;
Button btn_login;
private HttpUtils httpUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reccupération des identifients
        login = (TextView)findViewById(R.id.login);
        password = (TextView) findViewById(R.id.password);
        btn_login = (Button)findViewById(R.id.btn_login);


        //action du click sur le bouton btn_login
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Login();
                startActivity(new Intent(getApplicationContext(),MainHomeActivity.class));

            }
        });

    }


    //fonction de qui gère la connexion

    public  void Login(){

        RequestParams rp = new RequestParams();
            rp.add("username", "aaa");
            rp.add("password", "aaa@123");

            HttpUtils.get("", rp, new JsonHttpResponseHandler() {

            @Override
            public void onStart() {

            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {

                Log.d("asd", "---------------- this is response : " + response);
                try {
                    org.json.JSONObject serverResp = new JSONObject(response.toString());

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    Log.d("asd", "---------------- this is response : " + response);
                    try {
                        JSONArray serverResp = new JSONArray(response.toString());

                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, Throwable throwable, JSONObject response) {
                    Log.d("asd", "---------------- this is response : " + response);
                    try {
                        JSONObject jsonObject = new JSONObject(response.toString());
                        Toast.makeText(getApplicationContext(),jsonObject.getString("FirstNameError"),Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }



            @Override
            public void onFinish() {
                Log.d("asd", "---------------- this is response : ");

            }
        });


    }



}
