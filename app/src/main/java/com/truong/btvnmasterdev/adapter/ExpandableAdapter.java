package com.truong.btvnmasterdev.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;
import com.truong.btvnmasterdev.Genre;
import com.truong.btvnmasterdev.R;
import com.truong.btvnmasterdev.holder.ArtistViewHolder;
import com.truong.btvnmasterdev.holder.GenreViewHolder;
import com.truong.btvnmasterdev.item;
import com.truong.btvnmasterdev.item2;

import java.util.ArrayList;
import java.util.List;

public class ExpandableAdapter extends ExpandableRecyclerViewAdapter<GenreViewHolder,ArtistViewHolder > {
    private ArrayList<item> data;

    public ExpandableAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }


    @Override
    public GenreViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new GenreViewHolder(view);
    }

    @Override
    public ArtistViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2,parent,false);
        return new ArtistViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(ArtistViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final item2 it = (item2) group.getItems().get(childIndex);
        holder.onBind(it);
    }

    @Override
    public void onBindGroupViewHolder(GenreViewHolder holder, int flatPosition, ExpandableGroup group) {
        final Genre it2 = (Genre) group;
        holder.onBind(it2);
    }
}
