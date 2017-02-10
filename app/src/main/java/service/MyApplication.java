package service;

import android.app.Application;
import android.content.Context;

import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;
import okhttp3.Headers;

/**
 * Created by Jarvis on 2017/2/6.
 */

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;

        initHttpUtil();
    }

    public void initHttpUtil(){
        OkHttpFinalConfiguration.Builder builder =
                new OkHttpFinalConfiguration.Builder();

        //common http header
        Headers commonHeaders = new Headers.Builder().build();
        builder.setCommenHeaders(commonHeaders);

        OkHttpFinal.getInstance().init(builder.build());
    }

    public static Context getContext(){
        return context;
    }
}
