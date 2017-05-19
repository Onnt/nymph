package cn.blacard.nymph.entity.weather.forecast;

import cn.blacard.nymph.common.base.BaseEntity;

public class MinutelyEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3154122691812132401L;
	
	private String status;
	
	private double[] precipitation;
	
	private String datasource;
	
	private String description;
	
	private double[] probability;
	
	private double[] precipitation_2h;
	
	public double[] getPrecipitation_2h() {
		return precipitation_2h;
	}

	public void setPrecipitation_2h(double[] precipitation_2h) {
		this.precipitation_2h = precipitation_2h;
	}

	public double[] getProbability() {
		return probability;
	}

	public void setProbability(double[] probability) {
		this.probability = probability;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double[] getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(double[] precipitation) {
		this.precipitation = precipitation;
	}

	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MinutelyEntity(String status, double[] precipitation, String datasource, String description) {
		super();
		this.status = status;
		this.precipitation = precipitation;
		this.datasource = datasource;
		this.description = description;
	}

	public MinutelyEntity() {
		super();
	}
	
	

}
