package cn.virde.nymph.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import cn.virde.nymph.exception.NotExistFieldException;

/**
 * 
 * @author Virde
 * 2018年2月8日 下午3:53:30
 */
public class ClazzUtil {
	
	/**
	 * 
	 * @author Virde
	 * 2018年2月8日 下午3:53:35
	 * @param clazz 类类型
	 * @param key 关键字
	 * @return 返回
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
	/**
	 * 
	 * @author Virde
	 * 2018年6月7日 下午3:24:14
	 * @param a 对象a
	 * @param key 关键字
	 * @return 返回
	 * @throws IllegalAccessException 异常
	 * @throws IllegalArgumentException 异常
	 * @throws InvocationTargetException 异常
	 * @throws NotExistFieldException 异常
	 */
	public Object getField(Object a,String key) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NotExistFieldException {
		Method[] aMethods = a.getClass().getMethods() ;
		for(Method m : aMethods) {
			String mName = m.getName() ;
			if(mName.startsWith("get")&&mName.substring(3).toLowerCase().equals(key)) {
				return m.invoke(a, null);
			}
		}
		throw new NotExistFieldException("不存在的属性：" + key) ;
	}
	
	/**
	 * 
	 * @author Virde
	 * 2018年6月7日 下午3:24:08
	 * @param a 对象a
	 * @return 返回
	 * @throws IllegalAccessException  异常
	 * @throws IllegalArgumentException 异常
	 * @throws InvocationTargetException 异常
	 */
	public Map<String,String> getField(Object a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Map<String,String> respMap = new HashMap<String,String>();
		Method[] aMethods = a.getClass().getMethods();
		for(Method aMethod : aMethods) {
			String aMethodName = aMethod.getName() ;
			if(aMethodName.startsWith("get")&&!aMethodName.equals("getClass")) {
				String key = aMethodName.substring(3).toLowerCase() ;
				String value = (String) aMethod.invoke(a, null) ;
				if(value != null && !value.equals("")) {
					respMap.put(key, value);
				}
			}
		}
		return respMap ;
	}
	
}
