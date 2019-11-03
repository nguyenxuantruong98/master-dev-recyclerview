package com.truong.btvnmasterdev.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.truong.btvnmasterdev.R;
import com.truong.btvnmasterdev.item;

import java.util.ArrayList;

public class ScrollAdapter extends RecyclerView.Adapter<ScrollAdapter.ScrollHolder>{
    private ArrayList<item> data;
    private LayoutInflater inflater;


    public ScrollAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<item> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ScrollHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item,parent,false);
        return new ScrollHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScrollHolder holder, int position) {
        item it = data.get(position);
        holder.bindData(it);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }


    public class ScrollHolder extends RecyclerView.ViewHolder{
        private TextView tvItem;

        public ScrollHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);
        }
        public void bindData(item it){
            tvItem.setText(it.getItem());
        }
    }
}
