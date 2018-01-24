package cn.virde.nymph.json;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author Virde
 * @time 2018年1月24日 下午3:43:54
 */
public class JsonUtil {
	
	@SuppressWarnings("unchecked")
	public Object jsonToObject(String json,@SuppressWarnings("rawtypes") Class clazz) {
		return JSON.parseObject(json, clazz);
	}
	
	public String objectToJsonString() {
		
		return null;
	}
	
}
