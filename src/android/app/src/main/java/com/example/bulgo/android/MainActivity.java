package com.example.bulgo.android;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.bulgo.android.databinding.ActivityMainBinding;
import com.example.bulgo.android.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private ActionBar mActionBar;
    private Handler mHandler;

    private void initToolbar() {
        setSupportActionBar(mBinding.toolbarShell.toolbar);
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setTitle(getResources().getString(R.string.app_name));
    }

    private void initNavigationMenu() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mBinding.drawerLayout,
                mBinding.toolbarShell.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        mBinding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mBinding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {
                mActionBar.setTitle(item.getTitle());
                Fragment fragment = getFragmentByDrawerTag(item);
                commitFragment(fragment);
                mBinding.drawerLayout.closeDrawers();
                return true;
            }
        });

        // open drawer at start
        mBinding.drawerLayout.openDrawer(GravityCompat.START);
    }

    private Fragment getFragmentByDrawerTag(MenuItem _item) {
        Fragment fragment;
        String[] drawerTitles = getResources().getStringArray(R.array.drawer_main_titles);

        if(_item.getTitle().equals(drawerTitles[0])) {
            fragment = HomeFragment.newInstance();
        } else {
            fragment = null;
        }

        return fragment;
    }

    public void commitFragment(Fragment fragment) {
        // Using Handler class to avoid lagging while committing fragment in same time as closing navigation drawer
        mHandler.post(new CommitFragmentRunnable(fragment));
    }

    private class CommitFragmentRunnable implements Runnable {

        private Fragment fragment;

        public CommitFragmentRunnable(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void run() {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(mBinding.contentMain.getId(), fragment).commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initToolbar();
        initNavigationMenu();

        mHandler = new Handler();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
