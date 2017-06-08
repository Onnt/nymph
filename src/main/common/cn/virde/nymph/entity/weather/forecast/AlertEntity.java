package cn.virde.nymph.entity.weather.forecast;

import cn.virde.nymph.common.base.BaseEntity;

public class AlertEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8278884705910888599L;
	
	private AlertArrayEntity[] array;

	public AlertArrayEntity[] getArray() {
		return array;
	}

	public void setArray(AlertArrayEntity[] array) {
		this.array = array;
	}

	public AlertEntity(AlertArrayEntity[] array) {
		super();
		this.array = array;
	}

	public AlertEntity() {
		super();
	}
	

}
