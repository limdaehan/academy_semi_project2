package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class trans extends AppCompatActivity {

    EditText edit1;
    TextView text;
    EditText edit2;
    EditText edit3;
    EditText edit4;

    String serviceKey="qgFUCfQcQeSe7os32N4IgmTG9H64WZryX6BCU9f9%2Fx97tzLwfbRiD%2FNSZ0QK5a6l78q8%2B3uZWLR69rY%2FxG6QeA%3D%3D";

    String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        text = findViewById(R.id.text);

    }
    //Button을 클릭했을 때 자동으로 호출되는 callback method
    public void mOnClick(View v){

        switch( v.getId() ){
            case R.id.searchButton:


                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        data= getXmlData();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기


                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                text.setText(data); //TextView에 문자열  data 출력
                                Log.d("Main",data);
                            }
                        });

                    }
                }).start();

                break;
        }

    }


    String getXmlData(){

        StringBuffer buffer=new StringBuffer();



        String str1= edit1.getText().toString();//EditText에 작성된 Text얻어오기
        String stX = URLEncoder.encode(str1);//한글의 경우 인식이 안되기에 utf-8 방식으로 encoding     //지역 검색 위한 변수
        String str2= edit2.getText().toString();//EditText에 작성된 Text얻어오기
        String stY = URLEncoder.encode(str2);//한글의 경우 인식이 안되기에 utf-8 방식으로 encoding     //지역 검색 위한 변수
        String str3= edit3.getText().toString();//EditText에 작성된 Text얻어오기
        String endX = URLEncoder.encode(str3);//한글의 경우 인식이 안되기에 utf-8 방식으로 encoding     //지역 검색 위한 변수
        String str4= edit4.getText().toString();//EditText에 작성된 Text얻어오기
        String endY = URLEncoder.encode(str4);//한글의 경우 인식이 안되기에 utf-8 방식으로 encoding     //지역 검색 위한 변수


        String queryUrl="http://ws.bus.go.kr/api/rest/pathinfo/getPathInfoByBusNSub?"//요청 URL
                +"ServiceKey="+serviceKey
                +"&startX=" + stX
                +"&startY=" + stY
                +"&endX=" + endX
                +"&endY=" + endY;

        try {
            URL url= new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is= url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();
            XmlPullParser xpp= factory.newPullParser();
            xpp.setInput( new InputStreamReader(is, "UTF-8") ); //inputstream 으로부터 xml 입력받기

            String tag;

            xpp.next();
            int eventType= xpp.getEventType();

            while( eventType != XmlPullParser.END_DOCUMENT ){
                switch( eventType ){
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱 시작...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag= xpp.getName();//태그 이름 얻어오기

                        if(tag.equals("item")) ;// 첫번째 검색결과

                        else if(tag.equals("time")){
                            buffer.append("소요시간 :");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append(",  ");
                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag= xpp.getName(); //태그 이름 얻어오기

                        if(tag.equals("item")) buffer.append("\n");// 첫번째 검색결과종료..줄바꿈

                        //break;
                }

                eventType= xpp.next();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch blocke.printStackTrace();
        }

        buffer.append("파싱 끝\n");

        return buffer.toString();//StringBuffer 문자열 객체 반환

    }

}

