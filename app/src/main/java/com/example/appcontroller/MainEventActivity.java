package com.example.appcontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainEventActivity extends AppCompatActivity {
LinearLayout id_evetDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_event);

        //récuperation des identifiants
        id_evetDetail = (LinearLayout)findViewById(R.id.id_evetDetail);

        //déclancher le click
        id_evetDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainEventDetailsActivity.class));
            }
        });
    }
}
