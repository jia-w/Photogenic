package bulgogi1216.gmail.photogenic;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bulgogi1216.gmail.photogenic.databinding.ActivitySelfieBinding;
import bulgogi1216.gmail.photogenic.fragment_in_selfie.BestSelfieFragment;
import bulgogi1216.gmail.photogenic.fragment_in_selfie.SelfieOfFriendFragment;
import bulgogi1216.gmail.photogenic.fragment_in_selfie.TimelineFragment;
import bulgogi1216.gmail.photogenic.model.SelfieCard;
import bulgogi1216.gmail.photogenic.model.SelfieCardList;
import bulgogi1216.gmail.photogenic.util.Tools;

public class SelfieActivity extends AppCompatActivity {
    private ActivitySelfieBinding mBinding;
    private SectionsPagerAdapter mPagerAdapter;

    private void initToolbar() {
        mBinding.toolbar.setNavigationIcon(R.drawable.ic_undo);
        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setTitle(getString(R.string.menu_selfie_in_main));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
    }

    private void initComponent() {
        setupViewPager();

        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager);

        mBinding.tabLayout.getTabAt(0).setIcon(R.drawable.ic_favorites);
        mBinding.tabLayout.getTabAt(1).setIcon(R.drawable.ic_person);
        mBinding.tabLayout.getTabAt(2).setIcon(R.drawable.ic_map);
        mBinding.tabLayout.getTabAt(3).setIcon(R.drawable.ic_chat);

        // set icon color pre-selected
        mBinding.tabLayout.getTabAt(0).getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        mBinding.tabLayout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);
        mBinding.tabLayout.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);
        mBinding.tabLayout.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);

        mBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE,  PorterDuff.Mode.SRC_IN);
                mBinding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void setupViewPager() {
        String[] tabTitles = getResources().getStringArray(R.array.tab_titles_in_selfie);

        mPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addFragment(BestSelfieFragment.newInstance(), tabTitles[0]);    // index 0
        mPagerAdapter.addFragment(SelfieOfFriendFragment.newInstance(), tabTitles[1]);   // index 1
        mPagerAdapter.addFragment(SelfieOfFriendFragment.newInstance(), "Books");    // index 2
        mPagerAdapter.addFragment(TimelineFragment.newInstance(), "Games");    // index 3
        mBinding.viewPager.setAdapter(mPagerAdapter);
    }

    private void initDummy() {
        List<SelfieCard> items = SelfieCardList.get().getSelfieOfFriendCards();
        SelfieCard item = new SelfieCard();
        item.setProfileImgUrl("http://pengaja.com/uiapptemplate/newphotos/profileimages/2.jpg");
        item.setSelfieImgUrl("http://cfile23.uf.tistory.com/image/25356834520B205206AABB");
        item.setName("김사또");

        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_selfie);

        initToolbar();
        initComponent();
        initDummy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_selfie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        public String getTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
