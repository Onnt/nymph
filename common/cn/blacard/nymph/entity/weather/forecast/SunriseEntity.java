package cn.blacard.nymph.entity.weather.forecast;

import cn.blacard.nymph.common.base.BaseEntity;

public class SunriseEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1776627443207329666L;
	
	
	private String time;


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public SunriseEntity(String time) {
		super();
		this.time = time;
	}


	public SunriseEntity() {
		super();
	}
	
	
}
