package com.semi.ex01;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.semi.ex01.MainActivity;
import com.semi.ex01.R;


public class BottomBarFragment extends Fragment {

    public BottomBarFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_bottom_bar, container, false);

        //home 버튼만 했음
        Button homeBtn = rootView.findViewById(R.id.homeBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMainActivity();
            }
        });

        return rootView;
    }

    public void showMainActivity(){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivityForResult(intent, 101);

    }

}

