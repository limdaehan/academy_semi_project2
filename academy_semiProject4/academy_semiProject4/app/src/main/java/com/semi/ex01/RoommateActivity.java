package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class RoommateActivity extends AppCompatActivity {

    BottomBarFragment fragment1;

    private ArrayList<Roommate> mArrayList;
    private com.semi.ex01.CustomAdapter mAdapter;
    RequestQueue queue;



    private Spinner spinner;
    private Spinner spinner2;
    private Adapter adapter;
    private Adapter adapter2;

    RecyclerView recyclerView;
    String trash;


    public static final int sub = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roommate);


        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.matchRoomMate, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) adapter);
        recyclerView = findViewById(R.id.roommateList);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i) {
                    case(0):
                        setSpinnerItem(R.array.matchRoomMatePersonality);
                        break;
                    case(1):
                        setSpinnerItem(R.array.matchRoomMateRoomType);
                        break;
                    case(2):
                        setSpinnerItem(R.array.matchRoomMateGender);
                        break;
                    case(3):
                        setSpinnerItem(R.array.matchRoomMateRoom);
                        break;

                    default:
                        break;
                }
            }




            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }



        });





        //프래그먼트 적용하기
        fragment1 = new BottomBarFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainlinearlayout, fragment1).commit();

        queue= Volley.newRequestQueue(getApplicationContext());

        RecyclerView mRecyclerView = findViewById(R.id.roommateList);
        LinearLayoutManager mlinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mlinearLayoutManager);

        mArrayList = new ArrayList<>();

        mAdapter = new com.semi.ex01.CustomAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mlinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        requestMyList2();



        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddMachingActivity2.class);
                startActivityForResult(intent,sub);//액티비티 띄우기

            }

        });

        Button requestsearch = findViewById(R.id.reqSearch);
        requestsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String req = spinner.getSelectedItem().toString();
                String spinner = spinner2.getSelectedItem().toString();
                mAdapter.clear();
                requestMyList(req,spinner);
            }
        });


    }

    //조건 버튼 검색시 리스트 출력 함수
    public void requestMyList(String type, String spinner) {
        Log.d("main", "여기는 ?");
        String url= "http://1.250.62.157:6000/addshareroom/matchinglist"
                +"?type="+type+"&values="+spinner;

        Log.d("main", url);
        Log.d("main","널입니다 ");




        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        processResponse(response);
                        trash = "[]";

                        Log.d("Main", "????"+response);
                        Gson gson = new Gson();



                        ListResponse roommateList = gson.fromJson(response, ListResponse.class);
                        Log.d("Main", " 이건찍힘?");
                        Log.d("main","asd"+ roommateList.output.size());

                        if(roommateList.output.size() == 0) {
                            Toast.makeText(RoommateActivity.this, "리스트가 존재하지 않습니다", Toast.LENGTH_LONG).show();
                            recyclerView.setVisibility(View.INVISIBLE);


                        } else {
                            progress_loading progressLoading = new progress_loading(RoommateActivity.this);
                            progressLoading.show();
                            progressLoading.destroy();
                            for(int i=0;i<roommateList.output.size(); i++) {
                                recyclerView.setVisibility(View.VISIBLE);
                                RMList roommate = roommateList.output.get(i);
                                Log.d("Main", " 이게 찍히네");

                                Roommate data = new Roommate(roommate.id, roommate.matchTitle, roommate.matchPersonality, roommate.matchGender, roommate.matchPrice, roommate.matchRoomType, roommate.personCount, roommate.maxPersonCount);
                                Log.d("Main", " 이게?");


                                Toast.makeText(RoommateActivity.this, "조건에 맞는 리스트가 출력되었습니다", Toast.LENGTH_LONG).show();
                                mArrayList.add(data);
                                mAdapter.notifyDataSetChanged();
                            }

                        }
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

    //리스트 출력
    public void requestMyList2() {
        String url="http://1.250.62.157:6000/addshareroom/matchinglist2";

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //processResponse(response);

                        Log.d("Main", "????"+response);
                        Gson gson = new Gson();

                        ListResponse roommateList = gson.fromJson(response, ListResponse.class);

                        for(int i=0; i<roommateList.output.size(); i++) {
                            RMList roommate = roommateList.output.get(i);

                            Roommate data = new Roommate(roommate.id, roommate.matchTitle, roommate.matchPersonality, roommate.matchGender, roommate.matchPrice, roommate.matchRoomType, roommate.personCount, roommate.maxPersonCount);

                            Log.d("Main", "roommate => " + data );

                            mArrayList.add(data);
                            mAdapter.notifyDataSetChanged();

                        }


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
        Log.d("Main", "resopones =>" + response);

        Gson gson = new Gson();

    }



    public class ListResponse {

        int code;
        String message;
        ArrayList<RMList> output = new ArrayList<RMList>();
    }


    public void setSpinnerItem(int item) {
        Log.d("main","1");

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        adapter2 = ArrayAdapter.createFromResource(this, item, android.R.layout.simple_spinner_dropdown_item);
        Log.d("main","2");
        spinner2.setAdapter((SpinnerAdapter) adapter2);
        Log.d("main","3");
    }
}
