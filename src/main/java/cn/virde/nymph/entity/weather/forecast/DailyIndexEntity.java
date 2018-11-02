package cn.virde.nymph.entity.weather.forecast;

import cn.virde.nymph.entity.base.BaseEntity;;

public class DailyIndexEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6784870010747853648L;
	
	private String index;
	private String desc;
	private String datetime;
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	

}
