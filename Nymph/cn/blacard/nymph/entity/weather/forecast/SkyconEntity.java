package cn.blacard.nymph.entity.weather.forecast;


import cn.blacard.nymph.base.BaseEntity;

public class SkyconEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4090503486581679565L;
	
	private String value;
	
	private String datetime;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	
	

}
