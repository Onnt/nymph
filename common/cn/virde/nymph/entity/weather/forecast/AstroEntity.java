package cn.virde.nymph.entity.weather.forecast;


import cn.virde.nymph.common.base.BaseEntity;

public class AstroEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7993250883769462213L;
	
	private String date;
	
	private SunsetEntity sunset;
	
	private SunriseEntity sunrise;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public SunsetEntity getSunset() {
		return sunset;
	}

	public void setSunset(SunsetEntity sunset) {
		this.sunset = sunset;
	}

	public SunriseEntity getSunrise() {
		return sunrise;
	}

	public void setSunrise(SunriseEntity sunrise) {
		this.sunrise = sunrise;
	}

	
	

}
