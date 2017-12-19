package cn.virde.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.virde.nymph.Nym;

public class TestA{
	
	public static void main(String[] args) throws Exception {
		String pageUrl = "https://www.gfresh.cn/no/front?disclass=home&action=gotoProductDetail&ID=280&PortID=1";
		System.out.println(getParam(pageUrl,"action"));
	}
	
	/**
	 * 返回url中名字为name的参数值。
	 * 如果没有这个参数值或者发生异常，则返回NULL
	 * 
	 * @param url
	 * @param name
	 * @return
	 */
	private static String getParam(String url,String name) {
		Map<String,String> map = getParamMap(url);
		Set<String> nameSet = map.keySet();
		for(String n : nameSet) {
			if(n.equals(name)) {
				return map.get(n);
			}
		}
		return null;
	}
	

	/**
	 * 返回pageUrl中携带的参数，存储到map中返回
	 * @param pageUrl 带有参数的url地址
	 * @return 
	 *  如果不包含参数，或者遇到异常则返回空的Map对象
	 * 
	 */
	private static Map<String,String> getParamMap(String pageUrl){
		Map<String,String> map = new HashMap<String,String>();
		if(!pageUrl.contains("?")) return map;
		
		pageUrl = pageUrl.substring(pageUrl.indexOf("?")+1, pageUrl.length());
		if(pageUrl.contains("#")) {
			pageUrl = pageUrl.substring(0,pageUrl.indexOf("#"));
		}
		String[] paramKeyV = pageUrl.split("&");
		for(String keyV : paramKeyV) {
			String[] param = keyV.split("=");
			map.put(param[0], param[1]);
		}
		return map ;
	}
	
}
