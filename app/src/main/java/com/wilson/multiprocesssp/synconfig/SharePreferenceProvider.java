package com.wilson.multiprocesssp.synconfig;

import com.wilson.multiprocesssp.BaseApplication;
import com.wilson.multiprocesssp.synconfig.base.BaseSpProvider;
import com.wilson.multiprocesssp.synconfig.base.ISharedPreference;

import java.util.Map;

/**
 * Created by zhangwx on 2017/7/17.
 *
 * 增加新模块需要放进 configMap 中
 */

public class SharePreferenceProvider extends BaseSpProvider {

    @Override
    protected void updateConfigMap(Map<String, ISharedPreference> configMap) {
        ISharedPreference configFile = RealMultiProcessSP.getInstance(BaseApplication.getContext());
        //
        configMap.put(configFile.getConfigName(), configFile);
    }
}
