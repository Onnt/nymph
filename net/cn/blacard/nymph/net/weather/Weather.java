package cn.blacard.nymph.net.weather;

import cn.blacard.nymph.entity.base.LocationEntity;
import cn.blacard.nymph.net.tool.GeocodingTool;
import cn.blacard.nymph.entity.ForecastWeatherEntity;
import cn.blacard.nymph.entity.RealtimeWeatherEntity;

/**
 * 获取天气状况
 * @author Blacard
 * @联系方式  邮箱：blacard@163.com <br/> 手机：18037170703
 * @Create 2016年12月18日 下午7:36:31
 */
public class Weather extends WeatherDeal{
	
	private LocationEntity location;

	/**
	 * 
	 * @param location 经纬度
	 */
	public Weather(LocationEntity location) {
		this.location = location;
	}
	
	/**
	 * 赋予经纬度
	 * @param location 经纬度 sample:"121.6544,25.1552"
	 */
	public Weather(String address){
		this.location = GeocodingTool.addressToLocation(address);
	}
	/**
	 * 获取实时天气
	 * @author Blacard
	 * @create 2016年12月18日 下午8:01:39
	 * @return
	 */
	public RealtimeWeatherEntity getRealtimeWeather(){
		RealtimeWeatherEntity entity = this.getRealtimeWeather(location);
		if(entity.getStatus().equals("ok")){
			return entity;
		}else{
			System.out.println("Weaher - getRealtimeWeather 获取实时天气失败");
			return null;
		}
	}
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月18日 下午8:01:39
	 * @return
	 */
	public ForecastWeatherEntity getForecastWeather(){
		ForecastWeatherEntity entity = this.getForecastWeather(location);
		if(entity.getStatus().equals("ok")){
			return entity;
		}else{
			System.out.println("Weaher - getForecastWeather 获取实时天气失败");
			return null;
		}
	}
}
