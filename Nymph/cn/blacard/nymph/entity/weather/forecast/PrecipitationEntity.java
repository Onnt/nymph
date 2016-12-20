package cn.blacard.nymph.entity.weather.forecast;


import cn.blacard.nymph.base.BaseEntity;

public class PrecipitationEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 190551222904070065L;
	
	private double value;

	private String datetime;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	

	
}

