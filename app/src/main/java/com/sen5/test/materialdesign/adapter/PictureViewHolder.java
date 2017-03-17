package com.sen5.test.materialdesign.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sen5.test.R;

/**
 * Created by chenqianghua on 2017/3/17.
 */

public class PictureViewHolder extends RecyclerView.ViewHolder {

     ImageView iv_picture;
     TextView tv_description;
     CardView mCardView;

    public PictureViewHolder(View itemView) {
                super(itemView);
        iv_picture = (ImageView) itemView.findViewById(R.id.picture_recyclerView_item_iv);
        tv_description = (TextView) itemView.findViewById(R.id.picture_recyclerView_item_tv);
        mCardView = (CardView) itemView.findViewById(R.id.picture_recyclerView_item_cv);
    }
}
