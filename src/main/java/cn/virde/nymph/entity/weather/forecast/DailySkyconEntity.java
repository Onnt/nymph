package cn.virde.nymph.entity.weather.forecast;


import cn.virde.nymph.entity.base.BaseEntity;;

public class DailySkyconEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 749056139736009969L;
	
	private String date;
	
	private String value;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
