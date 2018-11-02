package cn.virde.nymph.entity.Geocoding;

import cn.virde.nymph.Nym;
import cn.virde.nymph.entity.Geocoding.ConverseGeocodingResultEntity;
import cn.virde.nymph.entity.base.BaseEntity;

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
	
	@Override
	public String toString() {
		return Nym.json.objectToJsonString(this);
	}
}
