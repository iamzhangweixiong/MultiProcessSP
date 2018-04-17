package com.wilson.multiprocesssp.synconfig;

import android.content.Context;

import com.wilson.multiprocesssp.synconfig.base.SharedPreferenceWrapper;


/**
 * Created by zhanwx
 * on 16/3/10.
 */
public class RealMultiProcessSP extends SharedPreferenceWrapper {

    private static RealMultiProcessSP mInstance;

    public static RealMultiProcessSP getInstance(Context context) {
        if (mInstance == null) {
            synchronized (RealMultiProcessSP.class) {
                if (mInstance == null) {
                    mInstance = new RealMultiProcessSP(PreferenceManager.getMultiProcessSp().getConfigName(), context);
                }
            }
        }
        return mInstance;
    }

    private RealMultiProcessSP(String fileName, Context context) {
        super(fileName, context);
    }

    private RealMultiProcessSP(String fileName, Context context, boolean isSyncToApply) {
        super(fileName, context, isSyncToApply);
    }

}
