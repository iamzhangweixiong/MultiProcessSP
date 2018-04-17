package com.wilson.multiprocesssp.synconfig.base;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

/**
 * Created by zhangwx
 * on 2017/3/23 0023.
 */

public class MultiProcessSP implements ISharedPreference {
    public static final String TAG_CONFIG = "SpProviderBridge";
    private Context mContext;
    private ContentResolver mContentResolver;
    private String mConfigName;

    public MultiProcessSP(Context context, String configName) {
        mContext = context.getApplicationContext();
        mContentResolver = context.getContentResolver();
        mConfigName = configName;
    }

    @Override
    public String getConfigName() {
        return mConfigName;
    }

    public void setBooleanValue(String key, boolean value) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(BaseSpProvider.EXTRA_TYPE, BaseSpProvider.TYPE_BOOLEAN);
        contentValues.put(BaseSpProvider.EXTRA_KEY, key);
        contentValues.put(BaseSpProvider.EXTRA_VALUE, value);

        Uri uri = BaseSpProvider.convertUri(mConfigName);
        try {
            mContentResolver.update(uri, contentValues, null, null);
        } catch (Exception e) {
            Log.e(TAG_CONFIG, "ContentResolver setBooleanValue fail : ", e);
        }
    }

    public void setLongValue(String key, long value) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(BaseSpProvider.EXTRA_TYPE, BaseSpProvider.TYPE_LONG);
        contentValues.put(BaseSpProvider.EXTRA_KEY, key);
        contentValues.put(BaseSpProvider.EXTRA_VALUE, value);

        Uri uri = BaseSpProvider.convertUri(mConfigName);
        try {
            mContentResolver.update(uri, contentValues, null, null);
        } catch (Exception e) {
            Log.e(TAG_CONFIG, "ContentResolver setLongValue fail : ", e);
        }
    }

    public void setIntValue(String key, int value) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BaseSpProvider.EXTRA_TYPE, BaseSpProvider.TYPE_INT);
        contentValues.put(BaseSpProvider.EXTRA_KEY, key);
        contentValues.put(BaseSpProvider.EXTRA_VALUE, value);

        Uri uri = BaseSpProvider.convertUri(mConfigName);
        try {
            mContentResolver.update(uri, contentValues, null, null);
        } catch (Exception e) {
            Log.e(TAG_CONFIG, "ContentResolver setIntValue fail : ", e);
        }
    }

    @Override
    public void setFloatValue(String key, float value) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(BaseSpProvider.EXTRA_TYPE, BaseSpProvider.TYPE_FLOAT);
        contentValues.put(BaseSpProvider.EXTRA_KEY, key);
        contentValues.put(BaseSpProvider.EXTRA_VALUE, value);

        Uri uri = BaseSpProvider.convertUri(mConfigName);
        try {
            mContentResolver.update(uri, contentValues, null, null);
        } catch (Exception e) {
            Log.e(TAG_CONFIG, "ContentResolver setFloatValue fail : ", e);
        }
    }

    public void setStringValue(String key, String value) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BaseSpProvider.EXTRA_TYPE, BaseSpProvider.TYPE_STRING);
        contentValues.put(BaseSpProvider.EXTRA_KEY, key);
        contentValues.put(BaseSpProvider.EXTRA_VALUE, value);

        Uri uri = BaseSpProvider.convertUri(mConfigName);
        try {
            mContentResolver.update(uri, contentValues, null, null);
        } catch (Exception e) {
            Log.e(TAG_CONFIG, "ContentResolver setStringValue fail : ", e);
        }
    }

    public void removes(List<String> keys) {
        if (keys == null || keys.size() == 0) {
            return;
        }
        String[] keyArray = new String[keys.size()];
        keyArray = keys.toArray(keyArray);
        Uri uri = BaseSpProvider.convertUri(mConfigName);
        try {
            mContentResolver.delete(uri, null, keyArray);
        } catch (Exception e) {
            Log.e(TAG_CONFIG, "ContentResolver removes fail : ", e);
        }
    }

    @Deprecated
    @Override
    public boolean contains(String key) {
        return false;
    }

    public long getLongValue(String key, long defValue) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BaseSpProvider.EXTRA_TYPE, BaseSpProvider.TYPE_LONG);
        contentValues.put(BaseSpProvider.EXTRA_KEY, key);
        contentValues.put(BaseSpProvider.EXTRA_VALUE, defValue);

        Uri uri = BaseSpProvider.convertUri(mConfigName);
        Uri result = null;
        try {
            result = mContentResolver.insert(uri, contentValues);
        } catch (Exception e) {
            Log.e(TAG_CONFIG, "ContentResolver getLongValue fail : ", e);
        }

        if (result == null) {
            return defValue;
        }
        String r = BaseSpProvider.splitConfigParam(result);
        if (TextUtils.isEmpty(r) || TextUtils.equals(r, "null")) {
            return defValue;
        } else {
            return Long.valueOf(r);
        }
    }

    public boolean getBooleanValue(String key, boolean defValue) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BaseSpProvider.EXTRA_TYPE, BaseSpProvider.TYPE_BOOLEAN);
        contentValues.put(BaseSpProvider.EXTRA_KEY, key);
        contentValues.put(BaseSpProvider.EXTRA_VALUE, defValue);

        Uri uri = BaseSpProvider.convertUri(mConfigName);
        Uri result = null;
        try {
            result = mContentResolver.insert(uri, contentValues);
        } catch (Exception e) {
            Log.e(TAG_CONFIG, "ContentResolver getBooleanValue fail : ", e);
        }
        if (result == null) {
            return defValue;
        }
        String r = BaseSpProvider.splitConfigParam(result);
        if (TextUtils.isEmpty(r) || TextUtils.equals(r, "null")) {
            return defValue;
        } else {
            return Boolean.valueOf(r);
        }
    }

    public int getIntValue(String key, int defValue) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BaseSpProvider.EXTRA_TYPE, BaseSpProvider.TYPE_INT);
        contentValues.put(BaseSpProvider.EXTRA_KEY, key);
        contentValues.put(BaseSpProvider.EXTRA_VALUE, defValue);

        Uri uri = BaseSpProvider.convertUri(mConfigName);
        Uri result = null;
        try {
            result = mContentResolver.insert(uri, contentValues);
        } catch (Exception e) {
            Log.e(TAG_CONFIG, "ContentResolver getIntValue fail : ", e);
        }
        if (result == null) {
            return defValue;
        }
        String r = BaseSpProvider.splitConfigParam(result);
        if (TextUtils.isEmpty(r) || TextUtils.equals(r, "null")) {
            return defValue;
        } else {
            return Integer.valueOf(r);
        }
    }

    public String getStringValue(String key, String defValue) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BaseSpProvider.EXTRA_TYPE, BaseSpProvider.TYPE_STRING);
        contentValues.put(BaseSpProvider.EXTRA_KEY, key);
        contentValues.put(BaseSpProvider.EXTRA_VALUE, defValue);

        Uri uri = BaseSpProvider.convertUri(mConfigName);
        Uri result = null;
        try {
            result = mContentResolver.insert(uri, contentValues);
        } catch (Exception e) {
            Log.e(TAG_CONFIG, "ContentResolver getStringValue fail : ", e);
        }
        if (result == null) {
            return defValue;
        }

        String r = BaseSpProvider.splitConfigParam(result);
        if (TextUtils.isEmpty(r) || TextUtils.equals(r, "null")) {
            return defValue;
        } else {
            return String.valueOf(r);
        }
    }

    @Override
    public float getFloatValue(String key, float defValue) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BaseSpProvider.EXTRA_TYPE, BaseSpProvider.TYPE_STRING);
        contentValues.put(BaseSpProvider.EXTRA_KEY, key);
        contentValues.put(BaseSpProvider.EXTRA_VALUE, defValue);

        Uri uri = BaseSpProvider.convertUri(mConfigName);
        Uri result = null;
        try {
            result = mContentResolver.insert(uri, contentValues);
        } catch (Exception e) {
            Log.e(TAG_CONFIG, "ContentResolver getFloatValue fail : ", e);
        }
        if (result == null) {
            return defValue;
        }

        String r = BaseSpProvider.splitConfigParam(result);
        if (TextUtils.isEmpty(r) || TextUtils.equals(r, "null")) {
            return defValue;
        } else {
            return Float.valueOf(r);
        }
    }
}
