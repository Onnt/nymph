package cn.virde.nymph.common.info;

import java.util.HashMap;
import java.util.Map;

import cn.virde.nymph.common.base.BaseInfo;

/**
 * 
 * @author Virde
 * 2018年1月17日 下午4:10:43
 */
public class RespInfo extends BaseInfo{


	private boolean succ ;

	private int code ;

	private String info ;
	
	private Object data ;
	
	private Map<String,Object> params = new HashMap<String,Object>();

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public void setSucc(boolean succ){
		this.succ = succ ;
	}
	public boolean getSucc(){
		return succ ;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public RespInfo(boolean succ, int code, String info, Object data) {
		this.succ = succ;
		this.code = code;
		this.info = info;
		this.data = data;
	}

	public RespInfo(boolean succ, String info, Object data){
		super();
		this.succ = succ;
		this.info = info;
		this.data = data;
	}

	public RespInfo(boolean succ, int code, String info) {
		this.succ = succ;
		this.code = code;
		this.info = info;
	}

	public RespInfo(boolean succ, String info) {
		super();
		this.succ = succ;
		this.info = info;
	}
	
	public RespInfo() {
		super();
	}
	
	public static RespInfo ok_format(String info,Object...data) {
		return ok(String.format(info,data));
	}
	public static RespInfo ok(String info){
		return new RespInfo(true,0,info);
	}
	public void setOk(String info){
		setSucc(true);
		setCode(0);
		setInfo(info);
	}
	public static RespInfo ok(String info,Object data){
		return new RespInfo(true,0,info,data);
	}
	public void setOk(String info,Object data){
		setOk(info);
		setData(data);
	}
	public static RespInfo error(String info){
		return new RespInfo(false,-1,info);
	}
	public static RespInfo error(String info,Object...data) {
		return error(String.format(info, data));
	}
	public void setError(String info){
		setSucc(false);
		setCode(-1);
		setInfo(info);
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}
