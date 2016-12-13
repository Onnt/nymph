package cn.blacard.nymph.entity.base;

import cn.blacard.nymph.base.BaseEntity;

public class LocationEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4990061270128175850L;
	
	private double lat;
	private double lng;
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public LocationEntity(double lat, double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	public LocationEntity() {
		super();
	}

	@Override
	public String toString() {
		
		return this.lat+","+this.lng;
	}
	
}
