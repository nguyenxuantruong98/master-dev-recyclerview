package com.truong.btvnmasterdev.holder;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;
import com.truong.btvnmasterdev.Genre;
import com.truong.btvnmasterdev.R;

public class GenreViewHolder extends GroupViewHolder {
    private TextView genreTitle;

    public GenreViewHolder(View itemView) {
        super(itemView);
        genreTitle = itemView.findViewById(R.id.tv_item);
    }
    public void onBind(Genre genre){
        genreTitle.setText(genre.getTitle());
    }
}
