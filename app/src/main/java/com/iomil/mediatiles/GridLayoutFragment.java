package com.iomil.mediatiles;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import com.android.volley.toolbox.NetworkImageView;
import com.iomil.mediatiles.content_builders.ConcreteBuilderFactory;
import com.iomil.mediatiles.content_builders.TextContentBuilder;
import com.iomil.mediatiles.content_infra.ContentBuilderFactory;
import com.iomil.mediatiles.model.Tile;
import com.iomil.mediatiles.content_infra.TileView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GridLayoutFragment extends Fragment
{

    ArrayList<Tile> mTileList = new ArrayList<>();

    public GridLayoutFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid_layout, container, false);
    }

    boolean mIsManual = false;

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        mTileList.add(new Tile(0.05f, 0.05f, 0.45f, 0.45f, Tile.Type.Text, "Tile 1"));
        mTileList.add(new Tile(0.55f, 0.05f, 0.45f, 0.45f, Tile.Type.Text, "Tile 2"));
        mTileList.add(new Tile(0.05f, 0.52f, 0.45f, 0.40f, Tile.Type.Video, "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4"));
        mTileList.add(new Tile(0.55f, 0.52f, 0.45f, 0.40f, Tile.Type.Image, "https://yt3.ggpht.com/-tUnSh4hL1b0/AAAAAAAAAAI/AAAAAAAAAAA/AIy5-05CyFk/s100-c-k-no-mo-rj-c0xffffff/photo.jpg"));

        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(mIsManual)
                    return;

                view.post(new Runnable() {
                    public void run() {
                        doLayout();
                    }
                });
            }
        });

    }

    void doLayout()
    {
        RelativeLayout parentLayout = (RelativeLayout) getView();

        mIsManual = true;
        ContentBuilderFactory factory = new ConcreteBuilderFactory();

        for(Tile tile : mTileList)
        {
            TileView tileView = new TileView(tile, factory);

            ViewGroup tileViewGroup = tileView.createView(getView());

            parentLayout.addView(tileViewGroup);
        }
    }
}
