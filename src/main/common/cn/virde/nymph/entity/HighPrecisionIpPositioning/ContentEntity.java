package cn.virde.nymph.entity.HighPrecisionIpPositioning;

import cn.virde.nymph.common.base.BaseEntity;
import cn.virde.nymph.entity.base.LocationEntity;

public class ContentEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8935612824470283730L;
	
	private LocationEntity location;
	private String locid;
	private int radius;
	private double confidence;
	public LocationEntity getLocation() {
		return location;
	}
	public void setLocation(LocationEntity location) {
		this.location = location;
	}
	public String getLocid() {
		return locid;
	}
	public void setLocid(String locid) {
		this.locid = locid;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public double getConfidence() {
		return confidence;
	}
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
	public ContentEntity(LocationEntity location, String locid, int radius, double confidence) {
		super();
		this.location = location;
		this.locid = locid;
		this.radius = radius;
		this.confidence = confidence;
	}
	public ContentEntity() {
		super();
	}
	
}
