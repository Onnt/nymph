package cn.blacard.nymph.entity.weather.realtime;

import cn.blacard.nymph.common.base.BaseEntity;

public class WindEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6571126320728946786L;
	
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
	public WindEntity(double direction, double speed) {
		super();
		this.direction = direction;
		this.speed = speed;
	}
	public WindEntity() {
		super();
	}
	

}
