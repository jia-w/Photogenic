package com.example.bulgo.android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.bulgo.android.databinding.ItemHomeMenuCategoryBinding;
import com.example.bulgo.android.model.HomeMenuCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bulgo on 2017-10-27.
 */

public class AdapterListHomeMenu extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<HomeMenuCategory> items = new ArrayList<>();

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        private final ItemHomeMenuCategoryBinding mBinding;

        public OriginalViewHolder(ItemHomeMenuCategoryBinding _binding) {
            super(_binding.getRoot());
            mBinding = _binding;
        }

        public void bind(Object _obj) {
            mBinding.setVariable(BR.obj, _obj);

            mBinding.title.setText(_category.mTitle);
            mBinding.brief.setText(_category.mBrief);
            mBinding.imageBg.setImageDrawable(_category.mImageDrw);
            mBinding.executePendingBindings();
        }
    }

    public AdapterListHomeMenu(Context _context, List<HomeMenuCategory> _items) {
        mContext = _context;
        items = _items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemHomeMenuCategoryBinding binding = ItemHomeMenuCategoryBinding.inflate(layoutInflater, parent, false);

        return new OriginalViewHolder(binding);
    }

    public void onBindViewHolder(OriginalViewHolder holder, int position) {
        Object obj = getO
        holder.bind(category);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
