package com.wilson.multiprocesssp;

import android.app.Application;
import android.content.Context;

/**
 * Created by zhangweixiong
 * on 2018/4/16.
 */

public class BaseApplication extends Application{

    private static Context mContext;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        mContext = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static Context getContext() {
        return mContext;
    }
}
