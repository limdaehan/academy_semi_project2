package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddSaleActivity2 extends AppCompatActivity implements OnItemSelectionCallback {

    RequestQueue queue;

    private ArrayAdapter adapter;
    private ArrayAdapter adapter2;
    private ArrayAdapter adapter3;
    private ArrayAdapter adapter4;

    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;

    EditText editText;
    EditText editText2;
    TextView addressText;
    public static final int sub = 1001;
    String imageUri;

    private static final String FRAGMENT_TAG = "FRAGMENT_TAG";
    private static final String KEY_NUMBER = "KEY_NUMBER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sale2);


        spinner = (Spinner) findViewById(R.id.addSaleSpiner12);
        adapter = ArrayAdapter.createFromResource(this, R.array.addSaleList, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner2 = (Spinner) findViewById(R.id.addRoomSpinner);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.addRoomSizeList, android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner3 = (Spinner) findViewById(R.id.addSaleSpiner13);
        adapter3 = ArrayAdapter.createFromResource(this, R.array.addRoomTypeList, android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i) {
                    case (0) :
                        setSpinnerItem(R.array.addSaleList1);
                        break;

                    case (1) :
                        setSpinnerItem(R.array.addSaleList2);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        Button searchBtn = findViewById(R.id.searchAddrBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                AddrFragment dialogFragment = new AddrFragment();
                dialogFragment.show(fm, "fragment_dialog_test");
            }
        });

        Button addSaleListButton = findViewById(R.id.addSaleListButton);
        addSaleListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editText = findViewById(R.id.titleText);
                addressText =  findViewById(R.id.addrText);
                editText2 = findViewById(R.id.contentTextLine);


                String addSale = spinner.getSelectedItem().toString();
                String addRoom = spinner2.getSelectedItem().toString();
                String addRoomType = spinner3.getSelectedItem().toString();
                String addSalee = spinner4.getSelectedItem().toString();
                int addSale2 = Integer.parseInt(addSalee);


                String title = editText.getText().toString();
                String addressText2 = addressText.getText().toString();
                String contentText = editText2.getText().toString();
                String id = randomId();
                String image = imageUri;


                Log.d("Main", "test1");
                requestSaleList(id, addSale, addRoom, addRoomType, title, addressText2, contentText, image, addSale2);


                Intent addSaleListIntent = new Intent(AddSaleActivity2.this,DesignActivity.class);
                startActivity(addSaleListIntent);
                Log.d("Main", "test2");

            }
        });
        queue = Volley.newRequestQueue(getApplicationContext());


    }



    public void requestSaleList(final String id, final String addSale, final String addRoom, final String addRoomType, final String title, final String addressText2, final String contentText, String image, final int addSale2) {

        String url = "http://1.250.62.157:6000/addshareroom/RoomInsert";

        Log.d("Main", "test3");



        StringRequest request = new StringRequest(
                Request.Method.POST,
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
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("id", id);
                params.put("addSale", addSale);
                params.put("addSale2", String.valueOf(addSale2));
                params.put("addRoom", addRoom);
                params.put("addRoomType", addRoomType);
                params.put("title", title);
                params.put("addSale", addSale);
                params.put("addressText", addressText2);
                params.put("contentText", contentText);
                params.put("imageblob", imageUri);

                return params;
            }
        };


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

    public void onItemSelected(String imageUri1){
        Log.d("Main","onItemSelected 호출됨 : "+imageUri);
        imageUri = imageUri1;

    }

    public void setSpinnerItem(int item) {
        spinner4 = (Spinner) findViewById(R.id.addSaleSpiner2);
        adapter4 = ArrayAdapter.createFromResource(this, item, android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
    }


}