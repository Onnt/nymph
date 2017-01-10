package cn.blacard.nymph.entity;

import cn.blacard.nymph.base.BaseEntity;
import cn.blacard.nymph.entity.weather.forecast.ForecastResultEntity;

public class ForecastWeatherEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4822528405108190860L;
	
	private String status;
	private String lang;
	private long server_time;
	private long tzshift;
	private double[] location;
	private String unit;
	private ForecastResultEntity result;
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
	public ForecastResultEntity getResult() {
		return result;
	}
	public void setResult(ForecastResultEntity result) {
		this.result = result;
	}
	public ForecastWeatherEntity(String status, String lang, long server_time, long tzshift, double[] location,
			String unit, ForecastResultEntity result) {
		super();
		this.status = status;
		this.lang = lang;
		this.server_time = server_time;
		this.tzshift = tzshift;
		this.location = location;
		this.unit = unit;
		this.result = result;
	}
	public ForecastWeatherEntity() {
		super();
	}
	public String toErrorString() {
		return "status:"+status+";error:"+error;
	}

}
