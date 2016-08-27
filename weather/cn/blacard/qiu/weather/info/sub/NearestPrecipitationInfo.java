package cn.blacard.qiu.weather.info.sub;

import cn.blacard.qiu.weather.info.base.BaseInfo;

public class NearestPrecipitationInfo extends BaseInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1461995134052129196L;
	/**
	 * ×´Ì¬
	 */
	private String status;
	/**
	 * ¾àÀë
	 */
	private double distance;
	/**
	 * ½Ç¶È
	 */
	private double intensity;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getIntensity() {
		return intensity;
	}
	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}
	public NearestPrecipitationInfo(String status, double distance, double intensity) {
		super();
		this.status = status;
		this.distance = distance;
		this.intensity = intensity;
	}
	public NearestPrecipitationInfo() {
		super();
	}
	
	
}
