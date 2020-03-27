package com.rex.demo.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.rex.demo.R;


public class BusinessViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView time;
    public TextView price;
    public TextView name;
    public TextView location;
    public TextView distance;
    public ImageView businessImg;

    public BusinessViewHolder(View view) {
        super(view);
        time = view.findViewById(R.id.textViewTime);
        price = view.findViewById(R.id.textViewPrice);
        name = view.findViewById(R.id.textViewName);
        location = view.findViewById(R.id.textViewLocation);
        distance = view.findViewById(R.id.textviewDistance);
        businessImg = view.findViewById(R.id.businessImg);
        businessImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
    }

}
