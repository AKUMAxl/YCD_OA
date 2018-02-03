package com.xl.module_library.NetWork;

import android.app.Application;
import android.content.Context;

import com.xl.module_library.R;
import com.xl.module_library.Widget.MyProgressDialog;

import io.reactivex.functions.Consumer;

/**
 * Created by ADMIN on 2018/1/23.
 */

public class onStartSubscriber implements Consumer {

    private SimpleCallback simpleCallback;
    private Application application;

    public onStartSubscriber(SimpleCallback simpleCallback,Application application){
        this.simpleCallback = simpleCallback;
        this.application = application;
    }

    @Override
    public void accept(Object o) throws Exception {
        if (simpleCallback!=null)
            simpleCallback.onStart();
    }
}
