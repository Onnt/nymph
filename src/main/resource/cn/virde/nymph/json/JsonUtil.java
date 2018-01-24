package cn.virde.nymph.json;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author Virde
 * @time 2018年1月24日 下午3:43:54
 */
public class JsonUtil {
	
	/**
	 * 
	 * @author Virde
	 * @time 2018年1月24日 下午3:51:53
	 * @param json
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object jsonToObject(String json,@SuppressWarnings("rawtypes") Class clazz) {
		return JSON.parseObject(json, clazz);
	}
	
	/**
	 * 
	 * @author Virde
	 * @time 2018年1月24日 下午3:51:59
	 * @return
	 */
	public String objectToJsonString(Object obj) {
		return JSON.toJSONString(obj);
	}
	
}
