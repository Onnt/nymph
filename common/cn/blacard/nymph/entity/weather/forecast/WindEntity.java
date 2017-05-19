package cn.blacard.nymph.entity.weather.forecast;


import cn.blacard.nymph.common.base.BaseEntity;

public class WindEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -225047226419934738L;
	
	private double direction;
	private double speed;
	private String datetime;
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
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	
}
