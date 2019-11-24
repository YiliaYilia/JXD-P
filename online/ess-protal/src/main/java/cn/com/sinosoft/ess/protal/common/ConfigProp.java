package cn.com.sinosoft.ess.protal.common;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ConfigProp {
	private static final String BUNDLE_NAME = "config/config";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private ConfigProp() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
