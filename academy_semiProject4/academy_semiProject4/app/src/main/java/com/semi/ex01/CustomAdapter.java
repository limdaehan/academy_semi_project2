package com.semi.ex01;

import android.content.Intent;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Roommate> mList;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView postNo;
        protected TextView req1;
        protected TextView req2;
        protected TextView req3;
        protected TextView req4;
        protected TextView personCount;
        protected Button detailButton;






        public CustomViewHolder(View view) {
            super(view);
            this.postNo = view.findViewById(R.id.postNo);
            this.req1 = view.findViewById(R.id.req1);
            this.req2 = view.findViewById(R.id.req2);
            this.req3 = view.findViewById(R.id.req3);
            this.req4 = view.findViewById(R.id.req4);
            this.personCount = view.findViewById(R.id.personCount);
            this.detailButton = view.findViewById(R.id.detailButton);

            detailButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.d("Main", "버튼 클릭");
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Roommate detail = mList.get(pos);
                        Log.d("Main", "List 출력" + detail.getId() + "position" + pos);

                        Log.d("Main", "count" + detail.getPersonCount() + " maxCount " + detail.getMaxPersonCount());

                        Intent intent = new Intent(view.getContext(), DetailActivity.class);

                        intent.putExtra("id", detail.getId());
                        intent.putExtra("title" , detail.getMatchTitle());
                        intent.putExtra("personality", detail.getMatchPersonality());
                        intent.putExtra("roomSize", detail.getMatchGender());
                        intent.putExtra("roomType", detail.getMatchRoomType());
                        intent.putExtra("price", detail.getMatchPrice());
                        intent.putExtra("personCount", detail.getPersonCount());
                        intent.putExtra("maxPersonCount", detail.getMaxPersonCount());

                        view.getContext().startActivity(intent);

                    }

                }
            });

        }

    }

    public void clear () {
        mList.clear();
    }


    public CustomAdapter(ArrayList<Roommate> list) {
        this.mList = list;

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewHolder, int position){

        viewHolder.postNo.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        viewHolder.req1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        viewHolder.req2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        viewHolder.req3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        viewHolder.req4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

        viewHolder.postNo.setText(mList.get(position).getMatchTitle());
        viewHolder.req1.setText(mList.get(position).getMatchPrice());
        viewHolder.req2.setText(mList.get(position).getMatchRoomType());
        viewHolder.req3.setText(mList.get(position).getMatchGender());
        viewHolder.req4.setText(mList.get(position).getMatchPersonality());

        viewHolder.personCount.setText(mList.get(position).getPersonCount() + " / " + mList.get(position).getMaxPersonCount());

    }

    @Override
    public int getItemCount() {
        return  (null != mList ? mList.size() : 0);
    }

}

