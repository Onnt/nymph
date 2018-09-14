package cn.virde.nymph.jwt;

import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author Virde
 * 2018年1月17日 下午4:11:01
 */
public class Jwt {
	private String id ;
	private String name ;
	private String ip ;
	private long time ;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
	public long getTime() {
		return time;
	}
	
	/**
	 * 设置jwt超时时间，单位是秒
	 * @param timeout 超时时间
	 */
	public void setTimeout(long timeout) {
		long now = new Date().getTime();
		
		this.time = now + timeout * 1000;
	}
	
	public Jwt(String id, String name, String ip) {
		super();
		this.id = id;
		this.name = name;
		this.ip = ip;
		setTimeout(60 * 60 * 24 * 7);
	}
	public Jwt(String id) {
		super();
		this.id = id;
	}
	public Jwt() {
		super();
	}
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
