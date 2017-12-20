package cn.virde.nymph.net.weather;

import java.io.IOException;

import com.alibaba.fastjson.JSON;

import cn.virde.nymph.Nym;
import cn.virde.nymph.config.Config;
import cn.virde.nymph.entity.base.LocationEntity;
import cn.virde.nymph.entity.weather.ForecastWeatherEntity;
import cn.virde.nymph.entity.weather.RealtimeWeatherEntity;

/**
 * 
 * @author Blacard
 * @联系方式  邮箱：blacard@163.com <br/> 手机：18037170703
 * @Create 2016年12月18日 下午8:05:10
 */
public class WeatherDeal {	
	/**
	 * 根据经纬度获取实时天气
	 * @author Blacard
	 * @create 2016年12月20日 上午6:14:15
	 * @param location 经纬度 sample:"121.6544,25.1552"
	 * @return
	 * @throws IOException 
	 */
	protected RealtimeWeatherEntity getRealtimeWeather(LocationEntity location) throws IOException{
		String realtimeWeather = Nym.http.get(createRequestUrl(location,"realtime.json"));
		
		return JSON.parseObject(realtimeWeather,RealtimeWeatherEntity.class);
	}

	/**
	 * 根据经纬度获取天气预报
	 * @author Blacard
	 * @create 2016年12月19日 上午7:07:48
	 * @param location 经纬度 sample:"121.6544,25.1552"
	 * @return
	 * @throws IOException 
	 */
	protected ForecastWeatherEntity getForecastWeather(LocationEntity location) throws IOException{
		String forecastWeather = Nym.http.get(createRequestUrl(location,"forecast.json"));
		return JSON.parseObject(forecastWeather,ForecastWeatherEntity.class);
	}
	
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月20日 上午7:17:31
	 * @param location
	 * @param requestType
	 * @return
	 */
	private String createRequestUrl(LocationEntity location,String requestType){
		return createRequestUrl(location.toStringLngLat(), requestType);
	}

	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月18日 下午8:10:49
	 * @param location
	 * @param requestType
	 * @return
	 */
	private String createRequestUrl(String location,String requestType){
		return createRequestUrl(
				Config.weather.url,
				Config.weather.key,
				location,
				requestType);
	}
	
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月18日 下午8:09:30
	 * @param url
	 * @param key
	 * @param location
	 * @param requestType
	 * @return
	 */
	private String createRequestUrl(String url,String key,String location,String requestType){
		StringBuffer sb = new StringBuffer();
		sb.append(url);
		sb.append(key);
		sb.append("/"+location);
		sb.append("/"+requestType);
		return sb.toString();
	}
 }
