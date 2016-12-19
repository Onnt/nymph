package cn.blacard.nymph.net.weather;

import cn.blacard.nymph.entity.weather.ForecastWeatherEntity;
import cn.blacard.nymph.entity.weather.RealtimeWeatherEntity;
import cn.blacard.nymph.net.html.HtmlGet;
import net.sf.json.JSONObject;

/**
 * 
 * @author Blacard
 * @联系方式  邮箱：blacard@163.com <br/> 手机：18037170703
 * @Create 2016年12月18日 下午8:05:10
 */
public class WeatherDeal {
	
	public static void main(String[] args) {
		WeatherDeal deal = new WeatherDeal(); 
		HtmlGet get = new HtmlGet();
		String forecastWeather = get.getPage(deal.createRequestUrl("25.1552,121.6544","forecast.json"));
		System.out.println(forecastWeather);
	}

	/**
	 * 根据经纬度获取实时天气
	 * @author Blacard
	 * @create 2016年12月18日 下午8:05:14
	 * @return
	 */
	protected RealtimeWeatherEntity getRealtimeWeather(String location){
		HtmlGet get = new HtmlGet();
		String realtimeWeather = get.getPage(createRequestUrl(location,"realtime.json"));
		return (RealtimeWeatherEntity)JSONObject.toBean(
						JSONObject.fromObject(realtimeWeather),
						RealtimeWeatherEntity.class);
	}

	/**
	 * 根据经纬度获取天气预报
	 * @author Blacard
	 * @create 2016年12月19日 上午7:07:48
	 * @param location
	 * @return
	 */
	public  ForecastWeatherEntity getForecastWeather(String location) {
		HtmlGet get = new HtmlGet();
		String forecastWeather = get.getPage(createRequestUrl(location,"forecast.json"));
		return (ForecastWeatherEntity)JSONObject.toBean(
						JSONObject.fromObject(forecastWeather),
						ForecastWeatherEntity.class);
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
				"https://api.caiyunapp.com/v2/",
				"=1yScNbEm4R2rhE-",
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
