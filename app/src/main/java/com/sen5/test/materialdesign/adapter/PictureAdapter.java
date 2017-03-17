package com.sen5.test.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.sen5.test.R;
import com.sen5.test.materialdesign.bean.Picture;

import java.util.List;

/**
 * Created by chenqianghua on 2017/3/17.
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureViewHolder>{


    private List<Picture> mPictures;
    private Context mContext;

    public PictureAdapter(List<Picture> pictures) {
        mPictures = pictures;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.picturerecyclerview_item,null);
        PictureViewHolder pictureViewHolder = new PictureViewHolder(view);
        return pictureViewHolder;
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        Picture picture = mPictures.get(position);
            holder.tv_description.setText(picture.getDiscription());
        //load加载的可以是一个网络路径也可以是file和资源文件id
        Glide.with(mContext).load(picture.getResouceId()).into(holder.iv_picture);
    }

    @Override
    public int getItemCount() {
        return mPictures.size();
    }
}
