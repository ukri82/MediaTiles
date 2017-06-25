package com.iomil.mediatiles;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayout;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iomil.mediatiles.model.Tile;

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


        mTileList.add(new Tile(0.05f, 0.1f, 0.6f, 0.4f, 0, "Tile 1"));
        mTileList.add(new Tile(0.75f, 0.1f, 0.20f, 0.45f, 0, "Tile 2"));
        mTileList.add(new Tile(0.0f, 0.5f, 0.4f, 0.4f, 0, "Tile 3"));
        mTileList.add(new Tile(0.52f, 0.6f, 0.4f, 0.35f, 0, "Tile 4"));

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

        int width = getView().getWidth();
        int height = getView().getHeight();

        mIsManual = true;

        for(Tile tile : mTileList)
        {
            LinearLayout LL = new LinearLayout(getActivity());
            LL.setBackgroundColor(Color.RED);
            LL.setOrientation(LinearLayout.VERTICAL);

            int layoutHeight = (int)(height * tile.mHeight);
            int layoutWidth = (int)(width * tile.mWidth);
            LinearLayout.LayoutParams LLParams = new LinearLayout.LayoutParams(layoutWidth, layoutHeight);
            LL.setX(width * tile.mX);
            LL.setY(height * tile.mY);

            LL.setLayoutParams(LLParams);

            TextView text = new TextView(getContext());
            text.setText(tile.mData);
            text.setGravity(Gravity.CENTER);
            LL.addView(text);

            parentLayout.addView(LL);
        }



    }
    void doLayout1()
    {
        GridLayout gridLayout = (GridLayout) getView();
        int width = getView().getWidth();
        int height = getView().getHeight();
        gridLayout.setRowCount(height);
        gridLayout.setColumnCount(width);

        LinearLayout LL = new LinearLayout(getActivity());
        LL.setBackgroundColor(Color.CYAN);
        LL.setOrientation(LinearLayout.VERTICAL);

        int layoutHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        int layoutWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120, getResources().getDisplayMetrics());
        LinearLayout.LayoutParams LLParams = new LinearLayout.LayoutParams(layoutWidth, layoutHeight);
        LL.setLayoutParams(LLParams);


        GridLayout.Spec rowSpan = GridLayout.spec(GridLayout.UNDEFINED, 200);
        GridLayout.Spec colspan = GridLayout.spec(GridLayout.UNDEFINED, 200);

        GridLayout.LayoutParams gridParam = new GridLayout.LayoutParams(rowSpan, colspan);

        gridLayout.addView(LL);
    }
}
