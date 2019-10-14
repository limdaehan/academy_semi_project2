package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.pedro.library.AutoPermissions;
import android.content.SharedPreferences;


public class LoginActivity extends AppCompatActivity {

    RequestQueue queue;

    EditText et_id, et_pass;
    CheckBox checkBox;

    String sfName = "myFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);

        SharedPreferences sf = getSharedPreferences(sfName, 0);
        String str = sf.getString("name","");
        et_id.setText(str);

        String Login = et_id.getText().toString();
        SharedPreferences loginUser = getSharedPreferences("Login", LoginActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = loginUser.edit();
        editor.putString("UserName", Login);
        editor.commit();

        //회원가입 버튼 클릭 시 수행
        Button btn_resgister = findViewById(R.id.btn_register);
        btn_resgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        final Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 현재 입력되어있는 값을 get(가져온다.)
                final String userId = et_id.getText().toString();
                final String userPass = et_pass.getText().toString();

                if (userId.length() == 0) {
                    Toast.makeText(getApplicationContext(), "ID를 입력하세요.", Toast.LENGTH_LONG).show();
                    return;
                }

                if (userPass.length() == 0) {
                    Toast.makeText(getApplicationContext(), "PW를 입력하세요.", Toast.LENGTH_LONG).show();
                    return;
                }

                Log.d("Main", "1");
                loginCheck(userId, userPass);

            }
        });
        queue = Volley.newRequestQueue(getApplicationContext());
        AutoPermissions.Companion.loadAllPermissions(this, 101);

    }

    public void loginCheck(final String id, final String password) {
        Log.d("Main", "2");
        String url = "http://1.250.62.157:6000/addshareroom/login";
        url += "?userID=" + id
                + "&userPassword=" + password;
        Log.d("Main", "3");
        Log.d("Main", url);


        final StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loginResponse(response, id, password);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), " 실패", Toast.LENGTH_LONG).show();
                        Log.d("Main", "Error -> " + error.getMessage());
                    }
                }

        );

        request.setShouldCache(false);
        queue.add(request);
    }




    public void loginResponse(String response, String userId, String userPass) {
        Gson gson = new Gson();
        LoginResponse responseObj = gson.fromJson(response, LoginResponse.class);
        Login login = responseObj.output.get(0);
        try {
            Log.d("main", login.userid + login.userpassword);
            if (login.userid.equals(userId) && login.userpassword.equals(userPass)) {

                Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다.", Toast.LENGTH_LONG).show();
                convertPage();
                finish();

            } else if (login.userid != userId && login.userpassword != userPass) {    // 회원등록에 실패한 경우
                Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다.", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void convertPage() {
        Intent intent = new Intent(LoginActivity.this, DesignActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Activity 가 종료되기 전에 저장한다
        // SharedPreferences 에 설정값(특별히 기억해야할 사용자 값)을 저장하기
        SharedPreferences sf = getSharedPreferences(sfName, 0);
        SharedPreferences.Editor editor = sf.edit();//저장하려면 editor가 필요
        String str = et_id.getText().toString(); // 사용자가 입력한 값
        editor.putString("name", str); // 입력
        editor.putString("xx", "xx"); // 입력
        editor.commit(); // 파일에 최종 반영함
    }

}









   /* Response.Listener<String> responseListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            try {
                JSONObject gsonObject = new JSONObject(response);
                boolean success = gsonObject.getBoolean("success");
                if (success) { // 회원등록에 성공한 경우
                    String userID = gsonObject.getString("userID");
                    String userPass = gsonObject.getString("userPassword");

                    Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("userID",userID);
                    intent.putExtra("userPass",userPass);
                    startActivity(intent);
                } else {    // 회원등록에 실패한 경우
                    Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다.", Toast.LENGTH_LONG).show();
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);

}*/