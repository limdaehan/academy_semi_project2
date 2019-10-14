package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.MapView;
import com.google.gson.Gson;
import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPOIItem;
import com.skt.Tmap.TMapTapi;
import com.skt.Tmap.TMapView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShareHouseActivity2 extends AppCompatActivity {

    TMapData tMapData = new TMapData();
    TMapView tMapView;
    LinearLayout linearLayoutTmap;
    RequestQueue queue;
    ArrayList<SharehouseObj> sharehouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_house2);

        // Spinner
        final Spinner yearSpinner = (Spinner)findViewById(R.id.spinner_year);
        ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(this,
                R.array.date_year, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);



        linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        tMapView = new TMapView(this);

        tMapView.setSKTMapApiKey( "67861fe6-5c28-4a62-baa7-450ab79e5eac" );

        if (queue == null)
            queue = Volley.newRequestQueue(getApplicationContext());


        Button button = findViewById(R.id.button);



        final TMapTapi tMapTapi = new TMapTapi(this);
        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



                if( null != linearLayoutTmap ) {
                    linearLayoutTmap.removeView( tMapView );
                }
                tMapView = new TMapView(linearLayoutTmap.getContext());

                tMapView.setSKTMapApiKey( "67861fe6-5c28-4a62-baa7-450ab79e5eac" );

                if (i != 0) {

                    String text = yearSpinner.getSelectedItem().toString();
                    sendRequest(text);
                    //Log.d("Main", sharehouse.toString());


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


        final ArrayList<TMapPOIItem> items = new ArrayList();
        final ArrayList<TMapMarkerItem> tMapMarkerItems = new ArrayList();
        /*tMapTapi.invokeSearchPortal(text+" 쉐어하우스");*/
        for (int index = 0; index < sharehouse.size(); index++){
            tMapData.findAddressPOI(sharehouse.get(index).addressText, new TMapData.FindAddressPOIListenerCallback() {

                @Override
                public void onFindAddressPOI(ArrayList<TMapPOIItem> arrayList) {

                    //for (int i = 0; i < arrayList.size(); i++) {

                        TMapPOIItem item = (TMapPOIItem) arrayList.get(0);


                    //TMapMarkerItem tMapMarkerItem = new TMapMarkerItem();

                    //tMapMarkerItem.setPosition((float) item.getPOIPoint().getLatitude(),(float)item.getPOIPoint().getLongitude());
                    //tMapMarkerItem.setCalloutTitle(sharehouse.get(index).addressText);
                    //tMapMarkerItems.add(tMapMarkerItem);

                        items.add(item);

                        Log.d("POI Name: ", item.getPOIName() + ", " +
                                "Address: " + item.getPOIAddress().replace("null", "") + ", " +
                                "Point: " + item.getPOIPoint().toString());
                    //}

                    tMapView.addTMapPOIItem(items);
                    //tMapView.addMarkerItem("1", tMapMarkerItem);
                }
            });
    }

        linearLayoutTmap.addView(tMapView);

    }


}
