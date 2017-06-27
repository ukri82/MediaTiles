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

    public Type mType;
    public String mData;

    public enum Type {Text, Image, Video};

    public Tile(float x, float y, float width, float height, Type type, String data)
    {
        mX = x;
        mY = y;
        mWidth = width;
        mHeight = height;
        mType = type;
        mData = data;
    }
}
