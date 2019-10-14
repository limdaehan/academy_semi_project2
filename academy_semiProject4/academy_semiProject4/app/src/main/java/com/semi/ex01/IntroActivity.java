package com.semi.ex01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class IntroActivity extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.intro_layout);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent (IntroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}