package cn.blacard.nymph.entity.weather.forecast;

import cn.blacard.nymph.common.base.BaseEntity;

public class DailyWindMaxAvgMinEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2605905973471251391L;
	
	private double direction;
	
	private double speed;

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public DailyWindMaxAvgMinEntity(double direction, double speed) {
		super();
		this.direction = direction;
		this.speed = speed;
	}

	public DailyWindMaxAvgMinEntity() {
		super();
	}
	
	

}
