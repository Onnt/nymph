package cn.blacard.nymph.entity.weather.forecast;

import cn.blacard.nymph.common.base.BaseEntity;

public class HourlyEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6082763233016975478L;

	private String status;
	
	private Pm25Entity[] pm25;
	
	private String description;
	
	private SkyconEntity[] skycon;
	
	private CloudrateEntity[] cloudrate;
	
	private AqiEntity[] aqi;
	
	private HumidityEntity[] humidity;
	
	private PrecipitationEntity[] precipitation;
	
	private WindEntity[] wind;
	
	private TemperatureEntity[] temperature;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pm25Entity[] getPm25() {
		return pm25;
	}

	public void setPm25(Pm25Entity[] pm25) {
		this.pm25 = pm25;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SkyconEntity[] getSkycon() {
		return skycon;
	}

	public void setSkycon(SkyconEntity[] skycon) {
		this.skycon = skycon;
	}

	public CloudrateEntity[] getCloudrate() {
		return cloudrate;
	}

	public void setCloudrate(CloudrateEntity[] cloudrate) {
		this.cloudrate = cloudrate;
	}

	public AqiEntity[] getAqi() {
		return aqi;
	}

	public void setAqi(AqiEntity[] aqi) {
		this.aqi = aqi;
	}

	public HumidityEntity[] getHumidity() {
		return humidity;
	}

	public void setHumidity(HumidityEntity[] humidity) {
		this.humidity = humidity;
	}

	public PrecipitationEntity[] getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(PrecipitationEntity[] precipitation) {
		this.precipitation = precipitation;
	}

	public WindEntity[] getWind() {
		return wind;
	}

	public void setWind(WindEntity[] wind) {
		this.wind = wind;
	}

	public TemperatureEntity[] getTemperature() {
		return temperature;
	}

	public void setTemperature(TemperatureEntity[] temperature) {
		this.temperature = temperature;
	}

	public HourlyEntity(String status, Pm25Entity[] pm25, String description, SkyconEntity[] skycon,
			CloudrateEntity[] cloudrate, AqiEntity[] aqi, HumidityEntity[] humidity,
			PrecipitationEntity[] precipitation, WindEntity[] wind, TemperatureEntity[] temperature) {
		super();
		this.status = status;
		this.pm25 = pm25;
		this.description = description;
		this.skycon = skycon;
		this.cloudrate = cloudrate;
		this.aqi = aqi;
		this.humidity = humidity;
		this.precipitation = precipitation;
		this.wind = wind;
		this.temperature = temperature;
	}

	public HourlyEntity() {
		super();
	}
	
	
}
