package cn.virde.nymph.util;

import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * 加载配置文件属性
 * 
 * @author lvchaohua
 *
 */
public class PropertiesUtil {

	private final static String[] FILES = new String[] { "/jdbc.properties", "/redis.properties",
			"/common.properties" };
	private final static Map<String, Object> PROPERTIES = new HashMap<>();

	static {
		InputStream is = null;
		try {
			for (int i = 0; i < FILES.length; i++) {
				URL url = PropertiesUtil.class.getResource(FILES[i]);
				if (url == null) {
					continue;
				}
				is = url.openStream();
				Properties pro = new Properties();
				pro.load(is);
				Enumeration<?> e = pro.propertyNames();
				while (e.hasMoreElements()) {
					String key = e.nextElement().toString();
					PROPERTIES.put(key, pro.get(key));
				}
			}
		} catch (Exception e) {
//			logger.error("配置文件加载失败" + e.getMessage(), e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
//					logger.error(e);
				}
			}
		}
	}

	public static Object get(String key) {
		return PROPERTIES.get(key);
	}

	public static String getString(String key) {
		Object o = get(key);
		if (o == null)
			return "";
		else
			return o.toString();
	}
	public static String getString(String key,String defaultVal) {
		Object o = get(key);
		if (o == null)
			return defaultVal;
		else
			return o.toString();
	}

	public static int getInt(String key) {
		String s = getString(key);
		if (s == null || "".equals(s))
			return 0;
		else
			return Integer.parseInt(s);
	}

	public static long getLong(String key) {
		String s = getString(key);
		if (s == null || "".equals(s))
			return 0;
		else
			return Long.parseLong(s);
	}

	public static boolean getBoolean(String key) {
		String s = getString(key);
		if (s == null || "".equals(s))
			return false;
		else
			return Boolean.parseBoolean(s);
	}

}
