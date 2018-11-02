package cn.virde.nymph.entity.Geocoding;


import cn.virde.nymph.entity.Geocoding.GeocodingResultEntity;
import cn.virde.nymph.entity.base.BaseEntity;

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
