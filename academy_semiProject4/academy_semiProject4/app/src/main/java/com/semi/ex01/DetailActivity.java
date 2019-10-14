package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONStringer;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    TextView detailTitle;
    TextView personality;
    TextView roomType;
    TextView price;
    TextView detailTime;
    TextView detailContent;

    progress_loading progressLoading;
    RequestQueue queue;
    ArrayList<chatUser> chatArrayList;
    String User;
    ArrayList chatUserList;
    String chatRoomNum;
    String loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailTitle = findViewById(R.id.postName);
        personality = findViewById(R.id.matchPersonalitySpinner);

//        SharedPreferences sf = getSharedPreferences(sfName, 0);
//        SharedPreferences.Editor editor = sf.edit();//저장하려면 editor가 필요
//        String str = et_id.getText().toString(); // 사용자가 입력한 값
//        editor.putString("name", str); // 입력
//        editor.putString("xx", "xx"); // 입력
//        editor.commit(); // 파일에 최종 반영함

        SharedPreferences Login = getSharedPreferences("Login", LoginActivity.MODE_PRIVATE);
        loginUser = Login.getString("UserName", "");
        Log.d("Main", "로그인 한 놈 => " + loginUser);

        roomType = findViewById(R.id.addRoomTypeSpinner);
        price = findViewById(R.id.postPrise);
        detailTime = findViewById(R.id.matchTime);

        detailContent = findViewById(R.id.explanation);
        Button joinButton = findViewById(R.id.addSaleListButton);
        Button closeButton = findViewById(R.id.closeButton);
        Button mapButton = findViewById(R.id.mapButton);
        final Button chatButton = findViewById(R.id.chatButton);

        queue = Volley.newRequestQueue(getApplicationContext());
        chatArrayList = new ArrayList<>();
        chatUserList = new ArrayList();


        //인텐트 받아오기 & 변수에 담기
        final Intent intent = getIntent();
        final String listID = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");
        String matchPersonality = intent.getStringExtra("personality");
        String matchRoomSize = intent.getStringExtra("roomSize");
        String matchRoomType = intent.getStringExtra("roomType");
        String matchPrice = intent.getStringExtra("price");
        String matchTime = intent.getStringExtra("matchTime");
        String matchTitle = intent.getStringExtra("matchTitle");
        String matchAddress = intent.getStringExtra("matchAddress");
        String matchContent = intent.getStringExtra("matchContent");
        String personCount = intent.getStringExtra("personCount");
        String maxPersonCount = intent.getStringExtra("maxPersonCount");

        Intent loginIntent = getIntent();



        Log.d("Main", "personCount = " + personCount + "maxPersonCount = " + maxPersonCount);

        //텍스트 뷰에 설정
        detailTitle.setText(title);
        personality.setText(matchPersonality);
        roomType.setText(matchRoomType);
        price.setText(matchPrice);
        detailTime.setText(matchTime);
        detailContent.setText(matchContent);


        if(personCount.equals(maxPersonCount)) {
            joinButton.setText("신청불가");
            joinButton.setEnabled(false);
            mapButton.setVisibility(View.VISIBLE);

        }

        //참가 버튼 이벤트
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressLoading = new progress_loading(DetailActivity.this);
                progressLoading.show();
                progressLoading.destroy();

                joinList(listID);
                addPersonCount(listID);

            }
        });

        //닫기 버튼 이벤트
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(view.getContext(), RoommateActivity.class);
                view.getContext().startActivity(intent2);


            }
        });

        //지도 버튼 이벤트
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(view.getContext(), RoommateActivity.class);

            }
        });

        //채팅하기 버튼 이벤트
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String url = "http://1.250.62.157:6000/addshareroom/joinchatlist"+"?listId="+listID;

                StringRequest request = new StringRequest(
                        Request.Method.GET,
                        url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("Main", "????" + response);
                                Gson gson = new Gson();

                                ListResponse2 chatList = gson.fromJson(response, ListResponse2.class);

                                for(int i = 0; i < chatList.output.size(); i++) {
                                    CHATList chatingUser = chatList.output.get(i);

                                    chatUser data = new chatUser(chatingUser.listid, chatingUser.userid);
                                    chatArrayList.add(data);
                                    User = loginUser;

                                    Log.d("Main", "참가 유저 =>" +User);


                                    chatUserList.add(chatArrayList.get(i).getUserid());
                                    chatRoomNum = (String) chatArrayList.get(i).getListid();

                                    Log.d("Main", "현재 유저 아이디 =>" + User + "리스트 유저명 => "+ chatUserList.get(0));

                                    if(User.equals(chatUserList.get(i))) {

                                        chatProgress chatProgress = new chatProgress(DetailActivity.this);
                                        chatProgress.show();
                                        chatProgress.destroy();

                                        Intent chatIntent = new Intent(view.getContext(), StartActivity.class);
                                        chatIntent.putExtra("chatRoom", chatArrayList.get(i).getListid());
                                        chatIntent.putExtra("chatUser", chatUserList.get(i).toString());
                                        view.getContext().startActivity(chatIntent);
                                        break;

                                    } else {

                                        chatButton.setText("채팅불가");
                                        chatButton.setEnabled(false);
                                        Toast.makeText(DetailActivity.this, "테스트", Toast.LENGTH_LONG).show();
                                    }


                                }


                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });

                request.setShouldCache(false);
                queue.add(request);
            }
        });
    }

    //신청하기 함수
    public void joinList(String id) {
        String url = "http://1.250.62.157:6000/addshareroom/IDinsert2" + "?listId=" + id + "&userId="+ loginUser;
        Log.d("Main", "url => " + url);
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Main", "데이터 보내짐" + response);
                        progressLoading.show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Main", "Error" + error);
            }
        });
        request.setShouldCache(false);
        queue.add(request);
    }

    //인원 추가 함수
    public void addPersonCount(String id) {
        String url = "http://1.250.62.157:6000/addshareroom/addperson" + "?listId=" + id;
        Log.d("Main", "url => " + url);
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Main", "업데이트 됨" + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Main", "Error" + error);
            }
        });
        request.setShouldCache(false);
        queue.add(request);
    }


    public class ListResponse2 {

        int code;
        String message;
        ArrayList<CHATList> output = new ArrayList<CHATList>();
    }


}


