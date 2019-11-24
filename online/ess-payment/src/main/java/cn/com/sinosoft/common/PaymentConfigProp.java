package cn.com.sinosoft.common;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class PaymentConfigProp {
	private static final String BUNDLE_NAME = "config/paymentConfig";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private PaymentConfigProp() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
