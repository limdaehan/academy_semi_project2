package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

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
import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPOIItem;
import com.skt.Tmap.TMapTapi;
import com.skt.Tmap.TMapView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShareHouseActivity3 extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Geocoder geocoder;

    LinearLayout linearLayoutTmap;
    RequestQueue queue;
    ArrayList<SharehouseObj> sharehouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_house3);

        // Spinner
        final Spinner yearSpinner = (Spinner)findViewById(R.id.spinner_year);
        ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(this,
                R.array.date_year, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        if (queue == null)
            queue = Volley.newRequestQueue(getApplicationContext());

        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if( null != linearLayoutTmap ) {

                }

                if (i != 0) {

                    String text = yearSpinner.getSelectedItem().toString();
                    sendRequest(text);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        // Set default selection for spinner
        int defaultState = yearAdapter.getPosition(0);

        if (defaultState == -1)
        {
            defaultState = 0;
        }

        yearSpinner.setSelection(defaultState);
    }

    /////////////
    public void sendRequest(final String addr){
        String url = "http://1.250.62.157:6000/addshareroom/AddrSelect";
        url += "?addressText=" + addr;
        Log.d("Main",url);


        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Main", response);
                        processResponse(response, addr);  // 응답 처리 메서드
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

    public void processResponse(String response, String text) {
        Gson gson = new Gson();
        SharehouseObjList sharehouseObjList = gson.fromJson(response, SharehouseObjList.class);
        sharehouse = sharehouseObjList.output;

        for (int index = 0; index < sharehouse.size(); index++){
            String str=sharehouse.get(index).addressText;
            List<Address> addressList = null;
            try {
                // editText에 입력한 텍스트(주소, 지역, 장소 등)을 지오 코딩을 이용해 변환
                addressList = geocoder.getFromLocationName(
                        str, // 주소
                        5); // 최대 검색 결과 개수
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(addressList.get(0).toString());
            // 콤마를 기준으로 split
            String []splitStr = addressList.get(0).toString().split(",");
            String address = splitStr[0].substring(splitStr[0].indexOf("\"") + 1,splitStr[0].length() - 2); // 주소
            System.out.println(address);

            String latitude = splitStr[10].substring(splitStr[10].indexOf("=") + 1); // 위도
            String longitude = splitStr[12].substring(splitStr[12].indexOf("=") + 1); // 경도
            System.out.println(latitude);
            System.out.println(longitude);

            // 좌표(위도, 경도) 생성
            LatLng point = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
            // 마커 생성
            MarkerOptions mOptions2 = new MarkerOptions();
            mOptions2.title(sharehouse.get(index).title);


            mOptions2.snippet(address);
            mOptions2.snippet(sharehouse.get(index).id);

            mOptions2.position(point);
            // 마커 추가
            mMap.addMarker(mOptions2);

            mMap.setOnMarkerClickListener(this);
            // 해당 좌표로 화면 줌
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point,15));
        }

        //linearLayoutTmap.addView(tMapView);

    }

    @Override
    public boolean onMarkerClick(Marker marker){
        FragmentManager fm = getSupportFragmentManager();
        ShareroomDetailFragment dialogFragment = new ShareroomDetailFragment();
        Bundle bundle = new Bundle(1);
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
