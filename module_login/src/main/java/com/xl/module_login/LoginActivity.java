package com.xl.module_login;

import android.content.Context;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.xl.module_library.Base.BaseActivity;

import com.xl.module_library.Util.ChangeActivityUtil;
import com.xl.module_library.Widget.MyProgressDialog;

import java.util.List;

@Route(path = "/module_login/login_activity")
public class LoginActivity extends BaseActivity implements LoginView{

    TextView textView,is_tv;
    private LoginPersenter loginPersenter;

    private AdView mAdView;
    private MyProgressDialog myProgressDialog;

    @Override
    public void loadView() {
        setContentView(R.layout.activity_login);
    }

    @Override
    public void initData() {

        loginPersenter = new LoginPerenterImpl(getApplication(),this);

        myProgressDialog = new MyProgressDialog(getApplicationContext(),true,getResources().getString(R.string.jiazaihong));

        textView = findViewById(R.id.login_tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("xl","点击登录");
                loginPersenter.getUserInfo("","");

            }
        });

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.ad_view);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        // Start loading the ad in the background.
        mAdView.loadAd(adRequest);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {
        ChangeActivityUtil.getIntance().ToNextActivity(oThis,"/module_main/main_activity",null,true);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPersenter.getDelete();
    }
}
