package cn.blacard.qiu.weather.info.sub;

import cn.blacard.qiu.weather.info.base.BaseInfo;

public class WindInfo extends BaseInfo{
/**
	 * 
	 */
	private static final long serialVersionUID = 7538469703396440002L;
	
	/**
	 * 风向。单位是度。正北方向为0度，顺时针增加到360度。
	 */
	private double direction;
	/**
	 * 风速，米制下是公里每小时
	 */
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
	public WindInfo(double direction, double speed) {
		super();
		this.direction = direction;
		this.speed = speed;
	}
	public WindInfo() {
		super();
	}
	
	
	
}
