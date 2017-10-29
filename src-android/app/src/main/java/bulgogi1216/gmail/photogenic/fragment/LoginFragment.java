package bulgogi1216.gmail.photogenic.fragment;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bulgogi1216.gmail.photogenic.R;
import bulgogi1216.gmail.photogenic.databinding.FragmentLoginBinding;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

/**
 * Created by bulgo on 2017-10-29.
 */

public class LoginFragment extends Fragment {
    public final static String TAG = "LoginFragment";

    private FragmentLoginBinding mBinding;
    private Context mContext;

    private SessionCallback callback;

    private class SessionCallback implements ISessionCallback {

        @Override
        public void onSessionOpened() {
            redirectSignupActivity(); //세션연결 성공 가입창
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if(exception != null) {
                Logger.e(exception);
            }
            //setContentView(R.layout.activity_login);//  // 세션연결실패시 다시 로그인화면으로
        }
    }

    private void initKakao() {
        callback = new SessionCallback();
        Session.getCurrentSession().addCallback(callback);
        Session.getCurrentSession().checkAndImplicitOpen();
    }

    public LoginFragment() {
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    protected void redirectSignupActivity() { //세션 연결 성공시 가입 창 가입창은 카톡과 카스만
        Log.i(TAG, "Kakao Login has been completed");
//        final Intent intent = new Intent(this, KakaoSignupActivity.class);
//        startActivity(intent);
//        finish();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        mContext = mBinding.getRoot().getContext();

        initKakao();

        return mBinding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Session.getCurrentSession().removeCallback(callback);
    }
}
