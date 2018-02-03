package com.xl.module_firstpage;



import com.xl.module_library.Base.ApplicationDelegate;
import com.xl.module_library.Manager.ViewManager;

public class MyDelegate implements ApplicationDelegate {

    @Override
    public void onCreate() {
        ViewManager.getInstance().addFragment(0, new HomeFragment());
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }
}
