package com.semi.ex01;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

public class chatProgress extends Dialog {

    public chatProgress(Activity activity) {
        super(activity);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.chat_progress_loading);
        TextView textView = findViewById(R.id.chatProgressText);
        for (int i = 0; i < 1; i++) {
            String[] str = {"채팅방에 입장중...", "귀찮아...", "친구들에게 연락중...",
                    "퇴근하고싶다...", "아무것도 안 하고 싶다..."};

            int r = (int) (Math.random() * 5);

            Log.d("Main", "Random" + r);

            textView.setText(str[r]);

        }
    }

    public void destroy () {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        },3000);


    }

}
