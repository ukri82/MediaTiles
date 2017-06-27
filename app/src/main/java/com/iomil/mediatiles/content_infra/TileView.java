package com.iomil.mediatiles.content_infra;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.iomil.mediatiles.model.Tile;

/**
 * Created by u on 25.06.2017.
 */

public class TileView
{
    Tile mTile;
    ContentBuilderFactory mFactory;

    public TileView(Tile tile)
    {
        mTile = tile;
    }

    public void linkFactory(ContentBuilderFactory factory)
    {
        mFactory = factory;
    }

    public ViewGroup createView(View parentView)
    {
        int width = parentView.getWidth();
        int height = parentView.getHeight();

        LinearLayout linearLayout = new LinearLayout(parentView.getContext());
        linearLayout.setBackgroundColor(Color.RED);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        int layoutHeight = (int)(height * mTile.mHeight);
        int layoutWidth = (int)(width * mTile.mWidth);
        LinearLayout.LayoutParams LLParams = new LinearLayout.LayoutParams(layoutWidth, layoutHeight);
        linearLayout.setX(width * mTile.mX);
        linearLayout.setY(height * mTile.mY);

        linearLayout.setLayoutParams(LLParams);

        TileContentBuilder builder = mFactory.create(mTile);
        builder.build(mTile, linearLayout);

        return linearLayout;
    }
}
