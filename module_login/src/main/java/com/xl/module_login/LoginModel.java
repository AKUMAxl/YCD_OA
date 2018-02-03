package com.xl.module_login;

import com.xl.module_library.Bean.User;

/**
 * Created by ADMIN on 2018/1/23.
 */

public interface LoginModel {

    interface LoginResponse{

        void LoginSuccess();

        void LoginFail(String errorString);

    }

    void getUserInfo(String username,String password,LoginResponse loginResponse);
}
