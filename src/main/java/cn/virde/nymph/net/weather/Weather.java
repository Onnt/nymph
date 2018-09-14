package cn.virde.nymph.net.weather;

import cn.virde.nymph.Nym;
import cn.virde.nymph.entity.base.LocationEntity;
import cn.virde.nymph.entity.weather.ForecastWeatherEntity;
import cn.virde.nymph.entity.weather.RealtimeWeatherEntity;
import cn.virde.nymph.exception.LocationException;

import java.io.IOException;

/**
 * <h1>获取指定地点的天气状况</h1>
 * <p>采用的是彩云天气的API<br>
 * <a href="http://wiki.swarma.net/index.php/%E5%BD%A9%E4%BA%91%E5%A4%A9%E6%B0%94API/v2">官方文档</a>
 *  官方文档更新也不是很及时，只能当作参考，具体以返回数据结构为准。
 * </p>
 * @author Blacard
 
 * 2016年12月18日 下午7:36:31
 */
public class Weather extends WeatherDeal{
	
	//要获取天气的地理位置信息
	private LocationEntity location;
	
	private String address ; 
	/**
	 * 获取该经纬度的天气状况
	 * @param location 经纬度
	 * @throws IOException  异常
	 * @throws LocationException  异常
	 */
	public Weather(LocationEntity location) throws LocationException, IOException {
		this.location = location;
		this.address = Nym.geocoding.getConverseGeocodingEntity(location).getResult().getAddressComponent().getCity();
	}
	/**
	 * 可以同时接受IP地址和自然语言描述作为位置
	 * 获取该地点的天气状况
	 * @param addressOrIp 经纬度 sample:"121.6544,25.1552"
	 * @throws LocationException  异常
	 * @throws IOException  异常
	 */
	public Weather(String addressOrIp) throws LocationException, IOException{
		if(Nym.string.isIP(addressOrIp)){
			this.location = Nym.position.getLocationByIp(addressOrIp);
			this.address = Nym.geocoding.getConverseGeocodingEntity(location).getResult().getAddressComponent().getCity();
		}else{
			//将自然语言描述的地点 转换成 经纬度
			this.location = Nym.geocoding.addressToLocation(addressOrIp);
			this.address = addressOrIp ;
		}
	}
	/**
	 * 获取指定经纬度的天气状况
	 * @param lng  经度
	 * @param lat  纬度
	 * @throws IOException  异常
	 * @throws LocationException  异常
	 */
	public Weather(double lng,double lat) throws LocationException, IOException{
		this.location.setLng(lng);
		this.location.setLat(lat);
		this.address = Nym.geocoding.getConverseGeocodingEntity(location).getResult().getAddressComponent().getCity();
	}
	/**
	 * 获取实时天气
	 * @author Blacard
	 * 2016年12月18日 下午8:01:39
	 * @return 返回 返回所有关于实时天气的信息
	 * @throws IOException  异常
	 */
	public final RealtimeWeatherEntity getRealtimeWeather() throws IOException{
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
	 * 2016年12月18日 下午8:01:39
	 * @return 返回 返回所有关于预报天气的信息
	 * @throws IOException  异常
	 */
	public final ForecastWeatherEntity getForecastWeather() throws IOException{
		ForecastWeatherEntity entity = this.getForecastWeather(location);
		if(entity.getStatus().equals("ok")){
			return entity;
		}else{
			System.out.println("Weaher - getForecastWeather 获取实时天气失败 \n "+entity.toErrorString());
			return null;
		}
	}
	
	public LocationEntity getLocation() {
		return location;
	}
	public String getAddress() {
		return address;
	}
	
}
