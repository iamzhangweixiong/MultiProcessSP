package com.wilson.multiprocesssp.synconfig;

import com.wilson.multiprocesssp.BaseApplication;
import com.wilson.multiprocesssp.synconfig.base.MultiProcessSP;

/**
 * Created by zhangwx
 * on 2017/7/17.
 */

public class PreferenceManager {

    private static MultiProcessSP mMultiProcessSp;
    public static final String COMMON_SYNC_SP_NAME = "common_sync_sp";

    public static void init() {
        if (mMultiProcessSp == null) {
            mMultiProcessSp = new MultiProcessSP(BaseApplication.getContext(), COMMON_SYNC_SP_NAME);
        }
    }

    /**
     * 此 MultiProcessSP 用于存储公共模块跨进程数据
     */
    public static MultiProcessSP getMultiProcessSp() {
        if (mMultiProcessSp == null) {
            init();
        }
        return mMultiProcessSp;
    }
}
