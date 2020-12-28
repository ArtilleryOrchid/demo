package com.bwie.brvahdemo;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MoreEntity implements MultiItemEntity {

    private int itemType;
    public static final int TEXT = 1;
    public static final int IMG_TEXT = 2;
    private String tile;
    private String name;
    private int headId = R.mipmap.ic_launcher;

    public MoreEntity(int itemType,String tile, String name){
        this.itemType = itemType;
        this.tile = tile;
        this.name = name;
    }

    public String getTile() {
        return tile;
    }

    public String getName() {
        return name;
    }

    public int getHeadId() {
        return headId;
    }

    //向万能适配提供当前数据封装实体类要使用哪个xml布局
    @Override
    public int getItemType() {
        return itemType;
    }
}
