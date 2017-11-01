package bulgogi1216.gmail.photogenic.model;

import android.graphics.drawable.Drawable;

import java.util.UUID;

public class MostFavoriteSelfieCard {
	private UUID mUUID;
	private Drawable mProfileImgDrw;
	private String mProfileImgUrl;
	private String mName;
	private String[] addr;
	private Drawable mSelfieImgDrw;
	private String mSelfieImgUrl;
	private String mText;
	private boolean section = false;

	public MostFavoriteSelfieCard() {
	}

	public UUID getUUID() {
		return mUUID;
	}

	public Drawable getProfileImgDrw() {
		return mProfileImgDrw;
	}

	public void setProfileImgDrw(Drawable _profileImgDrw) {
		mProfileImgDrw = _profileImgDrw;
	}

	public String getProfileImgUrl() {
		return mProfileImgUrl;
	}

	public void setProfileImgUrl(String _profileImgUrl) {
		mProfileImgUrl = _profileImgUrl;
	}

	public String getName() {
		return mName;
	}

	public void setName(String _name) {
		mName = _name;
	}

	public String[] getAddr() {
		return addr;
	}

	public void setAddr(String[] _addr) {
		addr = _addr;
	}

	public Drawable getSelfieImgDrw() {
		return mSelfieImgDrw;
	}

	public void setSelfieImgDrw(Drawable _selfieImgDrw) {
		mSelfieImgDrw = _selfieImgDrw;
	}

	public String getSelfieImgUrl() {
		return mSelfieImgUrl;
	}

	public void setSelfieImgUrl(String _selfieImgUrl) {
		mSelfieImgUrl = _selfieImgUrl;
	}

	public String getText() {
		return mText;
	}

	public void setText(String _text) {
		mText = _text;
	}

	public boolean isSection() {
		return section;
	}
}
