package cn.virde.nymph.net.weather;

import java.io.IOException;

import cn.virde.nymph.Nym;
import cn.virde.nymph.entity.base.LocationEntity;
import cn.virde.nymph.entity.weather.RealtimeWeatherEntity;
import cn.virde.nymph.exception.LocationException;

/**
 * 
 * @author Virde
 * @time 2018年1月25日 上午10:18:03
 */
public class RealtimeWeather{
	
	private RealtimeWeatherEntity bean ;
	private String address ;
	
	public RealtimeWeather(String address) throws LocationException, IOException {
		this.address = address ;
		Weather weather = new Weather(address);
		bean = weather.getRealtimeWeather();
	}

	public RealtimeWeather(LocationEntity location) throws IOException, LocationException {
		this.address = Nym.geocoding.getConverseGeocodingEntity(location).getResult().getAddressComponent().getCity();
		Weather weather = new Weather(location);
		bean = weather.getRealtimeWeather();
	}

	public RealtimeWeather(double lng, double lat) throws IOException, LocationException {
		this(new LocationEntity(lng, lat));
	}
	
	public String getBrief() {
		System.out.println(address);
		
		return address + "目前" +bean.getResult().getSkycon();
	}
	
	public static void main(String[] args) throws LocationException, IOException {
		System.out.println(Nym.geocoding.addressToLocation("南阳").toStringLngLat());
		new RealtimeWeather(112.5428419005123,33.0114195691165).getBrief();
	}
}
