package cn.virde.nymph.net.weather;

import java.io.IOException;

import cn.virde.nymph.entity.weather.RealtimeWeatherEntity;
import cn.virde.nymph.enums.common.SkyconsConstant;
import cn.virde.nymph.exception.LocationException;

public class RealtimeWeatherBriefMaker {
	
	private RealtimeWeatherEntity weather ;
	
	private StringBuffer brief = new StringBuffer();
	
	public RealtimeWeatherBriefMaker(RealtimeWeatherEntity weather) {
		this.weather = weather ;
		calculation();
	}
	
	private void calculation() {
		switch(weather.getResult().getSkycon()) {
		case SkyconsConstant.RAIN:
		case SkyconsConstant.SNOW:
			brief.append("当前正在下");
			brief.append(weather.getResult().getSkyconName()+"，");
			brief.append("气温："+weather.getResult().getTemperature() + "度。");
			brief.append(weather.getResult().getWind().getDescription());
			break;
		case SkyconsConstant.CLEAR_DAY:
		case SkyconsConstant.CLEAR_NIGHT:
			brief.append("目前天气晴朗，");
			brief.append("气温："+weather.getResult().getTemperature() + "度。");
			brief.append(weather.getResult().getWind().getDescription());
			break;
		case SkyconsConstant.CLOUDY:
			brief.append("目前是阴天，");
			brief.append("气温："+weather.getResult().getTemperature() + "度。");
			brief.append(weather.getResult().getWind().getDescription());
			break;
		case SkyconsConstant.FOG:
			brief.append("当前有雾，");
			brief.append("气温："+weather.getResult().getTemperature() + "度。");
			brief.append(weather.getResult().getWind().getDescription());
			break;
		case SkyconsConstant.HAZE:
			brief.append("当前是雾霾天气，");
			brief.append("气温："+weather.getResult().getTemperature() + "度。");
			brief.append(weather.getResult().getWind().getDescription());
			break;
		case SkyconsConstant.PARTLY_CLOUDY_DAY:
		case SkyconsConstant.PARTLY_CLOUDY_NIGHT:
			brief.append("当前是多云天气，");
			brief.append("气温："+weather.getResult().getTemperature() + "度。");
			brief.append(weather.getResult().getWind().getDescription());
			break;
		case SkyconsConstant.SLEET:
			brief.append("当前有冻雨");
			brief.append("气温："+weather.getResult().getTemperature() + "度。");
			brief.append(weather.getResult().getWind().getDescription());
			break;
		case SkyconsConstant.WIND:
			brief.append("当前是大风天气，风力等级：");
			brief.append(weather.getResult().getWind().getDescription());
			brief.append("。气温："+weather.getResult().getTemperature() + "度。");
			break;
		}
	}
	
	public String getBrief() {
		return brief.toString();
	}

}