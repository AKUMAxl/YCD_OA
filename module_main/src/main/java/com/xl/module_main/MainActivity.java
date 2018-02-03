package com.xl.module_main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xl.module_library.Base.BaseActivity;
import com.xl.module_library.Base.BaseFragment;
import com.xl.module_library.Manager.ViewManager;
import com.xl.module_library.Widget.NoScrollViewPager;

import java.util.List;

@Route(path = "/module_main/main_activity")
public class MainActivity extends BaseActivity implements View.OnClickListener{

    private long mExitTime = 0;
    private BottomNavigationView bottomNavigationView;
    private NoScrollViewPager mPager;
    private List<BaseFragment> mFragments;
    private FragmentAdapter mAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int i = item.getItemId();
            if (i == R.id.navigation_home_tab1) {
                mPager.setCurrentItem(0);
                return true;
            } else if (i == R.id.navigation_home_tab2) {
                mPager.setCurrentItem(1);
                return true;
            } else if (i == R.id.navigation_home_tab3) {
                mPager.setCurrentItem(2);
                return true;
            }
            return false;
        }

    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void loadView() {
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.main_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void initData() {

        mFragments = ViewManager.getInstance().getAllFragment();

        mPager = (NoScrollViewPager) findViewById(R.id.no_scroll_viewpager);
        mAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        mPager.setPagerEnabled(false);
        mPager.setAdapter(mAdapter);
    }

    @Override
    public void firstRequestNet() {

    }

    @Override
    public void fresh() {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //两秒之内按返回键就会退出
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                //ToastUtils.showShortToast(getString(R.string.app_exit_hint));
                Toast.makeText(oThis,"再次点击退出程序",Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                ViewManager.getInstance().exitApp(oThis);
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
