package bulgogi1216.gmail.photogenic;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import bulgogi1216.gmail.photogenic.databinding.ActivityLoadingBinding;
import bulgogi1216.gmail.photogenic.model.HomeMenuCategory;
import bulgogi1216.gmail.photogenic.model.HomeMenuCategoryList;
import bulgogi1216.gmail.photogenic.utils.KakaoKeyGenerator;

public class LoadingActivity extends AppCompatActivity {
    public static final String TAG = "LoadingActivity";

    private ActivityLoadingBinding mBinding;
    private Context mContext;

    private void initHomeMenu() {
        String[] homeMenuTitles = getResources().getStringArray(R.array.home_menu_titles);
        List<HomeMenuCategory> items = HomeMenuCategoryList.get().getHomeMenuCategories();
        items.add(new HomeMenuCategory(mContext.getDrawable(R.drawable.home_menu_selfie), homeMenuTitles[0]));
        items.add(new HomeMenuCategory(mContext.getDrawable(R.drawable.home_menu_favorite_tourist), homeMenuTitles[1]));
        items.add(new HomeMenuCategory(mContext.getDrawable(R.drawable.home_menu_taking_a_picture), homeMenuTitles[2]));
        items.add(new HomeMenuCategory(mContext.getDrawable(R.drawable.home_menu_tourist_information), homeMenuTitles[3]));
        Log.v(TAG, "Home Menu Category has been initialized");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_loading);
        mContext = this;

        mBinding.progressLoading.show();

        KakaoKeyGenerator.getKeyHash(mContext);
        initHomeMenu();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}