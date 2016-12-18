package cn.blacard.nymph.entity.weather;

import cn.blacard.nymph.base.BaseEntity;

public class LocalEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5878113543064581874L;
	private String status;
	private double intensity;
	private String datasource;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getIntensity() {
		return intensity;
	}
	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	public LocalEntity(String status, double intensity, String datasource) {
		super();
		this.status = status;
		this.intensity = intensity;
		this.datasource = datasource;
	}
	public LocalEntity() {
		super();
	}
	
}
