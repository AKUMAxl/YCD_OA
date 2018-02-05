package com.yangchedou.oa;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.xl.module_library.Base.BaseApplication;
import com.xl.module_library.Base.MyLocationListener;

/**
 * Created by ADMIN on 2018/1/8.
 */

public class MainApplication extends BaseApplication {

    /*public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();*/


    @Override
    public void onCreate() {
        super.onCreate();
        /*mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        //注册监听函数
        setLocationOption();
        mLocationClient.start();*/

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // dex突破65535的限制
        MultiDex.install(this);
    }



}
