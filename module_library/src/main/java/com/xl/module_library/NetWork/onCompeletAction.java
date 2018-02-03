package com.xl.module_library.NetWork;

import android.app.Application;
import android.content.Context;

import com.xl.module_library.Widget.MyProgressDialog;

import io.reactivex.functions.Action;

/**
 * Created by ADMIN on 2018/1/23.
 */

public class onCompeletAction implements Action {

    private SimpleCallback simpleCallback;
    private Application application;

    public onCompeletAction(SimpleCallback simpleCallback,Application application){
        this.simpleCallback = simpleCallback;
        this.application = application;
    }

    @Override
    public void run() throws Exception {
        if (simpleCallback!=null)
            simpleCallback.onComplete();
    }
}
