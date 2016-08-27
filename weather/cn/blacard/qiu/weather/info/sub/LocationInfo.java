package cn.blacard.qiu.weather.info.sub;

import cn.blacard.qiu.weather.info.base.BaseInfo;

public class LocationInfo extends BaseInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5762705733719904486L;
	/**
	 * ¾­¶È  longitude
	 */
	private double lng;
	/**
	 * Î³¶È  latitude
	 */
	private double lat;
	
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public LocationInfo(double lng, double lat) {
		super();
		this.lng = lng;
		this.lat = lat;
	}
	
	public LocationInfo() {
		super();
	}

}
