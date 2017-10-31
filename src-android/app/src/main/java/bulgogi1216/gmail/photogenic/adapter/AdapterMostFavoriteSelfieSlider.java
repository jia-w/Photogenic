package bulgogi1216.gmail.photogenic.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.List;

import bulgogi1216.gmail.photogenic.databinding.ItemSliderMostFavoriteSelfieBinding;
import bulgogi1216.gmail.photogenic.model.MostFavoriteSelfie;
import bulgogi1216.gmail.photogenic.model.MostFavoriteSelfieList;
import bulgogi1216.gmail.photogenic.util.Tools;

/**
 * Created by bulgo on 2017-10-31.
 */

public class AdapterMostFavoriteSelfieSlider extends PagerAdapter {
    private Activity mActivity;
    private List<MostFavoriteSelfie> mItems;
    private AdapterMostFavoriteSelfieSlider.OnItemClickListener mOnItemClickListener;

    private interface OnItemClickListener {
        void onItemClick(View view, MostFavoriteSelfie obj);
    }

    public void setOnItemClickListener(AdapterMostFavoriteSelfieSlider.OnItemClickListener _onItemClickListener) {
        this.mOnItemClickListener = _onItemClickListener;
    }

    // constructor
    public AdapterMostFavoriteSelfieSlider(Activity _activity) {
        mActivity = _activity;
        mItems = MostFavoriteSelfieList.get().getMostFavoriteSelfieLists();
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    public MostFavoriteSelfie getItem(int _position) {
        return mItems.get(_position);
    }

    public void setItems(List<MostFavoriteSelfie> _Items) {
        mItems = _Items;
        notifyDataSetChanged();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final MostFavoriteSelfie o = mItems.get(position);
        LayoutInflater layoutInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ItemSliderMostFavoriteSelfieBinding binding = ItemSliderMostFavoriteSelfieBinding.inflate(layoutInflater, container, true);
//
//        View v = inflater.inflate(R.layout.item_slider_image, container, false);
//
//        ImageView image = (ImageView) v.findViewById(R.id.image);
//        MaterialRippleLayout lyt_parent = (MaterialRippleLayout) v.findViewById(R.id.lyt_parent);
        Tools.displayImageOriginal(mActivity, binding.image, o.getImage());
        binding.lytParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(v, o);
                }
            }
        });

        ((ViewPager) container).addView(binding.getRoot());

        return binding.getRoot();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}
