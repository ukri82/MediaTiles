package com.iomil.mediatiles.content_builders;

import com.iomil.mediatiles.content_infra.ContentBuilderFactory;
import com.iomil.mediatiles.content_infra.TileContentBuilder;
import com.iomil.mediatiles.model.Tile;

/**
 * Created by u on 27.06.2017.
 */

public class ConcreteBuilderFactory implements ContentBuilderFactory
{
    @Override
    public TileContentBuilder create(Tile tile)
    {
        TileContentBuilder builder = null;
        switch (tile.mType)
        {
            case Text :
                builder = new TextContentBuilder();
                break;
            case Image:
                builder = new ImageContentBuilder();
                break;
            case Video:
                builder = new VideoContentBuilder();
                break;
        }
        return builder;
    }
}
