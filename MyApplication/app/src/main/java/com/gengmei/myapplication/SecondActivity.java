package com.gengmei.myapplication;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView rv_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        rv_list =  findViewById(R.id.rv_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rv_list.setLayoutManager(linearLayoutManager);
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("位置为：" + i);
        }
        final ListItemAdapter listItemAdapter = new ListItemAdapter(this, list);
        rv_list.setAdapter(listItemAdapter);
        rv_list.setItemViewCacheSize(10);
        listItemAdapter.setOnItemClickListener(new ListItemAdapter.OnItemClick() {
            @Override
            public void onItemClick(int position) {
                list.remove(position);
                listItemAdapter.notifyItemRemoved(position);

//                listItemAdapter.notifyItemChanged(position);
                if (list.size() - position > 0) {
                    listItemAdapter.notifyItemRangeChanged(position, list.size() + 1 - position);
                }
            }
        });
    }
}
