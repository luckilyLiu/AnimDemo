package com.gengmei.animdemo.cards;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gengmei.animdemo.R;
import com.gengmei.animdemo.adapter.JobBaseRecyclerAdapter;
import com.gengmei.animdemo.bean.CardBean;

import androidx.annotation.NonNull;

public class Card2Provider extends CardViewProvider<CardBean, Card2Provider.Card1ViewHolder> {

    public Card2Provider() {
    }

    @NonNull
    @Override
    public Card1ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new Card1ViewHolder(inflater.inflate(R.layout.listitem_type1, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Card1ViewHolder holder, @NonNull CardBean cardBean, int position) {
        Log.e("Luckily", "onBindViewHolder: " + cardBean.getCardType() + "position=" + position);
        holder.btn.setText("这个是卡片类型为2的卡片");
        holder.btn.setTextColor(Color.RED);
    }

    @Override
    public void onCardItemClick(View view, CardBean bean, int position) {
    }


    public static class Card1ViewHolder extends JobBaseRecyclerAdapter.JobBaseRecyclerViewHolder {
        TextView btn;

        public Card1ViewHolder(View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.btn);
        }
    }
}
