package cn.blacard.nymph.entity.Geocoding;

import cn.blacard.nymph.common.base.BaseEntity;

public class AddressComponentEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4805242742288446343L;

	private String country;
	private String country_code;
	private String province;
	private String city;
	private String district;
	private String adcode0108;
	private String street;
	private String street_number;
	private String direction;
	private String distance;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAdcode0108() {
		return adcode0108;
	}
	public void setAdcode0108(String adcode0108) {
		this.adcode0108 = adcode0108;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreet_number() {
		return street_number;
	}
	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	
	
}
