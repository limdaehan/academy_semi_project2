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

public class addSaleActivity extends AppCompatActivity {

    RequestQueue queue;

    private ArrayAdapter adapter;
    private ArrayAdapter adapter2;
    private ArrayAdapter adapter3;

    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;

    EditText editText;
    EditText editText2;
    EditText addressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sale);

        spinner = (Spinner) findViewById(R.id.addSaleSpiner);
        adapter = ArrayAdapter.createFromResource(this, R.array.addSaleList, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner2 = (Spinner) findViewById(R.id.addRoomSpinner);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.addRoomSizeList, android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner3 = (Spinner) findViewById(R.id.addRoomTypeSpinner);
        adapter3 = ArrayAdapter.createFromResource(this, R.array.addRoomTypeList, android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);




        Button addSaleListButton = findViewById(R.id.addSaleListButton);
        addSaleListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editText = findViewById(R.id.editText);
                addressText =  findViewById(R.id.addAddressText);
                editText2 = findViewById(R.id.contentTextLine);


                String addSale = spinner.getSelectedItem().toString();
                String addRoom = spinner2.getSelectedItem().toString();
                String addRoomType = spinner3.getSelectedItem().toString();


                String title = editText.getText().toString();
                String addressText2 = addressText.getText().toString();
                String contentText = editText2.getText().toString();
                String id = randomId();


                Log.d("Main", "test1");
                requestSaleList(id, addSale, addRoom, addRoomType, title, addressText2, contentText);


                Intent addSaleListIntent = new Intent(addSaleActivity.this,MatchingListActivity.class);
                startActivity(addSaleListIntent);
                Log.d("Main", "test2");

            }
        });
        queue = Volley.newRequestQueue(getApplicationContext());


    }

    public void requestSaleList(final String id, final String addSale, final String addRoom, final String addRoomType, final String title, final String addressText2, final String contentText) {
        String url = "http://1.250.62.157:6000/addshareroom/roomInsert";
        url += "?id=" + id
                +"&addSale=" + addSale
                + "&addRoom=" + addRoom
                + "&addRoomType=" + addRoomType
                + "&title=" + title
                + "&addressText=" + addressText2
                + "&contentText=" + contentText ;
        Log.d("Main", "test3");


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
