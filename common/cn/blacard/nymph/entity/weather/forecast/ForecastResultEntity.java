package cn.blacard.nymph.entity.weather.forecast;

import cn.blacard.nymph.common.base.BaseEntity;

public class ForecastResultEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4717628982926319500L;
	
	private String status;
	
	private HourlyEntity hourly;
	
	private MinutelyEntity minutely;
	
	private DailyEntity daily;
	
	private AlertEntity alert;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HourlyEntity getHourly() {
		return hourly;
	}

	public void setHourly(HourlyEntity hourly) {
		this.hourly = hourly;
	}

	public MinutelyEntity getMinutely() {
		return minutely;
	}

	public void setMinutely(MinutelyEntity minutely) {
		this.minutely = minutely;
	}

	public DailyEntity getDaily() {
		return daily;
	}

	public void setDaily(DailyEntity daily) {
		this.daily = daily;
	}

	public AlertEntity getAlert() {
		return alert;
	}

	public void setAlert(AlertEntity alert) {
		this.alert = alert;
	}
	
	


}
