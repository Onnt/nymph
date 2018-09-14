package cn.virde.nymph.json;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author Virde
 * 2018年1月24日 下午3:43:54
 */
public class JsonUtil {
	
	/**
	 * 
	 * @author Virde
	 * @param <T>
	 * 2018年1月24日 下午3:51:53
	 * @param json json字符串
	 * @param clazz 类型
	 * @return 返回
	 */
	public <T> T jsonToObject(String json,Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}
	
	/**
	 * 
	 * @author Virde
	 * 2018年1月24日 下午3:51:59
	 * @return 返回
	 */
	public String objectToJsonString(Object obj) {
		return JSON.toJSONString(obj);
	}
	
}
