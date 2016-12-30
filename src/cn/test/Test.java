package cn.test;

import java.util.Date;

import cn.blacard.nymph.date.ChineseCalendar;
import cn.blacard.nymph.date.ChineseCalendarDeal;
import cn.blacard.nymph.date.NymTime;
import cn.blacard.nymph.date.NymTimeOld;
import cn.blacard.nymph.entity.ConverseGeocodingEntity;
import cn.blacard.nymph.entity.HighPrecisionIpPositioningEntity;
import cn.blacard.nymph.entity.base.LocationEntity;
import cn.blacard.nymph.net.html.HtmlGet;
import cn.blacard.nymph.net.tool.GeocodingTool;
import cn.blacard.nymph.net.tool.HighPrecisionIpPositioningTool;
import cn.blacard.nymph.net.tool.IPTool;
import cn.blacard.nymph.net.weather.Weather;
import net.sf.json.JSONObject;

/**
 * 
 * <h3>title:</h3>
 * <p>测试类</p>
 * @author Blacard
 * @createTime 下午2:21:40
 * @e_mail blacard@163.com
 * @phone 18037170703
 */
public class Test {
	
	/**
	 * 地理位置 转 经纬度
	 * @author Blacard
	 * @create 2016年12月20日 上午7:08:33
	 * @param args
	 */
	public static void main_address_to_location(String[] args) {
//	public static void main(String[] args) {
		LocationEntity location = GeocodingTool.addressToLocation("南翔镇");
		
		ConverseGeocodingEntity entity = GeocodingTool.getConverseGeocodingEntity(location);
		System.out.println("经纬度 ： "+location.toString());
		System.out.println(entity.getResult().getAddressComponent().getStreet());
	}
	/**
	 * 获取天气预报，测试
	 * @author Blacard
	 * @create 2016年12月20日 上午5:06:11
	 * @param args
	 */
//	public static void main_weather(String[] args) {
	public static void main_address_to_weather(String[] args) {
		Weather weather = new Weather("洛阳");
	
		System.out.println(weather.getForecastWeather().getResult().getHourly().getDescription());
		System.out.println(weather.getRealtimeWeather().getResult().getSkycon().toString());
		System.out.println("当前温度："+weather.getRealtimeWeather().getResult().getTemperature()+" ℃");
//		System.out.println(weather.getForecastWeather().getResult().getDaily().getSkycon()[0].getValue());
	}
	
	/**
	 * IP 转 地址
	 * @author Blacard
	 * @create 2016年12月13日 上午11:51:33
	 * @param args
	 */
	public static void main_ip_to_address(String[] args) {
//		HighPrecisionIpPositioningEntity entity = IPTool.getHighPrecisionIpPositioningByIP("58.34.140.86");
//		System.out.println(IPTool.getAddressByIp("115.51.96.159"));
		System.out.println(HighPrecisionIpPositioningTool.getLocationByIp("58.34.140.86").toString());
//		System.out.println(HighPrecisionIpPositioningTool.getLocationByIp("115.51.96as.159").toString());
		HtmlGet get = new HtmlGet();
		String str = get.getPage("http://api.map.baidu.com/highacciploc/v1?qterm=pc&ak=yMOZ0v2ANY6UF0l6CNfVnVae&coord=bd09ll&qcip=116.225.64.220");
		System.out.println(str);
	}
	/**
	 * JSONObject转 Bean测试
	 * @author Blacard
	 * @create 2016年12月13日 上午10:29:00
	 * @param args
	 */
	public static void main_json_to_bean(String[] args) {
		JSONObject hehe = JSONObject.fromObject("{'content':{'location':{'lat':31.225112,'lng':121.443857},'locid':'8a6e357f270e6ef2688ab1a34ef2b89e','radius':30,'confidence':1.0},'result':{'error':161,'loc_time':'2016-12-13 10:07:34'}}");
		HighPrecisionIpPositioningEntity entity = (HighPrecisionIpPositioningEntity)JSONObject.toBean(hehe,HighPrecisionIpPositioningEntity.class);
		System.out.println(entity.getResult().getError());
	}
	/**
	 * 农历，公历转换测试
	 * @author Blacard
	 * @create 2016年12月13日 上午10:28:25
	 * @param args
	 */
	public static void main_chinese_calendar(String[] args) {
		Date solar = ChineseCalendar.toSunDate("2017-05-26");
		System.out.println(NymTimeOld.toString(solar));
	}
	
	public static void main(String[] args) {
		NymTime time = new NymTime("2016-12-30 20:38:49");
		System.out.println(time.getDate());
	}
}