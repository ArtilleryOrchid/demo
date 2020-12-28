package com.bwie.brvahdemo;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;
import java.util.Map;

public class MainAdapter extends BaseQuickAdapter<Map<String,Object>,BaseViewHolder> {

    public MainAdapter(int layoutResId, @Nullable List<Map<String, Object>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Map<String, Object> item) {
        String title = (String) item.get("title");
        int resId = (int) item.get("img");
        helper.setImageResource(R.id.head_Img,resId);
        helper.setText(R.id.title_Tv,title);
        helper.addOnClickListener(R.id.head_Img);//给headimg添加点击事件
    }
}
