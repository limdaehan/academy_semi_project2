package com.semi.ex01;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;

import static android.app.Activity.RESULT_OK;


public class ShareroomDetailFragment extends DialogFragment {

    private WebView webView;
    public static final int sub = 1001;
    private static final String ARG_NO = "ARG_NO";

    public ShareroomDetailFragment() {
        // Required empty public constructor
    }

    public static ShareroomDetailFragment getInstance() {
        ShareroomDetailFragment fragment = new ShareroomDetailFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);


        }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // ViewGroup rootView1 = (ViewGroup) inflater.inflate(R.layout.activity_add_sale2, container, false);
        ViewGroup rootView2 = (ViewGroup) inflater.inflate(R.layout.fragment_addr, container, false);



            String id = getArguments().getString("id"); // 전달한 key 값 String param2 = getArguments().getString("param2"); // 전달한 key 값 }


        //result =  rootView1.findViewById(R.id.addrText);
        webView = (WebView) rootView2.findViewById(R.id.webView);

        // WebView 초기화
        init_webView(id);

        return rootView2;
    }

    public void init_webView(String id) {
        // WebView 설정

        // JavaScript 허용
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSafeBrowsingEnabled(true);
        // JavaScript의 window.open 허용
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        // JavaScript이벤트에 대응할 함수를 정의 한 클래스를 붙여줌
        // 두 번째 파라미터는 사용될 php에도 동일하게 사용해야함
        // web client 를 chrome 으로 설정
        webView.setWebChromeClient(new WebChromeClient());
        // webview url load
        webView.loadUrl("http://1.250.62.157/loadImage3.php?id="+id);
    }

}
