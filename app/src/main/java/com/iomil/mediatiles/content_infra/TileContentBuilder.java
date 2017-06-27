package com.iomil.mediatiles.content_infra;

import android.view.ViewGroup;

import com.iomil.mediatiles.model.Tile;

/**
 * Created by u on 25.06.2017.
 */

public interface TileContentBuilder
{
    public void build(Tile tile, ViewGroup tileView);
}
