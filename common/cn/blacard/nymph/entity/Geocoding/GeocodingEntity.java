package cn.blacard.nymph.entity.Geocoding;


import cn.blacard.nymph.common.base.BaseEntity;
import cn.blacard.nymph.entity.Geocoding.GeocodingResultEntity;

public class GeocodingEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1214903758427652747L;
	
	private int status;
	private GeocodingResultEntity result;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public GeocodingResultEntity getResult() {
		return result;
	}
	public void setResult(GeocodingResultEntity result) {
		this.result = result;
	}
	
	
	
}
