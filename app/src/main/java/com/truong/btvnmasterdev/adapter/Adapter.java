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

public class Adapter extends RecyclerView.Adapter<Adapter.ItemHolder> {
    private ArrayList<item> data;
    private LayoutInflater inflater;
    private ItemClickListener itemClickListener;

    public Adapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<item> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item,parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, final int position) {
        item it = data.get(position);
        holder.bindData(it);

        if(itemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onItemClicked(position);
                }
            });
        }

    }
    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }

    @Override
    public int getItemCount() {
        return data ==null ? 0 : data.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder{
        private TextView tvItem;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);
        }
        public void bindData(item it){
            tvItem.setText(it.getItem());
        }
    }
    public interface ItemClickListener{
        void onItemClicked(int position);
    }

}
