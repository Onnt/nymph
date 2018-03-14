package cn.virde.nymph.clazz;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author SunAo
 * @date 2018年3月14日 下午8:30:30
 */
public class BeanCopyUtil {
	
	/**
	 * 
	 * @author SunAo
	 * @date 2018年3月14日 下午8:30:34
	 * @param a
	 * @param b
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T copy(Object a , Class b) {
		try {
			return _copy(a,b);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		T obj = null;
		try {
			obj = (T) b.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj ;
		
	}
 	/**
 	 * 
 	 * @author SunAo
 	 * @date 2018年3月14日 下午8:30:40
 	 * @param a
 	 * @param b
 	 * @return
 	 * @throws InstantiationException
 	 * @throws IllegalAccessException
 	 * @throws IllegalArgumentException
 	 * @throws InvocationTargetException
 	 */
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	private static <T> T _copy(Object a , Class b) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		T obj = (T) b.newInstance();
		
		Method[] aMethods = a.getClass().getMethods();
		Method[] bMethods = b.getMethods() ;
		for(Method aMethod : aMethods) {
			String aMethodName = aMethod.getName() ;
			if(aMethodName.startsWith("get")&&!aMethodName.equals("getClass")) {

				for(Method bMethod : bMethods) {
					String bMethodName = bMethod.getName() ;
					if(bMethodName.startsWith("set")&&aMethodName.substring(3).equals(bMethodName.substring(3))) {
						bMethod.invoke(obj, aMethod.invoke(a, null));
					}
				}
			}
		}
		return obj;
	}
}
