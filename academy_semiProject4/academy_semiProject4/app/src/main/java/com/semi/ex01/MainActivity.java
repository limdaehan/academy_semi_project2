package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapMarkerItem2;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

public class MainActivity extends AppCompatActivity {

   TextView length;
    public static final int sub = 1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        length = findViewById(R.id.length);
        LinearLayout linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        final TMapView tMapView = new TMapView(this);

        tMapView.setSKTMapApiKey( "67861fe6-5c28-4a62-baa7-450ab79e5eac" );
        linearLayoutTmap.addView( tMapView );

        TMapData tmapdata = new TMapData();

        TMapPoint startpoint = new TMapPoint(37.514320, 127.030685);
        final TMapPoint endpoint = new TMapPoint(37.526131, 127.028221);
        TMapData.TMapPathType type = TMapData.TMapPathType.CAR_PATH;

        tmapdata.findPathDataWithType(TMapData.TMapPathType.CAR_PATH, startpoint, endpoint, new TMapData.FindPathDataListenerCallback() {
            @Override
            public void onFindPathData(TMapPolyLine polyLine) {

//                tMapView.addTMapPath(polyLine);

                TMapMarkerItem2 markerItem = new TMapMarkerItem2();
                markerItem.setTMapPoint(endpoint); // 마커의 좌표 지정
                tMapView.addMarkerItem2("s",markerItem);
                length.setText(Double.toString(polyLine.getDistance()));

            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ShareHouse.class);
                startActivityForResult(intent,sub);//액티비티 띄우기
            }
        });

        Button transButton = findViewById(R.id.transButton);
        transButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LastActivity.class);
                startActivityForResult(intent,sub);//액티비티 띄우기
            }
        });

        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LocationInfo.class);
                startActivityForResult(intent,sub);//액티비티 띄우기
            }
        });

        Button urlButton = findViewById(R.id.urlButton);
        urlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UrlPage.class);
                startActivityForResult(intent,sub);//액티비티 띄우기
            }
        });

        Button phpButton = findViewById(R.id.phpButton);
        phpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddSaleActivity2.class);
                startActivityForResult(intent,sub);//액티비티 띄우기
            }
        });

        Button mainButton = findViewById(R.id.mainButton);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DesignActivity.class);
                startActivityForResult(intent,sub);//액티비티 띄우기
            }
        });

        Button imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ImageActivity.class);
                startActivityForResult(intent,sub);//액티비티 띄우기
            }
        });

        Button googleButton = findViewById(R.id.googleBtn);
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),GoogleMapActivity.class);
                startActivityForResult(intent,sub);//액티비티 띄우기
            }
        });
    }
}