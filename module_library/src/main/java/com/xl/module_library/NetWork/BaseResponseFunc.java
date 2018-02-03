package com.xl.module_library.NetWork;


import io.reactivex.Observable;
import io.reactivex.functions.Function;


/**
 * Created by wanglj on 16/7/4.
 */

public class BaseResponseFunc<T> implements Function<BaseResponse<T>, Observable<T>> {

    @Override
    public Observable<T> apply(BaseResponse<T> tBaseResponse) throws Exception {
        //遇到非200错误统一处理,将BaseResponse转换成想要的对象
        if (tBaseResponse.getCode() != 200) {
            return Observable.error(new Throwable("codeError:"+tBaseResponse.getMessage()));
        }else{
            return Observable.just(tBaseResponse.getParams());
        }
    }


}
