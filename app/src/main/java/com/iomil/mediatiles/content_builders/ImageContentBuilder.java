package com.iomil.mediatiles.content_builders;

import android.app.ActionBar;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.iomil.mediatiles.ImgController;
import com.iomil.mediatiles.LruBitmapCache;
import com.iomil.mediatiles.R;
import com.iomil.mediatiles.content_infra.TileContentBuilder;
import com.iomil.mediatiles.model.Tile;

/**
 * Created by u on 27.06.2017.
 */

public class ImageContentBuilder implements TileContentBuilder
{

    @Override
    public void build(Tile tile, ViewGroup tileView)
    {
        NetworkImageView imageView = new NetworkImageView(tileView.getContext());
        imageView.setAdjustViewBounds(true);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        tileView.addView(imageView);

        imageView.setDefaultImageResId(R.mipmap.ic_launcher);
        imageView.setImageUrl(tile.mData, ImgController.getInstance().getImageLoader());

    }
}
