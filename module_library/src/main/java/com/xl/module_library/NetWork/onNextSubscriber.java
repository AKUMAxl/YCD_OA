package com.xl.module_library.NetWork;

import android.app.Application;
import android.content.Context;

import com.xl.module_library.Widget.MyProgressDialog;

import io.reactivex.functions.Consumer;


/**
 * 错误统一处理
 *
 * Created by wanglj on 16/7/4.
 */

public class onNextSubscriber<T> implements Consumer<T> {

    private SimpleCallback<T> simpleCallback;
    private Application application;

    public onNextSubscriber(SimpleCallback simpleCallback, Application application){
        this.simpleCallback = simpleCallback;
        this.application = application;
    }

    @Override
    public void accept(T t) throws Exception {
        simpleCallback.onNext(t);
    }

    /*@Override
    public void onSubscribe(Subscription s) {
        if(simpleCallback != null)
            simpleCallback.onStart();
    }

    @Override
    public void onNext(T t) {
        if(simpleCallback != null)
            simpleCallback.onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof SocketTimeoutException) {
            Toast.makeText(application, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(application, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(application, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if(simpleCallback != null)
            simpleCallback.onComplete();
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onStart() {
        super.onStart();
        if(simpleCallback != null)
            simpleCallback.onStart();
    }

    @Override
    public void onCompleted() {
        if(simpleCallback != null)
            simpleCallback.onComplete();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof SocketTimeoutException) {
           Toast.makeText(application, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
           Toast.makeText(application, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else {
           Toast.makeText(application, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if(simpleCallback != null)
            simpleCallback.onComplete();
    }

    @Override
    public void onNext(T t) {
        if(simpleCallback != null)
            simpleCallback.onNext(t);
    }*/
}
