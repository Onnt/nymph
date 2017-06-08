package cn.virde.nymph.entity.Geocoding;

import cn.virde.nymph.common.base.BaseEntity;
import cn.virde.nymph.entity.base.LocationEntity;

public class GeocodingResultEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 978049107577620078L;
	
	private LocationEntity location;
	
	private int precise;
	private int confidence;
	private String level;
	public LocationEntity getLocation() {
		return location;
	}
	public void setLocation(LocationEntity location) {
		this.location = location;
	}
	public int getPrecise() {
		return precise;
	}
	public void setPrecise(int precise) {
		this.precise = precise;
	}
	public int getConfidence() {
		return confidence;
	}
	public void setConfidence(int confidence) {
		this.confidence = confidence;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
}
