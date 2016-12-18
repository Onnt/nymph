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
	/**
	 * 转换成字符串
	 * <br/>
	 * 纬经度，sample:"25.1552,121.654"
	 */
	public String toString() {
		return this.lat+","+this.lng;
	}
	/**
	 * 转成经纬度，sample:"121.6544,25.1552"
	 * @author Blacard
	 * @create 2016年12月18日 下午8:30:25
	 * @return
	 */
	public String toStringLngLat(){
		return this.lng+","+this.lat;
	}
	/**
	 * 转成纬经度.sample:"25.1552,121.654"
	 * @author Blacard
	 * @create 2016年12月18日 下午8:30:30
	 * @return
	 */
	public String toStringLatLng(){
		return toString();
	}
}
