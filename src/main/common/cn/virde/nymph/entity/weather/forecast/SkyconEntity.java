package cn.virde.nymph.entity.weather.forecast;


import cn.virde.nymph.common.base.BaseEntity;

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
