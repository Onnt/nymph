package cn.virde.nymph.entity.Geocoding;

import java.util.List;

import cn.virde.nymph.entity.base.BaseEntity;
import cn.virde.nymph.entity.base.LocationEntity;

public class ConverseGeocodingResultEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2991319379307468429L;
	
	private LocationEntity location;
	private String formatted_address;
	private String business;
	private AddressComponentEntity addressComponent;
	
	private List<String> pois;
	
	private List<String> poiRegions;
	private String sematic_description;
	private int cityCode;
	
	

	public AddressComponentEntity getAddressComponent() {
		return addressComponent;
	}

	public void setAddressComponent(AddressComponentEntity addressComponent) {
		this.addressComponent = addressComponent;
	}

	public LocationEntity getLocation() {
		return location;
	}

	public void setLocation(LocationEntity location) {
		this.location = location;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}
	public List<String> getPois() {
		return pois;
	}

	public void setPois(List<String> pois) {
		this.pois = pois;
	}



	public List<String> getPoiRegions() {
		return poiRegions;
	}

	public void setPoiRegions(List<String> poiRegions) {
		this.poiRegions = poiRegions;
	}

	public String getSematic_description() {
		return sematic_description;
	}

	public void setSematic_description(String sematic_description) {
		this.sematic_description = sematic_description;
	}

	public int getCityCode() {
		return cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public ConverseGeocodingResultEntity(LocationEntity location, String formatted_address, String business, int cityCode) {
		super();
		this.location = location;
		this.formatted_address = formatted_address;
		this.business = business;
		this.cityCode = cityCode;
	}

	public ConverseGeocodingResultEntity() {
		super();
	}
}
