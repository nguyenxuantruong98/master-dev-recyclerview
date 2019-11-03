package com.truong.btvnmasterdev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.truong.btvnmasterdev.adapter.Adapter;
import com.truong.btvnmasterdev.adapter.DragAdapter;
import com.truong.btvnmasterdev.adapter.EditTextAdapter;
import com.truong.btvnmasterdev.adapter.ExpandableAdapter;
import com.truong.btvnmasterdev.adapter.ScrollAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements Adapter.ItemClickListener{
    private Spinner spinner;
    private RecyclerView rcvItem;
    private ArrayList<item> data;
    private Adapter adapter;
    private ScrollAdapter adapters;
    private DragAdapter dragAdapter;
    private EditTextAdapter editTextAdapter;
    private ExpandableAdapter expandableAdapter;
    private item it;
    private item2 itt;
    ArrayList<Genre> genres;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        sprinner();



    }

    private void expandable(){
        genres = new ArrayList<>();
        ArrayList<item2> dataChild = new ArrayList<>();
//        dataChild.add(new item2("       child 1"));
//        dataChild.add(new item2("       child 2"));
//        dataChild.add(new item2("       child 3"));
//        dataChild.add(new item2("       child 4"));
//        dataChild.add(new item2("       child 5"));
//        dataChild.add(new item2("       child 6"));
        for(int i=0;i<10;i++){
            itt = new item2("       child "+i);
            dataChild.add(itt);
        }


        //data = new ArrayList<>();
        for (int i =0; i <1000 ; i++)
        {
            Genre it2 = new Genre("item "+i ,dataChild);
            genres.add(i,it2);
        }
        //genres.add(it2);
    }

    private void sprinner(){

        spinner=findViewById(R.id.sprinter);
        final ArrayList<String> category=new ArrayList<>();
        category.add("RecyclerView base");
        category.add("RecyclerView in ScrollView or NestedScrollView");
        category.add("RecyclerView in RecyclerView");
        category.add("RecyclerView holder Edittext");
        category.add("RecyclerView implement Drag and Swipe");
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,category);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        adapter = new Adapter(MainActivity.this);
                        rcvItem.setAdapter(adapter);
                        rcvItem.setNestedScrollingEnabled(true);
                        initData();
                        adapter.setData(data);
                        adapter.setOnItemClickListener(MainActivity.this);
                        Toast.makeText(MainActivity.this,"0",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        adapters=new ScrollAdapter(MainActivity.this);
                        rcvItem.setAdapter(adapters);
                        initData();
                        adapters.setData(data);
                        rcvItem.setNestedScrollingEnabled(false);
                        Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        expandable();
                        expandableAdapter = new ExpandableAdapter(genres);
                        rcvItem.setAdapter(expandableAdapter);
                        rcvItem.setNestedScrollingEnabled(false);
                        Toast.makeText(MainActivity.this,"2",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        editTextAdapter = new EditTextAdapter(MainActivity.this);
                        rcvItem.setAdapter(editTextAdapter);
                        dataEdit();
                        editTextAdapter.setData(data);
                        Toast.makeText(MainActivity.this,"3",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        dragAdapter = new DragAdapter(MainActivity.this);
                        rcvItem.setAdapter(dragAdapter);
                        initData();
                        dragAdapter.setData(data);
                        helper();
                        Swiper();

                        Toast.makeText(MainActivity.this,"4",Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void Swiper(){
        ItemTouchHelper swiper =
                new ItemTouchHelper(new ItemTouchHelper
                        .SimpleCallback(0,ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                data.remove(viewHolder.getAdapterPosition());
                dragAdapter.notifyDataSetChanged();

            }

        });
        swiper.attachToRecyclerView(rcvItem);

    }

    private void helper(){
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,0) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder dragged, @NonNull RecyclerView.ViewHolder target) {

                int position_dragged = dragged.getAdapterPosition();
                int position_target = target.getAdapterPosition();

                Collections.swap(data,position_dragged,position_target);

                dragAdapter.notifyItemMoved(position_dragged,position_target);

                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });
        helper.attachToRecyclerView(rcvItem);
    }

    private void initData(){
        data = new ArrayList<>();
        for (int i =0; i <1000 ; i++)
        {
            it = new item("item "+i);
            data.add(i,it);
        }
    }
    private void dataEdit(){

        data = new ArrayList<>();
        for (int i =0; i <1000 ; i++)
        {
            it = new item("input " + i);
            data.add(it);
        }
    }

    private void initView(){
        rcvItem = findViewById(R.id.rcv_item);


    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this,data.get(position).getItem(),Toast.LENGTH_SHORT).show();
    }
}
