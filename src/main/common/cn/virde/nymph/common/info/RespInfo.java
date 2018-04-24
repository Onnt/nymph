package cn.virde.nymph.common.info;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author Virde
 * @time 2018年1月17日 下午4:10:43
 */
public class RespInfo{

	private boolean isOk ;
	private String info ;
	
	private Object data ;
	
	private Map<String,Object> params = new HashMap<String,Object>();

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public void setIsOk(boolean isOk) {
		this.isOk = isOk;
	}
	public boolean getIsOk() {
		return isOk;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public RespInfo(boolean isOk, String info, Object data) {
		super();
		this.isOk = isOk;
		this.info = info;
		this.data = data;
	}
	public RespInfo(boolean isOk, String info) {
		super();
		this.isOk = isOk;
		this.info = info;
	}
	
	public RespInfo() {
		super();
	}
	
	public static RespInfo ok(String info){
		return new RespInfo(true,info);
	}
	public static RespInfo ok(String info,Object data){
		return new RespInfo(true,info,data);
	}
	public static RespInfo error(String info){
		return new RespInfo(false,info);
	}
	
	public static RespInfo valid(ValidInfo validInfo) {
		return new RespInfo(validInfo.isOk(),validInfo.getInfo(),validInfo.getResult());
	}
	
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
