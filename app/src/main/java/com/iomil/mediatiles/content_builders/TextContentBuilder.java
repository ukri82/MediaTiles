package com.iomil.mediatiles.content_builders;

import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iomil.mediatiles.content_infra.TileContentBuilder;
import com.iomil.mediatiles.model.Tile;

/**
 * Created by u on 27.06.2017.
 */

public class TextContentBuilder implements TileContentBuilder
{
    @Override
    public void build(Tile tile, ViewGroup tileView)
    {
        TextView text = new TextView(tileView.getContext());
        text.setText(tile.mData);
        text.setGravity(Gravity.CENTER);
        tileView.addView(text);
    }
}
