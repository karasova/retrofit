package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    ArrayList<Hit> hits;
    Context context;
    Picasso picasso;

    public ImageAdapter(ArrayList<Hit> hits, Context context, Picasso picasso) {
        this.hits = hits;
        this.context = context;
        this.picasso = picasso;
    }

    @Override
    public int getCount() {
        return hits.size();
    }

    @Override
    public Hit getItem(int position) {
        return hits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.activity_hit, parent, false);
        ImageView iv = convertView.findViewById(R.id.hit);

        Hit hit = getItem(position);
        picasso.load(hit.webformatURL).error(R.drawable.cat).into(iv);
        return convertView;
    }
}


