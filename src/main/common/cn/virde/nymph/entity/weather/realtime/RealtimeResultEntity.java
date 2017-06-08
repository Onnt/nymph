package cn.virde.nymph.entity.weather.realtime;

import cn.virde.nymph.common.base.BaseEntity;

/**
 * 
 * @author Blacard
 * @联系方式  邮箱：blacard@163.com <br/> 手机：18037170703
 * @Create 2016年12月17日 下午7:20:52
 */
public class RealtimeResultEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6662978563885057685L;
	
	private String status;
	private double temperature;
	private String skycon;
	private int pm25;
	private double cloudrate;
	private double humidity;
	private PrecipitationEntity precipitation;
	private WindEntity wind;
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
	public String getSkycon() {
		return skycon;
	}
	public void setSkycon(String skycon) {
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
	public PrecipitationEntity getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(PrecipitationEntity precipitation) {
		this.precipitation = precipitation;
	}
	public WindEntity getWind() {
		return wind;
	}
	public void setWind(WindEntity wind) {
		this.wind = wind;
	}
	public RealtimeResultEntity(String status, double temperature, String skycon, int pm25, double cloudrate, double humidity,
			PrecipitationEntity precipitation, WindEntity wind) {
		super();
		this.status = status;
		this.temperature = temperature;
		this.skycon = skycon;
		this.pm25 = pm25;
		this.cloudrate = cloudrate;
		this.humidity = humidity;
		this.precipitation = precipitation;
		this.wind = wind;
	}
	public RealtimeResultEntity() {
		super();
	}
	

}
