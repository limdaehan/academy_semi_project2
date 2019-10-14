package com.semi.ex01;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPOIItem;
import com.skt.Tmap.TMapTapi;
import com.skt.Tmap.TMapView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ShareHouse extends AppCompatActivity {

    TMapData tMapData = new TMapData();
    TMapView tMapView;
    LinearLayout linearLayoutTmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharehouse);

        // Spinner
        final Spinner yearSpinner = (Spinner)findViewById(R.id.spinner_year);
        ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(this,
                R.array.date_year, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        Spinner monthSpinner = (Spinner)findViewById(R.id.spinner_month);
        ArrayAdapter monthAdapter = ArrayAdapter.createFromResource(this,
                R.array.date_month, android.R.layout.simple_spinner_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthAdapter);

        linearLayoutTmap = (LinearLayout)findViewById(R.id.linearLayoutTmap);
        tMapView = new TMapView(this);

        tMapView.setSKTMapApiKey( "67861fe6-5c28-4a62-baa7-450ab79e5eac" );


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
                    final ArrayList<TMapPOIItem> items = new ArrayList();
                    /*tMapTapi.invokeSearchPortal(text+" 쉐어하우스");*/
                    tMapData.findAddressPOI("서울 " + text + " 쉐어하우스", new TMapData.FindAddressPOIListenerCallback() {
                        @Override
                        public void onFindAddressPOI(ArrayList<TMapPOIItem> arrayList) {
                            for (int i = 0; i < arrayList.size(); i++) {

                                TMapPOIItem item = (TMapPOIItem) arrayList.get(i);

                                items.add(item);

                                Log.d("POI Name: ", item.getPOIName().toString() + ", " +
                                        "Address: " + item.getPOIAddress().replace("null", "") + ", " +
                                        "Point: " + item.getPOIPoint().toString());
                            }

                            tMapView.addTMapPOIItem(items);
                        }
                    });

                    linearLayoutTmap.addView(tMapView);
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



}