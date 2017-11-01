package bulgogi1216.gmail.photogenic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by bulgo on 2017-11-01.
 */

public class MostFavoriteSelfieCardList {
    private static MostFavoriteSelfieCardList sMostFavoriteSelfieCardList;

    private List<MostFavoriteSelfieCard> mMostFavoriteSelfieCards;

    private MostFavoriteSelfieCardList() {
        mMostFavoriteSelfieCards = new ArrayList<>();
    }

    public static MostFavoriteSelfieCardList get() {
        if(sMostFavoriteSelfieCardList == null) {
            sMostFavoriteSelfieCardList = new MostFavoriteSelfieCardList();
        }
        return sMostFavoriteSelfieCardList;
    }

    public List<MostFavoriteSelfieCard> getMostFavoriteSelfieCards() {
        return mMostFavoriteSelfieCards;
    }

    public MostFavoriteSelfieCard getMostFavoriteSelfieCard(UUID _uuid) {
        for (MostFavoriteSelfieCard mostFavoriteSelfieCard : mMostFavoriteSelfieCards) {
            if(mostFavoriteSelfieCard.getUUID().equals(_uuid)) {
                return mostFavoriteSelfieCard;
            }
        }
        return null;
    }
}
