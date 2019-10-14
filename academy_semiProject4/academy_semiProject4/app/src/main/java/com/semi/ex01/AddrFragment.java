package com.semi.ex01;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;


public class AddrFragment extends DialogFragment {

    OnItemSelectionCallback callback;
    private WebView webView;
    private TextView result;
    private Handler handler;
    public static final int sub = 1001;
    private static final String ARG_NO = "ARG_NO";

    public static AddrFragment getInstance() {
        AddrFragment fragment = new AddrFragment();
        /*Bundle args = new Bundle();
        args.putInt(ARG_NO, no);
        fragment.setArguments(args);*/
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
//
//        setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme_);
    }

    public AddrFragment() {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment



       // ViewGroup rootView1 = (ViewGroup) inflater.inflate(R.layout.activity_add_sale2, container, false);
        ViewGroup rootView2 = (ViewGroup) inflater.inflate(R.layout.fragment_addr, container, false);

        //result =  rootView1.findViewById(R.id.addrText);
        webView = (WebView) rootView2.findViewById(R.id.webView);

        // WebView 초기화
        init_webView();

        // 핸들러를 통한 JavaScript 이벤트 반응
        handler = new Handler();


        return rootView2;
    }

    public void init_webView() {
        // WebView 설정

        // JavaScript 허용
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSafeBrowsingEnabled(true);
        // JavaScript의 window.open 허용
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        // JavaScript이벤트에 대응할 함수를 정의 한 클래스를 붙여줌
        // 두 번째 파라미터는 사용될 php에도 동일하게 사용해야함
        webView.addJavascriptInterface(new AndroidBridge(), "TestApp");
        // web client 를 chrome 으로 설정
        webView.setWebChromeClient(new WebChromeClient());
        // webview url load
        webView.loadUrl("http://1.250.62.157/daum.php");
    }

    private class AndroidBridge {
        @JavascriptInterface
        public void setAddress(final String arg1, final String arg2, final String arg3) {
            handler.post(new Runnable() {
                @Override
                public void run() {

                    result = ((AddSaleActivity2) getActivity()).findViewById(R.id.addrText);
                    result.setText(String.format("%s %s", arg2, arg3));
                    // WebView를 초기화 하지않으면 재사용할 수 없음
                    init_webView();

                }
            });
        }
    }

}
