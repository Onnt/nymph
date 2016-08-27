package cn.blacard.qiu.weather.info;

import cn.blacard.qiu.weather.enums.SkyconsEnum;
import cn.blacard.qiu.weather.info.base.BaseWeatherResultInfo;
import cn.blacard.qiu.weather.info.sub.LocalPrecipitationInfo;
import cn.blacard.qiu.weather.info.sub.NearestPrecipitationInfo;
import cn.blacard.qiu.weather.info.sub.WindInfo;

public class RealTimeWeatherResultInfo extends BaseWeatherResultInfo{
	
	private static final long serialVersionUID = -7731797228243712532L;
	
	private String status;
	/**
	 * 温度
	 */
	private double temperature;
	/**
	 * 天气概况
	 */
	private SkyconsEnum skycon;
	/**
	 * pm25值   在新的api中增加的字段
	 */
	private int pm25;
	/**
	 *  云量
	 */
	private double cloudrate;
	/**
	 * 相对湿度
	 */
	private double humidity;
	/**
	 * 最近的降水带 //用户补充：nearest这段有时候没有
	 */
	private NearestPrecipitationInfo nearPrecipitation;
	/**
	 * 本地的降水
	 */
	private LocalPrecipitationInfo localPrecipition;
	/**
	 * 风
	 */
	private WindInfo wind;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public SkyconsEnum getSkycon() {
		return skycon;
	}
	public void setSkycon(SkyconsEnum skycon) {
		this.skycon = skycon;
	}
	public int getPm25() {
		return pm25;
	}
	public void setPm25(int pm25) {
		this.pm25 = pm25;
	}
	public double getCloudrate() {
		return cloudrate;
	}
	public void setCloudrate(double cloudrate) {
		this.cloudrate = cloudrate;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public NearestPrecipitationInfo getNearPrecipitation() {
		return nearPrecipitation;
	}
	public void setNearPrecipitation(NearestPrecipitationInfo nearPrecipitation) {
		this.nearPrecipitation = nearPrecipitation;
	}
	public LocalPrecipitationInfo getLocalPrecipition() {
		return localPrecipition;
	}
	public void setLocalPrecipition(LocalPrecipitationInfo localPrecipition) {
		this.localPrecipition = localPrecipition;
	}
	public WindInfo getWind() {
		return wind;
	}
	public void setWind(WindInfo wind) {
		this.wind = wind;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public RealTimeWeatherResultInfo(String status, double temperature, SkyconsEnum skycon, int pm25, double cloudrate,
			double humidity, NearestPrecipitationInfo nearPrecipitation, LocalPrecipitationInfo localPrecipition,
			WindInfo wind) {
		super();
		this.status = status;
		this.temperature = temperature;
		this.skycon = skycon;
		this.pm25 = pm25;
		this.cloudrate = cloudrate;
		this.humidity = humidity;
		this.nearPrecipitation = nearPrecipitation;
		this.localPrecipition = localPrecipition;
		this.wind = wind;
	}
	public RealTimeWeatherResultInfo() {
		super();
	}
	

	
	
}
