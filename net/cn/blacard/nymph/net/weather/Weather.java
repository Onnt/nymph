package cn.blacard.nymph.net.weather;

import cn.blacard.nymph.entity.ForecastWeatherEntity;
import cn.blacard.nymph.entity.RealtimeWeatherEntity;
import cn.blacard.nymph.entity.base.LocationEntity;
import cn.blacard.nymph.net.tool.GeocodingTool;
import cn.virde.nymph.Nym;

import java.io.IOException;

/**
 * <h1>获取指定地点的天气状况</h1>
 * <p>采用的是彩云天气的API<br>
 * <a href="http://wiki.swarma.net/index.php/%E5%BD%A9%E4%BA%91%E5%A4%A9%E6%B0%94API/v2">官方文档</a><br/>
 *  官方文档更新也不是很及时，只能当作参考，具体以返回数据结构为准。
 * </p>
 * @author Blacard
 * @联系方式  邮箱：blacard@163.com <br/> 手机：18037170703
 * @Create 2016年12月18日 下午7:36:31
 */
public class Weather extends WeatherDeal{
	
	//要获取天气的地理位置信息
	private LocationEntity location;

	/**
	 * 获取该经纬度的天气状况
	 * @param location 经纬度
	 */
	public Weather(LocationEntity location) {
		this.location = location;
	}
	/**
	 * 获取指定经纬度的天气状况
	 * @param lng  经度
	 * @param lat  纬度
	 */
	public Weather(double lng,double lat){
		this.location.setLng(lng);
		this.location.setLat(lat);
	}
	/**
	 * 获取该地点的天气状况
	 * @param location 经纬度 sample:"121.6544,25.1552"
	 * @throws IOException 
	 */
	public Weather(String address) throws IOException{
		//将自然语言描述的地点 转换成 经纬度
		this.location = Nym.geocoding.addressToLocation(address);
	}
	/**
	 * 获取实时天气
	 * @author Blacard
	 * @create 2016年12月18日 下午8:01:39
	 * @return 返回所有关于实时天气的信息
	 * @throws IOException 
	 */
	public RealtimeWeatherEntity getRealtimeWeather() throws IOException{
		RealtimeWeatherEntity entity = this.getRealtimeWeather(location);
		if(entity.getStatus().equals("ok")){
			return entity;
		}else{
			System.out.println("Weaher - getRealtimeWeather 获取实时天气失败 \n"+entity.toErrorString());
			return null;
		}
	}
	/**
	 * 获取预报天气
	 * @author Blacard
	 * @create 2016年12月18日 下午8:01:39
	 * @return 返回所有关于预报天气的信息
	 * @throws IOException 
	 */
	public ForecastWeatherEntity getForecastWeather() throws IOException{
		ForecastWeatherEntity entity = this.getForecastWeather(location);
		if(entity.getStatus().equals("ok")){
			return entity;
		}else{
			System.out.println("Weaher - getForecastWeather 获取实时天气失败 \n "+entity.toErrorString());
			return null;
		}
	}
}
