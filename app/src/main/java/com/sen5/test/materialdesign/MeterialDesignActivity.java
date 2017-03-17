package com.sen5.test.materialdesign;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.sen5.test.R;
import com.sen5.test.materialdesign.adapter.ItemSpace;
import com.sen5.test.materialdesign.adapter.PictureAdapter;
import com.sen5.test.materialdesign.bean.Picture;

import java.util.ArrayList;
import java.util.List;

public class MeterialDesignActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private RecyclerView mRecyclerView;
    private List<Picture> mPictures = new ArrayList<>();
    private PictureAdapter mPictureAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meterial_design);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_action_dbinspector_settings);
        }
        initRecyclerView();
    }

    private void initRecyclerView() {
        initShowData();
        initAdapter();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MeterialDesignActivity.this,2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.addItemDecoration(new ItemSpace(5));
        mRecyclerView.setAdapter(mPictureAdapter);
        mRecyclerView.setLayoutAnimation(addAnimation());
    }

    private LayoutAnimationController addAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.item_list_anim);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(animation);
        layoutAnimationController.setInterpolator(new AccelerateInterpolator());
        layoutAnimationController.setDelay(0.5f);
        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
        return layoutAnimationController;
    }

    private void initAdapter() {
        mPictureAdapter = new PictureAdapter(mPictures);
    }

    private void initShowData() {
        Picture picture1 = new Picture(R.drawable.google1,"google壁纸");
        Picture picture2 = new Picture(R.drawable.google2,"google壁纸");
        Picture picture3 = new Picture(R.drawable.google3,"google壁纸");
        Picture picture4 = new Picture(R.drawable.google4,"google壁纸");
        Picture picture5 = new Picture(R.drawable.google5,"google壁纸");
        Picture picture6 = new Picture(R.drawable.google6,"google壁纸");
        Picture picture7 = new Picture(R.drawable.google7,"google壁纸");
        Picture picture8 = new Picture(R.drawable.google8,"google壁纸");
        Picture picture9 = new Picture(R.drawable.google9,"google壁纸");
        Picture picture10 = new Picture(R.drawable.google10,"google壁纸");
        Picture picture11 = new Picture(R.drawable.google11,"google壁纸");
        Picture picture12 = new Picture(R.drawable.google12,"google壁纸");
        Picture picture13 = new Picture(R.drawable.google13,"google壁纸");
        Picture picture14 = new Picture(R.drawable.google14,"google壁纸");
        Picture picture15 = new Picture(R.drawable.google15,"google壁纸");
        Picture picture16 = new Picture(R.drawable.google16,"google壁纸");
        Picture picture17 = new Picture(R.drawable.google17,"google壁纸");
        Picture picture18 = new Picture(R.drawable.google18,"google壁纸");
        mPictures.add(picture1);
        mPictures.add(picture2);
        mPictures.add(picture3);
        mPictures.add(picture4);
        mPictures.add(picture5);
        mPictures.add(picture6);
        mPictures.add(picture7);
        mPictures.add(picture8);
        mPictures.add(picture9);
        mPictures.add(picture10);
        mPictures.add(picture11);
        mPictures.add(picture12);
        mPictures.add(picture13);
        mPictures.add(picture14);
        mPictures.add(picture15);
        mPictures.add(picture16);
        mPictures.add(picture17);
        mPictures.add(picture18);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }
}
