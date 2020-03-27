package com.rex.demo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rex.demo.R;
import com.rex.demo.adapter.holder.BusinessViewHolder;
import com.rex.demo.model.Business;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HomeAdapter extends RecyclerView.Adapter<BusinessViewHolder> {
    private Context context;
    private List<Business> businessList;
    private Resources resources;
    private LayoutInflater inflater;
    private Bitmap bitmap;

    public HomeAdapter(Context context, List<Business> businessList) {
        this.context = context;
        this.businessList = businessList;
        this.resources = context.getResources();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public BusinessViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.home_cell, parent, false);
        return new BusinessViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final BusinessViewHolder holder, final int position) {
        final Business business = businessList.get(position);
        holder.distance.setText(business.getDistance());
        holder.location.setText(business.getLocation());
        holder.name.setText(business.getName());
        holder.price.setText(business.getPrice());
        holder.time.setText(business.getTime());
        Glide.with(context).load(business.getImgUrl()).into(holder.businessImg);
    }

    @Override
    public int getItemCount() {
        return null == businessList ? 0 : businessList.size();
    }

}