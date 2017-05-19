package cn.blacard.nymph.entity.Geocoding;

import cn.blacard.nymph.common.base.BaseEntity;
import cn.blacard.nymph.entity.Geocoding.ConverseGeocodingResultEntity;

public class ConverseGeocodingEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8973064364559550319L;
	
	private int status;
	
	private ConverseGeocodingResultEntity result;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ConverseGeocodingResultEntity getResult() {
		return result;
	}

	public void setResult(ConverseGeocodingResultEntity result) {
		this.result = result;
	}

	public ConverseGeocodingEntity(int status, ConverseGeocodingResultEntity result) {
		super();
		this.status = status;
		this.result = result;
	}

	public ConverseGeocodingEntity() {
		super();
	}
	
	
}
