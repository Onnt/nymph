package cn.virde.nymph.entity.weather.forecast;


import cn.virde.nymph.common.base.BaseEntity;

public class DailyEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2873816105984967225L;
	
	private String status;
	
	private AstroEntity[] astro;
	
	private DailyTemperatureEntity[] temperature;
	
	private DailyPm25Entity[] pm25;
	
	private DailySkyconEntity[] skycon;
	
	private DailyCloudrateEntity[] cloudrate;
	
	private DailyAqiEntity[] aqi;
	
	private DailyPrecipitationEntity[] precipitation;
	
	private DailyWindEntity[] wind;
	
	private DailyHumidityEntity[] humidity;
	
	private DailyIndexEntity[] coldRisk;
	
	private DailyIndexEntity[] ultraviolet;
	
	private DailyIndexEntity[] dressing;

	private DailyIndexEntity[] carWashing;
	
	public DailyIndexEntity[] getUltraviolet() {
		return ultraviolet;
	}

	public void setUltraviolet(DailyIndexEntity[] ultraviolet) {
		this.ultraviolet = ultraviolet;
	}

	public DailyIndexEntity[] getDressing() {
		return dressing;
	}

	public void setDressing(DailyIndexEntity[] dressing) {
		this.dressing = dressing;
	}

	public DailyIndexEntity[] getCarWashing() {
		return carWashing;
	}

	public void setCarWashing(DailyIndexEntity[] carWashing) {
		this.carWashing = carWashing;
	}

	public DailyIndexEntity[] getColdRisk() {
		return coldRisk;
	}

	public void setColdRisk(DailyIndexEntity[] coldRisk) {
		this.coldRisk = coldRisk;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AstroEntity[] getAstro() {
		return astro;
	}

	public void setAstro(AstroEntity[] astro) {
		this.astro = astro;
	}

	public DailyTemperatureEntity[] getTemperature() {
		return temperature;
	}

	public void setTemperature(DailyTemperatureEntity[] temperature) {
		this.temperature = temperature;
	}

	public DailyPm25Entity[] getPm25() {
		return pm25;
	}

	public void setPm25(DailyPm25Entity[] pm25) {
		this.pm25 = pm25;
	}

	public DailySkyconEntity[] getSkycon() {
		return skycon;
	}

	public void setSkycon(DailySkyconEntity[] skycon) {
		this.skycon = skycon;
	}

	public DailyCloudrateEntity[] getCloudrate() {
		return cloudrate;
	}

	public void setCloudrate(DailyCloudrateEntity[] cloudrate) {
		this.cloudrate = cloudrate;
	}

	public DailyAqiEntity[] getAqi() {
		return aqi;
	}

	public void setAqi(DailyAqiEntity[] aqi) {
		this.aqi = aqi;
	}

	public DailyPrecipitationEntity[] getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(DailyPrecipitationEntity[] precipitation) {
		this.precipitation = precipitation;
	}

	public DailyWindEntity[] getWind() {
		return wind;
	}

	public void setWind(DailyWindEntity[] wind) {
		this.wind = wind;
	}

	public DailyHumidityEntity[] getHumidity() {
		return humidity;
	}

	public void setHumidity(DailyHumidityEntity[] humidity) {
		this.humidity = humidity;
	}
	
	
	
}
