package cn.blacard.nymph.net.weather;

import cn.blacard.nymph.entity.base.LocationEntity;
import cn.blacard.nymph.entity.weather.RealtimeWeatherEntity;

/**
 * 获取天气状况
 * @author Blacard
 * @联系方式  邮箱：blacard@163.com <br/> 手机：18037170703
 * @Create 2016年12月18日 下午7:36:31
 */
public class Weather extends WeatherDeal{
	
	private String location;

	public Weather(LocationEntity location) {
		this.location = location.toStringLngLat();
	}
	
	public Weather(String location){
		this.location = location;
	}
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月18日 下午8:01:39
	 * @return
	 */
	public RealtimeWeatherEntity getRealtimeWeather(){
		return this.getRealtimeWeather(location);
	}
	
	
	
	
	public static void main(String[] args) {

	}
}
