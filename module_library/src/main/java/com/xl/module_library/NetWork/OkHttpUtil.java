package com.xl.module_library.NetWork;

import android.content.Context;
import android.os.Environment;


import com.orhanobut.logger.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by AKUMA on 2017/8/28.
 */

public class OkHttpUtil {

    private static final int cacheSize = 10 * 1024 * 1024; // 10 MiB
    public static String BasePath = Environment.getExternalStorageDirectory()+"/seiyaA";
    private static String cacheDirectory = BasePath + "/okttpcaches"; // 设置缓存文件路径
    private static Cache cache = new Cache(new File(cacheDirectory), cacheSize);  //
    //File sdcache = getExternalCacheDir();

    //应用拦截器
    static Interceptor appInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl url = request.url();
            //---------请求之前-----
            Logger.d("app interceptor:begin");
            Logger.i("request url:"+url.toString());
            Response  response = chain.proceed(request);
            boolean successful = response.isSuccessful();
            Logger.d("app interceptor:end："+successful);
            //---------请求之后------------
            return response;
        }
    };

    static Interceptor networkInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            //---------请求之前-----
            Logger.d("network interceptor:begin");
            Response  response = chain.proceed(request);
            Logger.i("response state:"+response.isSuccessful());
            Logger.d("network interceptor:end");
            return response;
        }
    };


    private static OkHttpClient okHttpClient;

    private static volatile OkHttpUtil intance;

    public static OkHttpUtil getIntance(){

        synchronized (OkHttpUtil.class){
            if (intance==null){
                synchronized (OkHttpClient.class){
                    intance = new OkHttpUtil();
                }
            }
        }
        return intance;
    }


    public OkHttpClient getOKHttpClient(){

        final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();
            if (okHttpClient==null){
                okHttpClient = new OkHttpClient.Builder()
                        //设置缓存
                        .cookieJar(new CookieJar() {
                            @Override
                            public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                                cookieStore.put(httpUrl.host(), list);
                            }

                            @Override
                            public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                                List<Cookie> cookies = cookieStore.get(httpUrl.host());
                                return cookies != null ? cookies : new ArrayList<Cookie>();
                            }
                        })
                        //设置应用拦截器
                        //.addInterceptor(appInterceptor)
                        //设置网络拦截器
                        //.addNetworkInterceptor(networkInterceptor)
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .readTimeout(10,TimeUnit.SECONDS)
                        .writeTimeout(10,TimeUnit.SECONDS)
                        .cache(cache)
                        .build();
            }
            return okHttpClient;
    }



}

