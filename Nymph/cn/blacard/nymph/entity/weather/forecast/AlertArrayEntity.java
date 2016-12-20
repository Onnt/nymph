package cn.blacard.nymph.entity.weather.forecast;

import cn.blacard.nymph.base.BaseEntity;

public class AlertArrayEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1427522096424686322L;
	
	private String status;
	
	private String code;
	
	private String description;
	
	private String pubdate;
	
	private String location;
	
	private double[] bound_coord;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double[] getBound_coord() {
		return bound_coord;
	}

	public void setBound_coord(double[] bound_coord) {
		this.bound_coord = bound_coord;
	}

	public AlertArrayEntity(String status, String code, String description, String pubdate, String location,
			double[] bound_coord) {
		super();
		this.status = status;
		this.code = code;
		this.description = description;
		this.pubdate = pubdate;
		this.location = location;
		this.bound_coord = bound_coord;
	}

	public AlertArrayEntity() {
		super();
	}
	
	
	
}
