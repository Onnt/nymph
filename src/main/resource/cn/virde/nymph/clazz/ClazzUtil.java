package cn.virde.nymph.clazz;

import java.lang.reflect.Field;

/**
 * 
 * @author Virde
 * @time 2018年2月8日 下午3:53:30
 */
public class ClazzUtil {
	
	/**
	 * 
	 * @author Virde
	 * @time 2018年2月8日 下午3:53:35
	 * @param clazz
	 * @param key
	 * @return
	 */
	public String getField(Class clazz,String key){
		Field[] fields = clazz.getDeclaredFields();
		for(Field f : fields) {
			if(f.getName().equals(key)) {
				try {
					return (String) f.get(key);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}
}
