package com.serafynurh.myhealth;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ImageAdapter extends BaseAdapter {
    Context mContext;
    int [] images;
    ArrayList<String> titles;
    public ImageAdapter(Context mContext,int [] images,ArrayList<String> titles) {
        this.mContext = mContext;
        this.images=images;
        this.titles=titles;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if ( convertView== null){
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_item_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView. findViewById(R.id.imageViewGrid);
            viewHolder.textViewTitle= (TextView) convertView.findViewById(R.id.textViewTitle);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.imageView.setImageResource(images[position]);
        viewHolder.textViewTitle.setText(titles.get(position));
        return convertView;
    }

    public  void filter(String searchText){
        searchText=searchText.toLowerCase();


    }
    static class ViewHolder {
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewDesc;
    }
}

