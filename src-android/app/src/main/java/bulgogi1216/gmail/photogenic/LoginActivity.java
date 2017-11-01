package bulgogi1216.gmail.photogenic;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

import bulgogi1216.gmail.photogenic.databinding.ActivityMainBinding;
import bulgogi1216.gmail.photogenic.fragment.LoginFragment;

public class LoginActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private ActionBar mActionBar;

    private SessionCallback callback;

    private void initToolbar() {
        setSupportActionBar(mBinding.toolbarShell.toolbar);
        mActionBar = getSupportActionBar();
        assert mActionBar != null;
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setTitle(getResources().getString(R.string.app_name));
    }

    private class SessionCallback implements ISessionCallback {

        @Override
        public void onSessionOpened() {
            Log.e("세선연결","세션연결성공");
            redirectSignupActivity(); //세션연결 성공 가입창
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if(exception != null) {
                Log.e("세선연결","세션연결실패");
                Logger.e(exception);
            }
            Log.e("세선연결","세션연결실패");

            //setContentView(R.layout.activity_login);//  // 세션연결실패시 다시 로그인화면으로
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fm = getSupportFragmentManager();
        LoginFragment loginFragment = new LoginFragment();
        FragmentTransaction trans = fm.beginTransaction();
        Log.e("asdsdasas","asdsadass");
        trans.add(R.id.linear, loginFragment);
        trans.commit();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Session.getCurrentSession().removeCallback(callback);
    }

    private void initKakao() {
        Session.getCurrentSession().addCallback(callback);
        Session.getCurrentSession().checkAndImplicitOpen();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    protected void redirectSignupActivity() { //세션 연결 성공시 가입 창 가입창은 카톡과 카스만
        //로그인하고 넘길 창!!!!!!!!!!!!!!!!!!!!!!!
    //    Log.i(TAG, "Kakao Login has been completed");
//        final Intent intent = new Intent(this, KakaoSignupActivity.class);
//        startActivity(intent);
//        finish();
    }
}
