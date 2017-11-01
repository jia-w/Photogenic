package bulgogi1216.gmail.photogenic.fragment_in_selfie;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bulgogi1216.gmail.photogenic.R;
import bulgogi1216.gmail.photogenic.databinding.FragmentSelfieOfFriendBinding;

/**
 * Created by bulgo on 2017-11-01.
 */

public class SelfieOfFriendFragment extends Fragment {
    private FragmentSelfieOfFriendBinding mBinding;

    private void initComponent() {

    }

    public static SelfieOfFriendFragment newInstance() {
        return new SelfieOfFriendFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_selfie_of_friend, container, false);

        initComponent();

        return mBinding.getRoot();
    }
}
