package com.wilson.multiprocesssp.synconfig.base;

import java.util.List;

/**
 * 配置文件接口
 *
 * @author singun
 */
public interface ISharedPreference {
	public String getConfigName();

	public float getFloatValue(String key, float defValue);

	public long getLongValue(String key, long defValue);

	public boolean getBooleanValue(String key, boolean defValue);

	public int getIntValue(String key, int defValue);

	public String getStringValue(String key, String defValue);

	public void setFloatValue(String key, float value);

	public void setBooleanValue(String key, boolean value);

	public void setLongValue(String key, long value);

	public void setIntValue(String key, int value);

	public void setStringValue(String key, String value);

    public void removes(List<String> keys);

	public boolean contains(String key);
}
