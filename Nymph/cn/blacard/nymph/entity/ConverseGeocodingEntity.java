package cn.blacard.nymph.entity;

import cn.blacard.nymph.base.BaseEntity;
import cn.blacard.nymph.entity.ConverseGeocoding.ResultEntity;

public class ConverseGeocodingEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8973064364559550319L;
	
	private int status;
	
	private ResultEntity result;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ResultEntity getResult() {
		return result;
	}

	public void setResult(ResultEntity result) {
		this.result = result;
	}

	public ConverseGeocodingEntity(int status, ResultEntity result) {
		super();
		this.status = status;
		this.result = result;
	}

	public ConverseGeocodingEntity() {
		super();
	}
	
	
}
