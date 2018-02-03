package com.xl.module_library.NetWork;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.xl.module_library.Bean.User;
import com.xl.module_library.R;
import com.xl.module_library.Widget.MyProgressDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

public class ApiManager {

    private ApiService apiService;
    private Application application;
    MyProgressDialog myProgressDialog;


    public ApiManager(Application application) {
        this.apiService = RetrofitClient.getIntance().getServiec();
        this.application = application;
        myProgressDialog = new MyProgressDialog(application,true,application.getResources().getString(R.string.jiazaihong));
    }

    public void getUser(int userId, final SimpleCallback<List<User>> simpleCallback){

        apiService.getUser(1)
                .concatMap(new BaseResponseFunc<List<User>>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //.subscribe(new onNextSubscriber<User>(simpleCallback,application));
                .subscribe(new onNextSubscriber<List<User>>(simpleCallback,application),
                        new onErrorSubscriber(simpleCallback,application),
                        new onCompeletAction(simpleCallback,application),
                        new onStartSubscriber(simpleCallback,application)
                );
    }

    public void InputStreamTest(SimpleCallback simpleCallback){
        JSONObject object = new JSONObject();

        try {
            object.put("terminal","1");
            object.put("version","1.0.1");
            object.put("imei","MI 2,5.0.2,Xiaomi,98544789");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Gson g = new Gson();
        test t = new test("123","123","234");
        String postInfoStr = g.toJson(t);

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),postInfoStr);

        apiService.InputStreamTest(body)
                .concatMap(new BaseResponseFunc())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new onNextSubscriber(simpleCallback,application));
    }

    class test{
        String terminal;
        String version;
        String imei;

        public test(String terminal, String version, String imei) {
            this.terminal = terminal;
            this.version = version;
            this.imei = imei;
        }

        public test() {
        }


        public String getTerminal() {
            return terminal;
        }

        public void setTerminal(String terminal) {
            this.terminal = terminal;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        @Override
        public String toString() {
            return "test{" +
                    "terminal='" + terminal + '\'' +
                    ", version='" + version + '\'' +
                    ", imei='" + imei + '\'' +
                    '}';
        }
    }

}
