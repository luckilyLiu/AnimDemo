package com.gengmei.animdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerAdapter extends RecyclerView.Adapter {
    private List<String> list;
    private FragmentActivity context;

    public ViewPagerAdapter(FragmentActivity horizontalListActivity) {
        this.context = horizontalListActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewPagerViewHolder viewHolder = new ViewPagerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_job_category_resume, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class ViewPagerViewHolder extends RecyclerView.ViewHolder {

        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}