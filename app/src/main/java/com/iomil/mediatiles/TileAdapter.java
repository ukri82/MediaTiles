package com.iomil.mediatiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by u on 25.06.2017.
 */

public class TileAdapter extends BaseAdapter
{
    private Context mContext;

    public TileAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount()
    {
        return 5;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tile_card, parent, false);

        TextView text = (TextView)view.findViewById(R.id.tile_text);
        text.setText(position + "");
        return view;
    }
}
