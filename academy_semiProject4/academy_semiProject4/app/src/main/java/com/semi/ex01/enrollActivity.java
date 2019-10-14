package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class enrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);

        Button addSaleButton = findViewById(R.id.addSaleButton);
        addSaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addSaleIntent = new Intent(enrollActivity.this, addSaleActivity.class);
                startActivity(addSaleIntent);
            }
        });

        Button addMatchingButton = findViewById(R.id.addMatchingButton);
        addMatchingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent matchingIntent = new Intent(enrollActivity.this, addMatchingActivity.class);
                startActivity(matchingIntent);
                Log.d("Main","asd");
            }
        });
    }
}
