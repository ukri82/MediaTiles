package com.iomil.mediatiles.content_infra;

import com.iomil.mediatiles.model.Tile;

/**
 * Created by u on 27.06.2017.
 */

public interface ContentBuilderFactory
{
    public TileContentBuilder create(Tile tile);
}
