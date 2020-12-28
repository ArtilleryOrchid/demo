package com.bwie.brvahdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements
        BaseQuickAdapter.OnItemClickListener,View.OnClickListener,
        BaseQuickAdapter.OnItemChildClickListener{

    private RecyclerView mRv;
    private Button mfootBtn;
    private MainAdapter adapter;
    private List<Map<String,Object>>list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        init();
    }

    private void init(){
        View headView = LayoutInflater.from(this).inflate(R.layout.view_head,null);
        View footView = LayoutInflater.from(this).inflate(R.layout.view_foot,null);
        mfootBtn = footView.findViewById(R.id.footBtn);
        mfootBtn.setOnClickListener(this);
        mRv = findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRv.setLayoutManager(manager);
        adapter = new MainAdapter(R.layout.item_main,list);
        mRv.setAdapter(adapter);
        adapter.addHeaderView(headView);
        adapter.addFooterView(footView);
        adapter.setOnItemClickListener(this);//添加万能适配器item点击监听
        adapter.setOnItemChildClickListener(this);
    }

    private void initData(){
         for (int i = 0;i < 20;i ++){
             Map<String,Object>map = new HashMap<>();
             map.put("title","name:"+i);
             map.put("img",R.mipmap.ic_launcher);
             list.add(map);
         }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        //获取与item布局关联的数据源->Map<String,Object>
        List<Map<String,Object>> data=adapter.getData();
        Map<String,Object>map = data.get(position);
        String title = (String) map.get("title");
        Toast.makeText(this,title,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
           Toast.makeText(this,"点击加载更多按钮",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
          if (view.getId() == R.id.head_Img){
              Toast.makeText(this,"头像ImageView被点击",Toast.LENGTH_SHORT).show();
          }
    }
}
