package bulgogi1216.gmail.photogenic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import bulgogi1216.gmail.photogenic.BR;
import bulgogi1216.gmail.photogenic.databinding.ItemHomeMenuCategoryBinding;
import bulgogi1216.gmail.photogenic.model.HomeMenuCategory;
import bulgogi1216.gmail.photogenic.model.HomeMenuCategoryList;

/**
 * Created by bulgo on 2017-10-27.
 */

public class AdapterListHomeMenu extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<HomeMenuCategory> items;

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        private final ItemHomeMenuCategoryBinding mBinding;

        private OriginalViewHolder(ItemHomeMenuCategoryBinding _binding) {
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
