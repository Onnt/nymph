package cn.blacard.qiu.weather.info.base;

import java.util.Date;

import cn.blacard.qiu.weather.info.RealTimeWeatherResultInfo;
import cn.blacard.qiu.weather.info.sub.LocationInfo;

/**
@author  Blacard
邮箱：blacard@163.com
@date 创建时间：2016年6月29日 下午10:26:51 
  */
public class BaseWeatherInfo extends BaseInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2606746959222967023L;

	
	/**
	 * 状态
	 */
	private String status;
	
	/**
	 * 目前只支持简体中文（zh_CN、zh_SG）、繁体中文（zh_TW、zh_HK），英语（en_US、en_GB）在测试中
	 */
	private String lang;
	
	/**
	 * 服务器时间
	 */
	private Date server_time;
	/**
	 * 时区的偏移秒数，如东八区就是 28800 秒，使用秒是为了支持像尼泊尔这样的差 5 小时 45 分钟的地区，它们有非整齐的偏移量
	 */
	private int tzshift;
	/**
	 * 经纬度
	 */
	private LocationInfo location;
	 /**
	  * 目前只支持米制（metric）和科学计量法（SI），英制还有待开发
	  */
	private String unit;
	/**
	 * 结果
	 */
	private RealTimeWeatherResultInfo result;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public Date getServer_time() {
		return server_time;
	}
	public void setServer_time(Date server_time) {
		this.server_time = server_time;
	}
	public int getTzshift() {
		return tzshift;
	}
	public void setTzshift(int tzshift) {
		this.tzshift = tzshift;
	}
	public LocationInfo getLocation() {
		return location;
	}
	public void setLocation(LocationInfo location) {
		this.location = location;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public RealTimeWeatherResultInfo getResult() {
		return result;
	}
	public void setResult(RealTimeWeatherResultInfo result) {
		this.result = result;
	}
}
