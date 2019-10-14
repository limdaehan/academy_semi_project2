package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class addMatchingActivity extends AppCompatActivity {

    RequestQueue queue;

    private ArrayAdapter adapter;
    private ArrayAdapter adapter2;
    private ArrayAdapter adapter3;
    private ArrayAdapter adapter4;
    private ArrayAdapter adapter5;

    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;

    EditText titleLine;
    EditText addressLine;
    EditText contentLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_matching);

        spinner = (Spinner) findViewById(R.id.matchPersonalitySpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.matchPersonalityList, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner2 = (Spinner) findViewById(R.id.addRoomSpinner);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.matchRoomSizeList, android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner3 = (Spinner) findViewById(R.id.addRoomTypeSpinner);
        adapter3 = ArrayAdapter.createFromResource(this, R.array.matchRoomTypeList, android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        spinner4 = (Spinner) findViewById(R.id.addSaleSpiner);
        adapter4 = ArrayAdapter.createFromResource(this, R.array.matchSaleList, android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        spinner5 = (Spinner) findViewById(R.id.matchTImeSpinner);
        adapter5 = ArrayAdapter.createFromResource(this, R.array.matchGenderList, android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);







        Button button = findViewById(R.id.addSaleListButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                titleLine = findViewById(R.id.titleText);
                addressLine = findViewById(R.id.matchAddressText);
                contentLine = findViewById(R.id.contentTextLine);

                String personal = spinner.getSelectedItem().toString();
                String roomSize = spinner2.getSelectedItem().toString();
                String roomType = spinner3.getSelectedItem().toString();
                String matchSale = spinner4.getSelectedItem().toString();
                String matchTime = spinner5.getSelectedItem().toString();



                String title = titleLine.getText().toString();
                String address = addressLine.getText().toString();
                String contentText = contentLine.getText().toString();
                String id = randomId();

                requestMatchingList(id, personal, roomSize, roomType, matchSale, matchTime, title, address, contentText);

                Intent addMatchingListIntent = new Intent(addMatchingActivity.this,MatchingListActivity.class);
                startActivity(addMatchingListIntent);
            }
        });
        queue = Volley.newRequestQueue(getApplicationContext());
    }

    public void requestMatchingList(final String id, final String perosonal, final String roomsize, final String roomtype, final String matchsale, final String matchtime, final String title, final String address, final String contextText) {

        String url = "http://1.250.62.157:6000/addshareroom/insertMatching";
        url += "?id=" +id
                +"&matchPersonality=" + perosonal
                + "&matchRoomSize=" + roomsize
                + "&matchRoomType=" + roomtype
                + "&title=" + title
                + "&matchPrice=" + matchsale
                + "&matchTime=" + matchtime
                + "&matchTitle=" + title
                + "&matchAddress=" + address
                + "&matchContent=" + contextText;

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
}
