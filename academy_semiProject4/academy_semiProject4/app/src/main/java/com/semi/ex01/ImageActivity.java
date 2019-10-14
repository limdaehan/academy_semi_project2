package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {

    static final int getimagesetting=1001;//for request intent
    static Context mContext;
    ImageView image;
    Button get,send,reflash;
    ListView bloblist;
    static listView list;
    static public int list_cnt;
    String temp="";
    static ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        init();
    }

    private void init() {
        image=(ImageView)findViewById(R.id.image);
        get=(Button) findViewById(R.id.get);
        send=(Button)findViewById(R.id.send);
        reflash=(Button)findViewById(R.id.reflash);
        bloblist=(ListView)findViewById(R.id.bloblist);
        list=new listView(this);
        get.setOnClickListener(this);
        send.setOnClickListener(this);
        reflash.setOnClickListener(this);
        bloblist.setAdapter(list);
        mContext=this;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.get:
                addImage();
                break;
            case R.id.send:
                insert_blob();
                break;
            case R.id.reflash:
                reflash_list();
                break;
        }
    }

    void reflash_list(){
        pd=new ProgressDialog(this);
        pd.setMessage("불러오는중입니다. 잠시만 기다리세요.");
        pd.show();
        loadMysql getting=new loadMysql();
        loadMysql.active=true;
        getting.start();
    }

    void addImage(){
        Intent intent=new Intent(getApplicationContext(),SetImageActivity.class);

        startActivityForResult(intent, getimagesetting);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==getimagesetting){	//if image change

            if(resultCode==RESULT_OK){
                Bitmap selPhoto = null;
                selPhoto=(Bitmap) data.getParcelableExtra("bitmap");
                image.setImageBitmap(selPhoto);//썸네일
                BitMapToString(selPhoto);




            }
        }
    }
    /**
     * bitmap을 string으로
     * @param bitmap
     * @return
     */
    public void BitMapToString(Bitmap bitmap){

        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);	//bitmap compress
        byte [] arr=baos.toByteArray();
        String image= Base64.encodeToString(arr, Base64.DEFAULT);


        try{
            temp="imagedevice="+ URLEncoder.encode(image,"utf-8");
        }catch (Exception e){
            Log.e("exception",e.toString());
        }

    }

    /**
     * string을 bitmap으로
     * @param image
     * @return
     */
    public static Bitmap StringToBitMap(String image){
        Log.e("StringToBitMap","StringToBitMap");
        try{
            byte [] encodeByte=Base64.decode(image,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            Log.e("StringToBitMap","good");
            return bitmap;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }

    void insert_blob(){
        pd=new ProgressDialog(this);
        pd.setMessage("저장중입니다. 잠시만 기다리세요.");
        pd.show();
        controlMysql addinfo=new controlMysql(temp);
        controlMysql.active=true;
        addinfo.start();
    }

    static public void add_image(String result){   //이미지 추가 결과
        Log.e("add_device",result);
        controlMysql.active=false;
        if(result.contains("true")){
            Toast.makeText(mContext, "이미지가 추가되었습니다..", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(mContext, "이미지가 추가되지 못했습니다.", Toast.LENGTH_SHORT).show();
        }
        pd.cancel();

    }
    static public void load_image(String result){
        if(result.contains("false")){
            Toast.makeText(mContext, "이미지를 가져오지 못했습니다.", Toast.LENGTH_SHORT).show();
        }else{
            Bitmap[] getBlob;
            String[] getNo;
            try{
                JSONArray jArray=new JSONArray(result);

                list_cnt=jArray.length();
                Log.e("array_count try",list_cnt+"");
                getNo=new String[list_cnt];
                getBlob=new Bitmap[list_cnt];
                for(int i=0;i<list_cnt;i++){
                    JSONObject jsonObject=jArray.getJSONObject(i);
                    getNo[i]=jsonObject.getString("NO");
                    getBlob[i]=StringToBitMap(jsonObject.getString("IMAGE"));
                    Log.e("load_image",jsonObject.get("IMAGE").toString());
                }
                list.setNo(getNo);
                list.setBlob(getBlob);
                list.notifyDataSetChanged();
            }catch (Exception e){

                String temp=e.toString();

                while (temp.length() > 0) {
                    if (temp.length() > 4000) {
                        Log.e("imageLog", temp.substring(0, 4000));
                        temp = temp.substring(4000);
                    } else {
                        Log.e("imageLog",  temp);
                        break;
                    }
                }
            }

        }
        pd.cancel();
    }
}
