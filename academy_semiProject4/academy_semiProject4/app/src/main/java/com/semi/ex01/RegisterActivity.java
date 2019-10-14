package com.semi.ex01;


import androidx.annotation.IdRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.pedro.library.AutoPermissions;

public class RegisterActivity extends AppCompatActivity {

    RequestQueue queue;

    private ArrayAdapter adapter;
    private Spinner spinner;
    private AlertDialog dialog;
    private boolean validate = false;

    private EditText et_id, et_pass, et_passchk, et_name, et_age, et_phone;
    private TextView et_ad;
    private String userGender;

    Button validateButton;
    ImageView setImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinner = (Spinner) findViewById(R.id.timeSpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.time, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // 아이디 값 찾아주기
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_passchk = findViewById(R.id.et_passchk);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_phone = findViewById(R.id.et_phone);
        et_ad = findViewById(R.id.et_ad);
        setImage = findViewById(R.id.setImage);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getSupportFragmentManager();
                AddrFragment2 dialogFragment = new AddrFragment2();
                dialogFragment.show(fm, "fragment_dialog_test");

            }
        });

        et_passchk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et_pass.getText().toString().equals(et_passchk.getText().toString())) {
                    setImage.setImageResource(R.drawable.ic_right_24dp);

                } else {
                    setImage.setImageResource(R.drawable.ic_false_24dp);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // 회원가입 버튼 클릭 시 수행
        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 현재 입력되어있는 값을 get해온다.(가져온다.)
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                String userName = et_name.getText().toString();
                String userAge = et_age.getText().toString();
                String userPhone = et_phone.getText().toString();
                String userAddress = et_ad.getText().toString();
                String userTime = spinner.getSelectedItem().toString();

                if(!validate) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("중복체크 먼저해주세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                if(userID.equals("") || userPass.equals("") || userName.equals("") || userAge.equals("") || userPhone.equals("") ||  userGender.equals("") || userTime.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("빈 칸 없이 입력해주세요. .").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                final RadioGroup genderGroup = findViewById(R.id.genderGroup);
                int genderGroupID = genderGroup.getCheckedRadioButtonId();
                userGender = ((RadioButton) findViewById(genderGroupID)).getText().toString();
                String userSex = userGender;

                genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                        RadioButton genderButton = findViewById(i);
                        userGender = genderButton.getText().toString();

                    }
                });

                requestRegister(userID, userPass, userName, userAge, userPhone, userAddress, userSex, userTime);

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);


            }
        });

        validateButton = findViewById(R.id.validateButton);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = et_id.getText().toString();
                if (userID.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("ID는 빈칸일 수 없습니다.").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }

                idCheck(userID);
            }
        });

        queue = Volley.newRequestQueue(getApplicationContext());
        AutoPermissions.Companion.loadAllPermissions(this, 101);


    }

    public void requestRegister(final String id, final String password, final String name, final String age, final String phone, final String address, final String ugender, final String utime) {
        String url = "http://1.250.62.157:6000/addshareroom/Registerinsert";
        url += "?userID=" + id
                + "&userPassword=" + password
                + "&userName=" + name
                + "&userAge=" + age
                + "&userPhone=" + phone
                + "&userAddress=" + address
                + "&userGender=" + ugender
                + "&userTime=" + utime;


        Log.d("Main", utime+"  "+ugender);
        Log.d("Main", url);

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Main", "회원가입이 완료되었습니다.");
                        Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Main", "Error -> " + error.getMessage());
                    }
                }
        );
        request.setShouldCache(false);
        queue.add(request);
    }

    public void idCheck(String id) {
        String url = "http://1.250.62.157:6000/addshareroom/checkid";
        url += "?userID=" + id;
        Log.d("Main", url);

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        idResponse(response);
                        Log.d("Main", "함수실행");

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Main", "Error -> " + error.getMessage());
                    }
                }

        );

        request.setShouldCache(false);
        queue.add(request);
    }

    public void idResponse(String response) {
        Gson gson = new Gson();
        try {
            IdCheckResponse responseObj = gson.fromJson(response, IdCheckResponse.class);
            if (responseObj.output.get(0) != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                dialog = builder.setMessage("중복된 ID입니다.").setPositiveButton("확인", null).create();
                dialog.show();
            }

        } catch (Exception e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            dialog = builder.setMessage("사용가능한 아이디입니다.").setPositiveButton("확인", null).create();
            dialog.show();
            et_id.setEnabled(false);
            validate = true;
        }


    }
}
