package cn.blacard.qiu.weather.info.sub;

import cn.blacard.qiu.weather.info.base.BaseInfo;

/**
@author  Blacard
邮箱：blacard@163.com
@date 创建时间：2016年6月29日 下午9:30:05 
  */
public class LocalPrecipitationInfo extends BaseInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2629232758283248882L;
	
	
	private String status;
	/**
	 * 降水强度
	 */
	private double intensity;
	/**
	 * 数据源
	 */
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
	

}
