package com.gengmei.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ListItemAdapter extends RecyclerView.Adapter {
    private Context context;
    private OnItemClick onItemClick;
    private List<String> list;
    public ListItemAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    interface OnItemClick {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClick onItemClickListener){
        this.onItemClick = onItemClickListener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.e("Luckily", "onCreateViewHolder: ");
        View inflate = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
//        return new DialogForRCVItemViewHolder(View.inflate(context, R.layout.listitem, parent));
        return new DialogForRCVItemViewHolder(LayoutInflater.from(context).inflate(R.layout.listitem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Log.e("Luckily", "onBindViewHolder: "+position);
        DialogForRCVItemViewHolder viewHolder = (DialogForRCVItemViewHolder) holder;
        viewHolder.tvTitle.setText("当前item==" + position);
        viewHolder.tvTitle.setBackgroundColor(0xff123456 + (position * 1000));
        viewHolder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick != null) {
                    onItemClick.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class DialogForRCVItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        public DialogForRCVItemViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
