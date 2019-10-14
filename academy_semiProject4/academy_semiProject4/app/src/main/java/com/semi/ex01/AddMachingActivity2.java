package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class AddMachingActivity2 extends AppCompatActivity {

    RequestQueue queue;
    private EditText id;


    private ArrayAdapter adapter;
    private ArrayAdapter adapter2;
    private ArrayAdapter adapter3;
    private ArrayAdapter adapter4;
    private ArrayAdapter adapter5;
    private ArrayAdapter adapter6;
    private ArrayAdapter adapter7;

    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;
    private Spinner spinner7;

    EditText titleLine;
    EditText contentLine;
    String loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_maching2);

        spinner = (Spinner) findViewById(R.id.matchPersonalitySpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.matchPersonalityList, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner2 = (Spinner) findViewById(R.id.addRoomSpinner);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.matchRoomSizeList, android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner3 = (Spinner) findViewById(R.id.addRoomTypeSpinner);
        adapter3 = ArrayAdapter.createFromResource(this, R.array.matchRoomTypeList, android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        spinner4 = (Spinner) findViewById(R.id.addSaleSpiner3);
        adapter4 = ArrayAdapter.createFromResource(this, R.array.matchSaleList, android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);



        spinner5 = (Spinner) findViewById(R.id.matchGenderSpinner);
        adapter5 = ArrayAdapter.createFromResource(this, R.array.matchGenderList, android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);

        spinner7 = (Spinner) findViewById(R.id.matchPersonSize);
        adapter7 = ArrayAdapter.createFromResource(this, R.array.matchPersonSize, android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter7);


        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case(0) :
                        setSpinnerItem(R.array.matchSaleList2);
                        break;
                    case (1) :
                        setSpinnerItem(R.array.matchSaleList3);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Button button = findViewById(R.id.addSaleListButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                titleLine = findViewById(R.id.titleText);
                contentLine = findViewById(R.id.contentTextLine);

                String personal = spinner.getSelectedItem().toString();
                String roomSize = spinner2.getSelectedItem().toString();
                String roomType = spinner3.getSelectedItem().toString();
                String matchSale = spinner4.getSelectedItem().toString();
                String matchGender = spinner5.getSelectedItem().toString();
                String matchSalee = spinner6.getSelectedItem().toString();
                int matchSale2 = Integer.parseInt(matchSalee);
                String maxPersonCount = spinner7.getSelectedItem().toString();


                SharedPreferences Login = getSharedPreferences("Login", LoginActivity.MODE_PRIVATE);
                loginUser = Login.getString("UserName", "");
                Log.d("Main", "로그인 한 놈 => " + loginUser);

                String title = titleLine.getText().toString();
                String contentText = contentLine.getText().toString();
                String id = randomId();

                requestMatchingList(id, personal, roomSize, roomType, matchSale, matchGender, title, contentText, matchSale2, maxPersonCount,loginUser);
                //idUpdate(id);


                Intent addMatchingListIntent = new Intent(AddMachingActivity2.this,RoommateActivity.class);
                startActivity(addMatchingListIntent);
            }
        });
        queue = Volley.newRequestQueue(getApplicationContext());


    }
    public void requestMatchingList(final String id, final String personal, final String roomSize, final String roomType, final String matchSale, final String matchGender, final String title,  final String contextText, final int matchSale2, final String maxPersonCount, final String userId) {

        String url = "http://1.250.62.157:6000/addshareroom/insertMatching";
        url += "?id=" +id
                +"&matchPersonality=" + personal
                + "&matchRoomSize=" + roomSize
                + "&matchRoomType=" + roomType
                + "&matchPrice=" + matchSale
                + "&matchSale2=" + matchSale2
                + "&matchGender=" + matchGender
                + "&matchTitle=" + title
                + "&matchContent=" + contextText
                + "&maxPersonCount=" + maxPersonCount
                + "&matchUserId=" + userId;


        Log.d("main",url);

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        processResponse(response);
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





    public void processResponse(String response) {
        Log.d("Main", "Response ->" + response);
    }

    public static String randomId() {
        String id = RandomNumber.makeId();

        return id;
    }

    public void setSpinnerItem(int item) {
        spinner6 = (Spinner) findViewById(R.id.addSaleSpiner4);
        adapter6 = ArrayAdapter.createFromResource(this, item, android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(adapter6);

    }
}