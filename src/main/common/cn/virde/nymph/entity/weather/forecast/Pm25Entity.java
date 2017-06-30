package cn.virde.nymph.entity.weather.forecast;


import cn.virde.nymph.common.base.BaseEntity;

public class Pm25Entity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6386712881193373649L;
	
	private double value;
	
	private String datertime;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getDatertime() {
		return datertime;
	}

	public void setDatertime(String datertime) {
		this.datertime = datertime;
	}
	
	

}
