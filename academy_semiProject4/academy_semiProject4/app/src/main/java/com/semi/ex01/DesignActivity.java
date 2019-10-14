package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DesignActivity extends AppCompatActivity {

    BottomBarFragment fragment1;

    public static final int sub = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);

        fragment1 = new BottomBarFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainlinearlayout, fragment1).commit();

        ImageButton findHouseBtn = findViewById(R.id.findHouseBtn);
        findHouseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LastActivity.class);
                startActivityForResult(intent,sub);//액티비티 띄우기
            }
        });

        ImageButton findFriendBtn = findViewById(R.id.findFriendBtn);
        findFriendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RoommateActivity.class);
                startActivityForResult(intent,sub);//액티비티 띄우기
            }
        });

        ImageButton addHouseBtn = findViewById(R.id.addhouseBtn);
        addHouseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddSaleActivity2.class);
                startActivityForResult(intent,sub);
            }
        });

    }
}
