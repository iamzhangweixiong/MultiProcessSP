package com.wilson.multiprocesssp.synconfig.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.List;

/**
 * 配置文件读写
 *
 * @author zhangwx
 */
public class SharedPreferenceWrapper implements ISharedPreference {
    private String mFileName = null;
    private SharedPreferences mSharedPref = null;
    private boolean mIsSyncToApply = false;

    public SharedPreferenceWrapper(String fileName, Context context) {
        init(fileName, context, Context.MODE_PRIVATE, false);
    }

    public SharedPreferenceWrapper(String fileName, Context context, boolean isSyncToApply) {
        init(fileName, context, Context.MODE_PRIVATE, isSyncToApply);
    }

    private void init(String fileName, Context context, int mode, boolean isSyncToApply) {
        // dumpkey=827247409
        if (context != null) {
            mSharedPref = context.getSharedPreferences(fileName, mode);
        }
        mFileName = fileName;
        mIsSyncToApply = isSyncToApply;
    }

    @Override
    public String getConfigName() {
        return mFileName;
    }

    @Override
    public float getFloatValue(String key, float defValue) {
        return mSharedPref.getFloat(key, defValue);
    }

    @Override
    public long getLongValue(String key, long defValue) {
        if (mSharedPref == null) {
            return defValue;
        }
        return mSharedPref.getLong(key, defValue);
    }

    @Override
    public int getIntValue(String key, int defValue) {
        if (mSharedPref == null) {
            return defValue;
        }
        return mSharedPref.getInt(key, defValue);
    }

    @Override
    public boolean getBooleanValue(String key, boolean defValue) {
        if (mSharedPref == null) {
            return defValue;
        }
        return mSharedPref.getBoolean(key, defValue);
    }

    @Override
    public String getStringValue(String key, String defValue) {
        if (mSharedPref == null) {
            return defValue;
        }
        return mSharedPref.getString(key, defValue);
    }

    @Override
    public void setFloatValue(String key, float value) {
        if (mSharedPref == null) {
            return;
        }
        Editor editor = mSharedPref.edit();
        editor.putFloat(key, value);
        applyToEditor(editor);
    }

    @Override
    public void setLongValue(String key, long value) {
        if (mSharedPref == null) {
            return;
        }
        Editor editor = mSharedPref.edit();
        editor.putLong(key, value);
        applyToEditor(editor);
    }

    @Override
    public void setIntValue(String key, int value) {
        if (mSharedPref == null) {
            return;
        }
        Editor editor = mSharedPref.edit();
        editor.putInt(key, value);
        applyToEditor(editor);
    }

    @Override
    public void setBooleanValue(String key, boolean value) {
        if (mSharedPref == null) {
            return;
        }
        Editor editor = mSharedPref.edit();
        editor.putBoolean(key, value);
        applyToEditor(editor);
    }

    @Override
    public void setStringValue(String key, String value) {
        if (mSharedPref == null) {
            return;
        }
        Editor editor = mSharedPref.edit();
        editor.putString(key, value);
        applyToEditor(editor);
    }

    @Override
    public void removes(List<String> keys) {
        if (mSharedPref == null) {
            return;
        }
        Editor editor = mSharedPref.edit();
        for (String key : keys) {
            editor.remove(key);
        }
        applyToEditor(editor);
    }

    @Override
    public boolean contains(String key) {
        if (mSharedPref == null) {
            return false;
        }
        return mSharedPref.contains(key);
    }

    private void applyToEditor(Editor editor) {
        if (mIsSyncToApply) {
            editor.commit();
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) {
                editor.apply();
            } else {
                editor.commit();
            }
        }
    }
}

