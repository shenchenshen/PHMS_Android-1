package com.cse6324.service;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;
import okhttp3.Headers;

/**
 * Created by Jarvis on 2017/2/6.
 */

public class MyApplication extends Application {

    public static final String APPLICATION_NAME = "PHMS";

    private static Context context;
    public static SharedPreferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;

        preferences = getSharedPreferences(
                APPLICATION_NAME, Context.MODE_PRIVATE);
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

    public static SharedPreferences getPreferences(){
        return preferences;
    }

    public static String getPreferences(String key){
        return preferences.getString(key,"");
    }

    public static void setStringPref(String key, String value){
        SharedPreferences.Editor ed = preferences.edit();
        ed.putString(key, value);
        ed.commit();
    }

    public static Context getContext(){
        return context;
    }


}
