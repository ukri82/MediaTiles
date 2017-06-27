package com.iomil.mediatiles.content_builders;

import android.net.Uri;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.android.volley.toolbox.NetworkImageView;
import com.iomil.mediatiles.R;
import com.iomil.mediatiles.content_infra.TileContentBuilder;
import com.iomil.mediatiles.model.Tile;
import com.iomil.mediatiles.network.ImgController;

/**
 * Created by u on 27.06.2017.
 */

public class VideoContentBuilder implements TileContentBuilder
{

    @Override
    public void build(Tile tile, ViewGroup tileView)
    {
        VideoView videoView = new VideoView(tileView.getContext());
        videoView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        tileView.addView(videoView);

        videoView.setVideoURI(Uri.parse(tile.mData));
        videoView.start();

    }
}
