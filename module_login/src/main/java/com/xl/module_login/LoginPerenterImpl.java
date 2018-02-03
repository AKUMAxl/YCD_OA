package com.xl.module_login;

import android.app.Application;

/**
 * Created by ADMIN on 2018/1/23.
 */

public class LoginPerenterImpl implements LoginPersenter {

    private LoginModel loginModel;
    private LoginView loginView;

    public LoginPerenterImpl(Application application, LoginView loginView){
        this.loginModel = new LoginModelImpl(application);
        this.loginView = loginView;
    }


    @Override
    public void getUserInfo(String username, String password) {
        loginModel.getUserInfo(username, password, new LoginModel.LoginResponse() {
            @Override
            public void LoginSuccess() {
                if (loginView!=null){
                    loginView.dismissLoading();
                }
            }

            @Override
            public void LoginFail(String errorString) {
                if (loginView!=null){
                    loginView.dismissLoading();
                }
            }
        });
    }

    @Override
    public void getDelete() {
        if (loginView!=null){
            loginView = null;
        }
    }
}
