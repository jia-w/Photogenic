package com.example.bulgo.android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.bulgo.android.BR;
import com.example.bulgo.android.databinding.ItemHomeMenuCategoryBinding;
import com.example.bulgo.android.model.HomeMenuCategory;
import com.example.bulgo.android.model.HomeMenuCategoryList;

import java.util.List;

/**
 * Created by bulgo on 2017-10-27.
 */

public class AdapterListHomeMenu extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<HomeMenuCategory> items;

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        private final ItemHomeMenuCategoryBinding mBinding;

        public OriginalViewHolder(ItemHomeMenuCategoryBinding _binding) {
            super(_binding.getRoot());
            mBinding = _binding;
        }

        public void bind(HomeMenuCategory _item) {
            mBinding.setVariable(BR.home_menu_category, _item);
//            mBinding.title.setText(_item.getTitle());
//            mBinding.imageBg.setImageResource(_item.getImageBg());
            mBinding.executePendingBindings();
        }
    }

    public AdapterListHomeMenu(Context _context) {
        mContext = _context;
        items = HomeMenuCategoryList.get().getHomeMenuCategories();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemHomeMenuCategoryBinding binding = ItemHomeMenuCategoryBinding.inflate(layoutInflater, parent, true);

        return new OriginalViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;
            HomeMenuCategory item = items.get(position);
            view.bind(item);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
