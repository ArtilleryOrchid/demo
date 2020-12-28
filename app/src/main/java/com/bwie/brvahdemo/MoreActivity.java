package com.bwie.brvahdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MoreActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private MoreAdapter adapter;
    private List<MoreEntity>list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        init();
    }

    private void init(){
        mRv = findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRv.setLayoutManager(manager);
        adapter = new MoreAdapter(list);
        mRv.setAdapter(adapter);
    }

    private void initData(){
        list.add(new MoreEntity(MoreEntity.TEXT,"A",null));
        list.add(new MoreEntity(MoreEntity.IMG_TEXT,null,"A1"));
        list.add(new MoreEntity(MoreEntity.IMG_TEXT,null,"A2"));
        list.add(new MoreEntity(MoreEntity.IMG_TEXT,null,"A3"));
        list.add(new MoreEntity(MoreEntity.TEXT,"B",null));
        list.add(new MoreEntity(MoreEntity.IMG_TEXT,null,"B1"));
        list.add(new MoreEntity(MoreEntity.IMG_TEXT,null,"B2"));
        list.add(new MoreEntity(MoreEntity.IMG_TEXT,null,"B3"));

    }

}
