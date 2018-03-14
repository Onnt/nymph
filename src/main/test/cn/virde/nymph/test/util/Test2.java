package cn.virde.nymph.test.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
//		testGet();
		
		testSet();
	}
	
	private static void testSet() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ClassB b = new ClassB();
		
		Method method = b.getClass().getMethod("setName", String.class);
		method.invoke(b, "sunao");
		
		System.out.println(b.getName());
	
	}
	
	
	
	private static void testGet() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ClassB b = new ClassB();
		b.setName("sunao");
		b.setPass("pass");
		b.setAge(1);
		
		Class bClass = ClassB.class ;
		Method[] methods = bClass.getMethods();
		for(Method method : methods) {
			String methodName = method.getName() ;
			if(methodName.startsWith("get")&&!methodName.equals("getClass")) {				
				System.out.println(methodName);
				Object name = method.invoke(b, null);
				System.out.println(name);
			}
		}
	}
	
	
	private static void other() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		ClassB b = new ClassB();
		
		Method[] methods = b.getClass().getMethods();
		
		for(Method method : methods) {
			
			System.out.println(method.getName());
		}
		
		Field f = b.getClass().getField("name");
		
		f.setAccessible(true);
		
		f.set(b, "haha");
		
		System.out.println(b.getName());
		
		List<Field> fieldList = new ArrayList<>() ;
		Class tempClass = ClassB.class;
		while (tempClass != null && !tempClass.getName().toLowerCase().equals("java.lang.object")) { //当父类为null的时候说明到达了最上层的父类(Object类).
		      fieldList.addAll(Arrays.asList(tempClass .getDeclaredFields()));
		      tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
		}
		for (Field f2 : fieldList) {
			System.out.println("getFields---"+f2.getName());
		}
	}
}

