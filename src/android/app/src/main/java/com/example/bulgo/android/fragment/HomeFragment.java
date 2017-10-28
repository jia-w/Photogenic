package com.example.bulgo.android.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bulgo.android.R;
import com.example.bulgo.android.adapter.AdapterListHomeMenu;
import com.example.bulgo.android.databinding.FragmentHomeBinding;
import com.example.bulgo.android.model.HomeMenuCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bulgo on 2017-10-27.
 */

public class HomeFragment extends Fragment {
    private FragmentHomeBinding mBinding;
    private View mRootView;
    private Context mContext;
    private AdapterListHomeMenu mAdapter;

    private void initComponent() {
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mBinding.recyclerView.setHasFixedSize(true);
        mBinding.recyclerView.setNestedScrollingEnabled(false);

        List<HomeMenuCategory> items = new ArrayList<>();
        HomeMenuCategory dummy = new HomeMenuCategory();
        dummy.mTitle = "test";
        dummy.mBrief = "test brief";
        dummy.mImageBg = R.drawable.default_image;
        
        items.add(dummy);

        //set data and list adapter
        mAdapter = new AdapterListHomeMenu(mContext, items);
        mBinding.recyclerView.setAdapter(mAdapter);
//
//        // on item list clicked
//        mAdapter.setOnItemClickListener(new AdapterListShopCategoryImg.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, ShopCategory obj, int position) {
//                Snackbar.make(parent_view, "Item " + obj.title + " clicked", Snackbar.LENGTH_SHORT).show();
//            }
//        });
    }

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        mRootView = mBinding.getRoot();
        mContext = mBinding.getRoot().getContext();

        initComponent();

        return mRootView;
    }
}
