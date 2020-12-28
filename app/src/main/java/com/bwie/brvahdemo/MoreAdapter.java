package com.bwie.brvahdemo;

import android.content.ContentResolver;
import android.support.v4.widget.DrawerLayout;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class MoreAdapter extends BaseMultiItemQuickAdapter<MoreEntity,BaseViewHolder> {

    public MoreAdapter(List<MoreEntity> data) {
        super(data);
        addItemType(MoreEntity.TEXT,R.layout.item_tv);
        addItemType(MoreEntity.IMG_TEXT,R.layout.item_main);
    }

    @Override
    protected void convert(BaseViewHolder helper, MoreEntity item) {
        //根据实体类MoreEntity中itemType区分不同布局中控件的使用
        if (helper.getItemViewType() == MoreEntity.TEXT){
            //纯文本
            helper.setText(R.id.item_more_Tv,item.getTile());
        }else if (helper.getItemViewType() == MoreEntity.IMG_TEXT){
            //图文
            helper.setText(R.id.title_Tv,item.getName());
            helper.setImageResource(R.id.head_Img,item.getHeadId());
        }
    }
}
