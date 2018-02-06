package cn.virde.nymph.net.weather;

import java.io.IOException;

import cn.virde.nymph.entity.base.LocationEntity;
import cn.virde.nymph.entity.weather.RealtimeWeatherEntity;
import cn.virde.nymph.exception.LocationException;

/**
 * 
 * @author Virde
 * @time 2018年1月25日 上午10:18:03
 */
public class RealtimeWeather{
	
	private RealtimeWeatherEntity realtimeWeather ;
	private String address ;
	
	public RealtimeWeather(String addressOrIP) throws LocationException, IOException {
		Weather weather = new Weather(addressOrIP);
		realtimeWeather = weather.getRealtimeWeather();
		this.address = weather.getAddress() ;
	}

	public RealtimeWeather(LocationEntity location) throws IOException, LocationException {
//		this.address = Nym.geocoding.getConverseGeocodingEntity(location).getResult().getAddressComponent().getCity();
		Weather weather = new Weather(location);
		realtimeWeather = weather.getRealtimeWeather();
		this.address = weather.getAddress();
	}

	public RealtimeWeather(double lng, double lat) throws IOException, LocationException {
		Weather weather = new Weather(new LocationEntity(lng, lat));
		realtimeWeather = weather.getRealtimeWeather();
		this.address = weather.getAddress();
	}
	
	public String getBrief() throws IOException, LocationException {
		return address + new RealtimeWeatherBriefMaker(realtimeWeather).getBrief();
	} 
	
	public RealtimeWeatherEntity getRealtimeWeather() {
		return realtimeWeather;
	}

	public void setRealtimeWeather(RealtimeWeatherEntity realtimeWeather) {
		this.realtimeWeather = realtimeWeather;
	}

	public static void main(String[] args) throws LocationException, IOException {
		String str = new RealtimeWeather(123.6181640625,25.7998911821).getBrief();
		System.out.println(str);
	}
}
