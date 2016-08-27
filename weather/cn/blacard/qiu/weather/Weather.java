package cn.blacard.qiu.weather;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.blacard.nymph.date.NymTime;
import cn.blacard.nymph.net.html.HtmlGet;
import cn.blacard.qiu.weather.Exception.LngOrLatNullpointException;
import cn.blacard.qiu.weather.enums.SkyconsEnum;
import cn.blacard.qiu.weather.info.ForecastWeatherInfo;
import cn.blacard.qiu.weather.info.RealTimeWeatherInfo;
import cn.blacard.qiu.weather.info.RealTimeWeatherResultInfo;
import cn.blacard.qiu.weather.info.base.BaseWeatherInfo;
import cn.blacard.qiu.weather.info.sub.LocalPrecipitationInfo;
import cn.blacard.qiu.weather.info.sub.LocationInfo;
import cn.blacard.qiu.weather.info.sub.NearestPrecipitationInfo;
import cn.blacard.qiu.weather.info.sub.WindInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ʹ�ñ���֮ǰ����Ҫ��һ����ַ��LocationInfo��
 * 
 * 
 * @author Blacard ���䣺blacard@163.com
 * @date ����ʱ�䣺2016��6��29�� ����9:43:36
 */
public class Weather {
	private String token = "=1yScNbEm4R2rhE-";
	private LocationInfo location;
	
	private final static String WEATHER_REALTIME = "realtime";
	private final static String WEATHER_FOREAST = "foreast";
	
	public Weather(double lng,double lat){
		location = new LocationInfo(lng,lat);
	}
	public Weather(LocationInfo location){
		this.location = location;
	}
	public Weather(){
		;
	}
	
	/**
	 * 创建请求链接
	 * @return 请求链接
	 */
	public String createRequestUrl(String weather){
		if(location==null)
			try {
				throw new LngOrLatNullpointException();
			} catch (LngOrLatNullpointException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(weather.equals(WEATHER_REALTIME))
			return "https://api.caiyunapp.com/v2/"+token+"/"+location.getLng()+","+location.getLat()+"/realtime.json";
		else
			return "https://api.caiyunapp.com/v2/"+token+"/"+location.getLng()+","+location.getLat()+"/forecast.json";
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getJsonResult(String weather){
		return new HtmlGet().getData(createRequestUrl(weather));
	}
	
	/**
	 * 
	 * @return
	 */
	public RealTimeWeatherInfo getRealTimeWeather(){

		String result = getJsonResult(WEATHER_REALTIME);
		
		RealTimeWeatherInfo info = new RealTimeWeatherInfo();
		JSONObject jsonObj = JSONObject.fromObject(result);
		info.setStatus(jsonObj.getString("status"));
		info.setLang(jsonObj.getString("lang"));
		info.setServer_time(NymTime.timestampToDate(jsonObj.getString("server_time")));
		info.setTzshift(jsonObj.getInt("tzshift"));

		info.setLocation(getLocationInfo(jsonObj.getJSONArray("location")));
		
		info.setUnit(jsonObj.getString("unit"));
		
		info.setResult(getRealTimeWeatherResult(jsonObj.getJSONObject("result")));
		
		return info;
	}
	
	/**
	 * 
	 * @return
	 */
	public ForecastWeatherInfo getForecastWeather(){
		String result = getJsonResult(WEATHER_REALTIME);

		ForecastWeatherInfo forecast = new ForecastWeatherInfo();
		JSONObject jsonObj = JSONObject.fromObject(result);
		forecast.setStatus(jsonObj.getString("status"));
		forecast.setLang(jsonObj.getString("lang"));
		forecast.setServer_time(NymTime.timestampToDate(jsonObj.getString("server_time")));
		forecast.setTzshift(jsonObj.getInt("tzshift"));
		forecast.setLocation(getLocationInfo(jsonObj.getJSONArray("location")));
		forecast.setUnit(jsonObj.getString("metric"));
		forecast.setResult(null);
		return null;
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		Weather wea = new Weather(121.483f,31.2333f);
		System.out.println("实时天气："+ wea.getJsonResult(WEATHER_REALTIME));
		System.out.println("test : "+wea.getRealTimeWeather().getResult().getNearPrecipitation().getDistance());
		
	}
	
	
	
	
	private  LocationInfo getLocationInfo (JSONArray json){
		LocationInfo location =  new LocationInfo();
		location.setLng(json.getInt(0));
		location.setLat(json.getInt(1));
		return location;
	}
	
	private RealTimeWeatherResultInfo getRealTimeWeatherResult(JSONObject json){
		RealTimeWeatherResultInfo result = new RealTimeWeatherResultInfo();
		result.setStatus(json.getString("status"));
		result.setTemperature((double) json.get("temperature"));
		result.setSkycon(SkyconsEnum.valueOf(json.getString("skycon")));
		result.setPm25(json.getInt("pm25"));
		result.setCloudrate((double) json.get("cloudrate"));
		result.setHumidity(json.getDouble("humidity"));
		result.setNearPrecipitation(getNearPrecitapition(json.getJSONObject("precipitation").getJSONObject("nearest")));
		result.setLocalPrecipition(getLocalPrecipitation(json.getJSONObject("precipitation").getJSONObject("local")));
		result.setWind(getWind(json.getJSONObject("wind")));
		return result;
	}
	
	private NearestPrecipitationInfo getNearPrecitapition(JSONObject json){
		NearestPrecipitationInfo near = new NearestPrecipitationInfo();
		near.setStatus(json.getString("status"));
		near.setDistance(json.getDouble("distance"));
		near.setIntensity(json.getDouble("intensity"));
		return near;
	}
	
	private LocalPrecipitationInfo getLocalPrecipitation(JSONObject json){
		LocalPrecipitationInfo local = new LocalPrecipitationInfo();
		local.setStatus(json.getString("status"));
		local.setIntensity(json.getDouble("intensity"));
		local.setDatasource(json.getString("datasource"));		
		return local;
	}
	
	private WindInfo getWind(JSONObject json){
		WindInfo wind = new WindInfo();
		wind.setDirection(json.getDouble("direction"));
		wind.setSpeed(json.getDouble("speed"));
		return wind;
	}
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LocationInfo getLocation() {
		return location;
	}
	public void setLocation(LocationInfo location) {
		this.location = location;
	}
	
	
}


































