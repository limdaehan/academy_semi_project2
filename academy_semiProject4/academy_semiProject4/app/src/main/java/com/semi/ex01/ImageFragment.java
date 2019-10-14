package com.semi.ex01;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;

import static android.app.Activity.RESULT_OK;


public class ImageFragment extends Fragment implements View.OnClickListener {

    static final int getimagesetting=1001;//for request intent
    static Context mContext;
    ImageView image;
    Button get,send,reflash;
    ListView bloblist;
    static listView list;
    static public int list_cnt;
    String temp="";
    static ProgressDialog pd;

    OnItemSelectionCallback callback;

    public ImageFragment() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnItemSelectionCallback){
            callback = (OnItemSelectionCallback) context;
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_image, container, false);
        Context context = inflater.getContext();

        init(view,context);

        return view;
    }

    private void init(View view, Context context) {
        image=(ImageView)view.findViewById(R.id.image);
        get=(Button) view.findViewById(R.id.get);
        send=(Button)view.findViewById(R.id.send);
        reflash=(Button)view.findViewById(R.id.reflash);
        bloblist=(ListView)view.findViewById(R.id.bloblist);
        list=new listView(context);
        get.setOnClickListener(this);
        mContext=context;
    }

    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        switch(view.getId()){
            case R.id.get:
                addImage(context);
                break;
        }
    }


    void addImage(Context context){
        Intent intent=new Intent(context,SetImageActivity.class);

        startActivityForResult(intent, getimagesetting);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
            temp=URLEncoder.encode(image,"utf-8");
            Log.d("Main", temp);
            if(callback!=null) {
                callback.onItemSelected(temp);
            }
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
