package com.truong.btvnmasterdev.holder;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.truong.btvnmasterdev.R;
import com.truong.btvnmasterdev.item2;

public class ArtistViewHolder extends ChildViewHolder {
    private TextView mTextView;

    public ArtistViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.tv_item2);
    }

    public void onBind(item2 it){
          mTextView.setText(it.name);
    }
}
