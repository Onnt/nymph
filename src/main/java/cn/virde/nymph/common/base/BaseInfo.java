package cn.virde.nymph.common.base;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author Virde
 * 2018年8月30日 下午2:55:22
 */
public class BaseInfo {
	public String toJSONString() {
		return JSON.toJSONString(this);
	}
}
