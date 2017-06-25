package com.iomil.mediatiles.model;

/**
 * Created by u on 25.06.2017.
 */

public class Tile
{
    public float mX;
    public float mY;
    public float mWidth;
    public float mHeight;

    public int mType;
    public String mData;

    public Tile(float x, float y, float width, float height, int type, String data)
    {
        mX = x;
        mY = y;
        mWidth = width;
        mHeight = height;
        mType = type;
        mData = data;
    }
}
