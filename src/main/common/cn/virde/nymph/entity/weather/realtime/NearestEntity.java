package cn.virde.nymph.entity.weather.realtime;

import cn.virde.nymph.common.base.BaseEntity;

public class NearestEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6303018125982939504L;
	
	private String status;
	private double distance;
	private double intensity;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getIntensity() {
		return intensity;
	}
	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}
	public NearestEntity(String status, double distance, double intensity) {
		super();
		this.status = status;
		this.distance = distance;
		this.intensity = intensity;
	}
	public NearestEntity() {
		super();
	}

	
}
