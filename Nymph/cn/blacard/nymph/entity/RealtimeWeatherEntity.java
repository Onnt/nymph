package cn.blacard.nymph.entity;

import cn.blacard.nymph.base.BaseEntity;
import cn.blacard.nymph.entity.weather.realtime.RealtimeResultEntity;

/**
 * 
 * @author Blacard
 * @联系方式  邮箱：blacard@163.com <br/> 手机：18037170703
 * @Create 2016年12月17日 下午7:13:13
 */
public class RealtimeWeatherEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8634409131571842374L;
	
	private String status;
	private String lang;
	private long server_time;
	private long tzshift;
	private double[] location;
	private String unit;
	private RealtimeResultEntity result;
	
	private String error;
	
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public long getServer_time() {
		return server_time;
	}
	public void setServer_time(long server_time) {
		this.server_time = server_time;
	}
	public long getTzshift() {
		return tzshift;
	}
	public void setTzshift(long tzshift) {
		this.tzshift = tzshift;
	}
	public double[] getLocation() {
		return location;
	}
	public void setLocation(double[] location) {
		this.location = location;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public RealtimeResultEntity getResult() {
		return result;
	}
	public void setResult(RealtimeResultEntity result) {
		this.result = result;
	}
	public RealtimeWeatherEntity(String status, String lang, long server_time, long tzshift, double[] location,
			String unit, RealtimeResultEntity result) {
		super();
		this.status = status;
		this.lang = lang;
		this.server_time = server_time;
		this.tzshift = tzshift;
		this.location = location;
		this.unit = unit;
		this.result = result;
	}
	public RealtimeWeatherEntity() {
		super();
	}
	
	public String toErrorString() {
		return "status:"+status+";error:"+error;
	}
}
