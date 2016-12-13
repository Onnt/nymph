package cn.blacard.nymph.entity.HighPrecisionIpPositioning;

import cn.blacard.nymph.base.BaseEntity;

public class ResultEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2686314813823223624L;
	
	private int error;
	
	private String loc_time;


	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public String getLoc_time() {
		return loc_time;
	}

	public void setLoc_time(String loc_time) {
		this.loc_time = loc_time;
	}

	public ResultEntity(int error, String loc_time) {
		super();
		this.error = error;
		this.loc_time = loc_time;
	}

	public ResultEntity() {
		super();
	}
	
	

}
