package com.example.appcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainHomeActivity extends AppCompatActivity implements View.OnClickListener {
Button id_verification,id_evenement;
ImageView logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        //récupérations des identifiants
        id_evenement = (Button)findViewById(R.id.id_evenement);
        id_evenement.setOnClickListener(this);
        id_verification = (Button)findViewById(R.id.id_verification);
        id_verification.setOnClickListener(this);
        logout = (ImageView)findViewById(R.id.logout);
        logout.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
     switch (view.getId())
     {
         case R.id.id_verification:
             startActivity(new Intent(getApplicationContext(),MainScanActivity.class));
             break;
         case R.id.id_evenement:
             startActivity(new Intent(getApplicationContext(),MainEventActivity.class));
             break;
         case R.id.logout:
             startActivity(new Intent(getApplicationContext(),MainActivity.class));
             break;
     }
    }
}
