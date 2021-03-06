package bulgogi1216.gmail.photogenic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by bulgo on 2017-10-28.
 */

public class HomeMenuCategoryList {
    private static HomeMenuCategoryList sHomeMenuCategoryList;

    private List<HomeMenuCategory> mHomeMenuCategories;

    private HomeMenuCategoryList() {
        mHomeMenuCategories = new ArrayList<>();
    }

    public static HomeMenuCategoryList get() {
        if(sHomeMenuCategoryList == null) {
            sHomeMenuCategoryList = new HomeMenuCategoryList();
        }
        return sHomeMenuCategoryList;
    }

    public List<HomeMenuCategory> getHomeMenuCategories() {
        return mHomeMenuCategories;
    }

    public HomeMenuCategory getHomeMenuCategory(UUID _uuid) {
        for (HomeMenuCategory homeMenuCategory : mHomeMenuCategories) {
            if(homeMenuCategory.getUUID().equals(_uuid)) {
                return homeMenuCategory;
            }
        }
        return null;
    }
}
