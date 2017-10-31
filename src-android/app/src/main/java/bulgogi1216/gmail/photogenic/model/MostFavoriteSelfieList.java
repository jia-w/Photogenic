package bulgogi1216.gmail.photogenic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by bulgo on 2017-10-31.
 */

public class MostFavoriteSelfieList {
    private static MostFavoriteSelfieList sMostFavoriteSelfieList;

    private List<MostFavoriteSelfie> mMostFavoriteSelfieLists;

    private MostFavoriteSelfieList() {
        mMostFavoriteSelfieLists = new ArrayList<>();
    }

    public static MostFavoriteSelfieList get() {
        if(sMostFavoriteSelfieList == null) {
            sMostFavoriteSelfieList = new MostFavoriteSelfieList();
        }
        return sMostFavoriteSelfieList;
    }

    public List<MostFavoriteSelfie> getMostFavoriteSelfieLists() {
        return mMostFavoriteSelfieLists;
    }

    public MostFavoriteSelfie getMostFavoriteSelfie(UUID _uuid) {
        for (MostFavoriteSelfie mostFavoriteSelfie : mMostFavoriteSelfieLists) {
            if(mostFavoriteSelfie.getUUID().equals(_uuid)) {
                return mostFavoriteSelfie;
            }
        }
        return null;
    }
}
