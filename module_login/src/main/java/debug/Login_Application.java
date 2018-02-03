package debug;

import android.app.Application;
import android.content.Context;

/**
 * Created by ADMIN on 2018/1/8.
 */

public class Login_Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // dex突破65535的限制
        //MultiDex.install(this);
    }

}
