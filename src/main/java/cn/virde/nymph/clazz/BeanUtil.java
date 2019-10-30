package cn.virde.nymph.clazz;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SunAo
 * 2018年3月14日 下午8:30:30
 *  这个类被弃用了，因为在别的工具包中已经有很好的实现了
 * 2019年10月23日 09:49:51
 */
@Deprecated
public class BeanUtil {

	/**
	 * 将list中的信息Copy到类型为b的列表中
	 * 2018年3月15日 下午2:21:42
	 * @author SunAo
	 * @param list 数据来源列表
	 * @param b 目标列表类型
	 * @return 拷贝完成的list
	 */
	public static <T> List<T> copyList(List<?> list , Class<T> b){
		List<T> respList = new ArrayList<T>();
		for(Object a : list ) {
			T obj = copy(a, b);
			respList.add(obj);
		}
		return respList ;
	}
	
	/**
	 * 将 对象a 和类b 中相同字段拷贝到类b的实例，将类b实例返回
	 * 
	 * @author SunAo
	 * 2018年3月14日 下午8:30:34
	 * @param a 对象a
	 * @param b 类b
	 * @return 装载着a对象信息的b实例
	 */
	public static <T> T copy(Object a , Class<T> b) {
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
 	 * 2018年3月14日 下午8:30:40
 	 * @param a 数据来源对象a
 	 * @param b 目标对象b
 	 * @return 返回
 	 * @throws InstantiationException 异常
 	 * @throws IllegalAccessException 异常
 	 * @throws IllegalArgumentException 异常
 	 * @throws InvocationTargetException 异常
 	 */
	private static <T> T _copy(Object a , Class<T> b) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		T obj = (T) b.newInstance();
		
		Method[] aMethods = a.getClass().getMethods();
		Method[] bMethods = b.getMethods() ;
		for(Method aMethod : aMethods) {
			String aMethodName = aMethod.getName() ;
			if(aMethodName.startsWith("get")&&!aMethodName.equals("getClass")) {

				for(Method bMethod : bMethods) {
					String bMethodName = bMethod.getName() ;
					if(bMethodName.startsWith("set")&&aMethodName.substring(3).toLowerCase().equals(bMethodName.substring(3).toLowerCase())) {
						bMethod.invoke(obj, aMethod.invoke(a, null));
					}
				}
			}
		}
		return obj;
	}
}
