package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LastActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Geocoder geocoder;

    LinearLayout linearLayoutTmap;
    RequestQueue queue;
    static ArrayList<SharehouseObj> sharehouse;

    String serviceKey="qgFUCfQcQeSe7os32N4IgmTG9H64WZryX6BCU9f9%2Fx97tzLwfbRiD%2FNSZ0QK5a6l78q8%2B3uZWLR69rY%2FxG6QeA%3D%3D";

    String data;
    EditText inputText;
    TextView distText;
    String user1Addr = "서울특별시 은평구 갈현동 451-14";
    String user2Addr = "서울특별시 광진구 군자동 능동로 세종대학교";
    String user3Addr = "서울특별시 강남구 삼성1동 봉은사로114길 30";
    String user4Addr = "서울특별시 서대문구 신촌동 연세로 50";
    List<String> addrList = new ArrayList<>();
    List<Integer> userTimeList = new ArrayList<>();
    int reNum=0;

    int user1Time = 100;
    int user2Time = 70;
    int user3Time = 70;
    int user4Time = 100;
    static ArrayList<SharehouseObj> selectedSharehouse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        distText = findViewById(R.id.distText);

        inputText = findViewById(R.id.startText);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        addrList.add(user1Addr);
        addrList.add(user2Addr);
        addrList.add(user3Addr);
        addrList.add(user4Addr);

        userTimeList.add(user1Time);
        userTimeList.add(user2Time);
        userTimeList.add(user3Time);
        userTimeList.add(user4Time);

        if (queue == null)
            queue = Volley.newRequestQueue(getApplicationContext());
        Button button = findViewById(R.id.searchBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest();
            }
        });
    }

    public void sendRequest(){
        String url = "http://1.250.62.157:6000/addshareroom/list";

        Log.d("Main",url);


        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Main", response);
                        for(int i = 0; i<addrList.size(); i++) {
                            String inputStr = addrList.get(i);
                            int inputTime = userTimeList.get(i);
                            processResponse(response, inputStr,inputTime);  // 응답 처리 메서드
                            distText.append(data);

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Main","에러남");

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // 만약 POST 방식에서 전달할 요청 파라미터가 있다면 HashMap 객체에 넣어준다.
                Map<String, String> map = new HashMap<>();
                return map;
            }
        };

        request.setShouldCache(false); // 이전 결과가 있더라도 새로 요청해서 응답을 보여줌
        queue.add(request); // request queue 에 request 객체를 넣어준다.
        return;
    }

    public void processResponse(String response, final String inputStr, final int inputTime) {
        Gson gson = new Gson();
        SharehouseObjList sharehouseObjList = gson.fromJson(response, SharehouseObjList.class);
        if(reNum==0) {
            sharehouse = sharehouseObjList.output;
            reNum++;
        }else {
            sharehouse = selectedSharehouse;
            reNum++;
            Log.d("Main","selected");
        }
        //Log.d("Main","리넘"+String.valueOf(reNum));
        Log.d("Main","사이즈##########"+sharehouse.size());
            for (int index = 0; index < sharehouse.size(); index++) {


                final String str = sharehouse.get(index).addressText;

                List<Address> addressList1 = null;
                List<Address> addressList2 = null;
                try {
                    // editText에 입력한 텍스트(주소, 지역, 장소 등)을 지오 코딩을 이용해 변환
                    addressList1 = geocoder.getFromLocationName(
                            str, // 주소
                            10); // 최대 검색 결과 개수
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    // editText에 입력한 텍스트(주소, 지역, 장소 등)을 지오 코딩을 이용해 변환
                    addressList2 = geocoder.getFromLocationName(
                            inputStr, // 주소
                            10); // 최대 검색 결과 개수
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //System.out.println(addressList1.get(0).toString());
                // 콤마를 기준으로 split
                String[] splitStr1 = addressList1.get(0).toString().split(",");
                String address1 = splitStr1[0].substring(splitStr1[0].indexOf("\"") + 1, splitStr1[0].length() - 2); // 주소
                System.out.println(address1);

                final String latitude1 = splitStr1[10].substring(splitStr1[10].indexOf("=") + 1); // 위도
                final String longitude1 = splitStr1[12].substring(splitStr1[12].indexOf("=") + 1); // 경도
                //Log.d("Main", latitude1);

                String[] splitStr2 = addressList2.get(0).toString().split(",");

                final String latitude2 = splitStr2[10].substring(splitStr2[10].indexOf("=") + 1); // 위도
                final String longitude2 = splitStr2[12].substring(splitStr2[12].indexOf("=") + 1); // 경도

                // 좌표(위도, 경도) 생성
                LatLng point = new LatLng(Double.parseDouble(latitude1), Double.parseDouble(longitude1));
                // 마커 생성
                MarkerOptions mOptions2 = new MarkerOptions();
                mOptions2.title(sharehouse.get(index).title);
                final String indexTitle = sharehouse.get(index).title;
                final String indexId = sharehouse.get(index).id;



                mOptions2.snippet(address1);
                mOptions2.snippet(sharehouse.get(index).id);

                mOptions2.position(point);
                // 마커 추가
                final Handler handler = new Handler();

                new Thread(new Runnable() {


                    @Override
                    public void run() {

                                // TODO Auto-generated method stub
                                data = getXmlData(longitude2, latitude2, longitude1, latitude1, str, inputTime,indexTitle,indexId);//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기

                                // TODO Auto-generated method stub

                                //Log.d("Main", data);
                    }

                }).start();

                mMap.addMarker(mOptions2);


                mMap.setOnMarkerClickListener(this);
                // 해당 좌표로 화면 줌
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 15));
            }


    }

    String getXmlData(String stX, String stY, String endX, String endY,String addr, int inputTime, String title, String id){


        Log.d("Main",endX+"/ "+endY);
        StringBuffer buffer=new StringBuffer();
        //Log.d("Main",stX+stY+", "+endX+endY);

        String queryUrl="http://ws.bus.go.kr/api/rest/pathinfo/getPathInfoByBusNSub?"//요청 URL
                +"ServiceKey="+serviceKey
                +"&startX=" + stX
                +"&startY=" + stY
                +"&endX=" + endX
                +"&endY=" + endY;
        List<Integer> timeList = new ArrayList<>();
        List<String> selectedAddrList = new ArrayList<>();

        try {
            URL url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is= url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기

            String tag;

            xpp.next();


           int eventType= xpp.getEventType();

            selectedSharehouse = new ArrayList<>();
            while( eventType != XmlPullParser.END_DOCUMENT ){
                Log.d("Main",addr);

                switch( eventType ){

                    case XmlPullParser.START_TAG:
                        tag= xpp.getName();//태그 이름 얻어오기

                        if(tag.equals("item")){

                        }// 첫번째 검색결과

                        else if(tag.equals("time")){

                            xpp.next();
                            int time = Integer.parseInt(xpp.getText());
                            timeList.add(time);
                            //Log.d("Main","시간 : "+time);
                            //Log.d("Main","유저시간 : "+inputTime);

                            buffer.append("  ,  ");
                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName(); //태그 이름 얻어오기

                        if(tag.equals("item")) buffer.append("\n");// 첫번째 검색결과종료..줄바꿈
                        break;
                }

                eventType= xpp.next();


            }

        } catch (Exception e) {
            // TODO Auto-generated catch blocke.printStackTrace();
        }

        if(timeList.size()!=0) {
        int time = timeList.get(0);

        if(inputTime>time){
            Log.d("Main","시간"+time);
            SharehouseObj obj = new SharehouseObj();
            obj.setAddressText(addr);
            obj.setId(title);
            obj.setTitle(id);
            selectedAddrList.add(addr);
            selectedSharehouse.add(obj);
        }

            return selectedAddrList.get(0);
        }
        return "";
    }

    @Override
    public boolean onMarkerClick(Marker marker){
        FragmentManager fm = getSupportFragmentManager();
        ShareroomDetailFragment dialogFragment = new ShareroomDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id",marker.getSnippet());
        dialogFragment.setArguments(bundle);

        dialogFragment.show(fm, "fragment_dialog_test");
        return true;
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        geocoder = new Geocoder(this);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
