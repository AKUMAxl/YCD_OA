package com.xl.module_login;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.xl.module_library.Bean.User;
import com.xl.module_library.NetWork.ApiManager;
import com.xl.module_library.NetWork.SimpleCallback;
import com.xl.module_library.Util.ChangeActivityUtil;

import java.util.List;

/**
 * Created by ADMIN on 2018/1/23.
 */

public class LoginModelImpl implements LoginModel {

    private Application application;

    public LoginModelImpl(Application application){
        this.application = application;
    }

    @Override
    public void getUserInfo(String username, String password, final LoginResponse loginResponse) {
        ApiManager manager = new ApiManager(application);
        manager.getUser(1, new SimpleCallback<List<User>>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onNext(List<User> list_user) {
                Log.i("xl", "---" + list_user.get(0).toString());
                loginResponse.LoginSuccess();
            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(String errorStr) {
                loginResponse.LoginFail(errorStr);
            }
        });
    }

}
