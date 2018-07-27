package cn.virde.nymph.entity.weather.forecast;


import cn.virde.nymph.common.base.BaseEntity;

public class HumidityEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6424412072624522381L;
	
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
