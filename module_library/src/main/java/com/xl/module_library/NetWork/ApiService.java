package com.xl.module_library.NetWork;

import com.xl.module_library.Bean.User;

import java.io.InputStream;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Streaming;


/**
 * Created by wanglj on 16/7/4.
 */

public interface ApiService {

    @Headers(
            {"imei:sdfkj","name:xl"})
    @GET("user/getUserInfo")
    Observable<BaseResponse<List<User>>> getUser(@Query("userId") int id);

    @Streaming
    @Headers({"Content-Length:70","Content-Type:application/json"})
    @POST("http://47.93.54.254:8080/rootService/rest/signin")
    Observable<BaseResponse> InputStreamTest(@Body RequestBody body);
}
