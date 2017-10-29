package com.example.bulgo.android;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.bulgo.android.databinding.ActivityLoadingBinding;
import com.example.bulgo.android.model.HomeMenuCategory;
import com.example.bulgo.android.model.HomeMenuCategoryList;

import java.util.List;

public class LoadingActivity extends AppCompatActivity {
    private ActivityLoadingBinding mBinding;
    private Context mContext;

    private void initHomeMenu() {
        String[] homeMenuTitles = getResources().getStringArray(R.array.home_menu_titles);
        List<HomeMenuCategory> items = HomeMenuCategoryList.get().getHomeMenuCategories();
        items.add(new HomeMenuCategory(mContext.getDrawable(R.drawable.home_menu_selfie), homeMenuTitles[0]));
        items.add(new HomeMenuCategory(mContext.getDrawable(R.drawable.home_menu_favorite_tourist), homeMenuTitles[1]));
        items.add(new HomeMenuCategory(mContext.getDrawable(R.drawable.home_menu_taking_a_picture), homeMenuTitles[2]));
        items.add(new HomeMenuCategory(mContext.getDrawable(R.drawable.home_menu_tourist_information), homeMenuTitles[3]));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_loading);
        mContext = this;

        mBinding.progressLoading.show();

        initHomeMenu();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
