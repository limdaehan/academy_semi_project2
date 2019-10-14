package com.semi.ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class SetImageActivity extends AppCompatActivity implements View.OnClickListener{

    Button CloseBtn,cameraBtn,galleryBtn;

    static final int camera=2001;
    static final int gallery=2002;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_image);

        init();


        galleryBtn.setOnClickListener(this);
        cameraBtn.setOnClickListener(this);
        CloseBtn.setOnClickListener(this);
    }

    private void init() {

        cameraBtn=(Button) findViewById(R.id.cameraBtn);
        galleryBtn=(Button) findViewById(R.id.galleryBtn);
        CloseBtn=(Button) findViewById(R.id.CloseBtn);

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch(v.getId()){
            case R.id.cameraBtn:
                intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, camera);
                break;
            case R.id.galleryBtn:

                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/-");
                startActivityForResult(intent, gallery);
                break;

            case R.id.CloseBtn:
                setResult(RESULT_CANCELED, intent);
                Toast.makeText(getApplicationContext(), "설정을 유지합니다.", Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                break;
        }

    }
    @SuppressLint("NewApi")
    private Bitmap resize(Bitmap bm){

        Configuration config=getResources().getConfiguration();
        if(config.smallestScreenWidthDp>=800)
            bm = Bitmap.createScaledBitmap(bm, 400, 240, true);//이미지 크기로 인해 용량초과
        else if(config.smallestScreenWidthDp>=600)
            bm = Bitmap.createScaledBitmap(bm, 300, 180, true);
        else if(config.smallestScreenWidthDp>=400)
            bm = Bitmap.createScaledBitmap(bm, 200, 120, true);
        else if(config.smallestScreenWidthDp>=360)
            bm = Bitmap.createScaledBitmap(bm, 180, 108, true);
        else
            bm = Bitmap.createScaledBitmap(bm, 160, 96, true);

        return bm;

    }
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == TAKE_CAMERA){
                Uri currImageURI = data.getData();
                tv.setText("CAMERA : " + getRealPathFromURI(currImageURI));
            }else if(requestCode == TAKE_GALLERY){
                Uri currImageURI = data.getData();
                tv.setText("GALLERY : " + getRealPathFromURI(currImageURI));
            }
        }
    }

    public String getRealPathFromURI(Uri contentUri){
        String [] proj={MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery( contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);

    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent=new Intent();
        Bitmap bm;
        Bundle extras;
        if (resultCode == RESULT_OK) {
            switch(requestCode){
                case camera:

                        extras = data.getExtras();
                        bm = (Bitmap) extras.get("data");
                        //bm= MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());

                        bm=resize(bm);
                        intent.putExtra("bitmap",bm);

                    setResult(RESULT_OK, intent);
                    finish();
                    break;
                case gallery:

                        extras = data.getExtras();
                        bm = (Bitmap) extras.get("data");
                        //bm = MediaStore.Images.Media.getBitmap( getContentResolver(), data.getData());
                        bm=resize(bm);
                        intent.putExtra("bitmap",bm);

                    setResult(RESULT_OK, intent);
                    finish();
                    break;

                default:
                    setResult(RESULT_CANCELED, intent);
                    finish();
                    break;

            }
        }else{
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }
}
