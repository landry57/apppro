package com.example.appcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainScanResultActivity extends AppCompatActivity {
private TextView tv_user_name,tv_user_surname,tv_user_fonction,tv_user_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_scan_result);
        tv_user_name = (TextView)findViewById(R.id.tv_user_name);
        tv_user_surname =(TextView)findViewById(R.id.tv_user_surname);
        tv_user_fonction =(TextView)findViewById(R.id.tv_user_fonction);
        tv_user_number =(TextView)findViewById(R.id.tv_user_number);



        String data = getIntent().getExtras().getString("data");
        try {
            JSONObject jsonObject = new JSONObject(data);
            tv_user_name.setText(jsonObject.getString("nom"));
            tv_user_surname.setText(jsonObject.getString("prenom"));
            tv_user_fonction.setText(jsonObject.getString("profession"));
            tv_user_number.setText(jsonObject.getString("telephone"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent  = new Intent(getApplicationContext(),MainScanActivity.class);
        startActivity(intent);
        finish();
    }
}
