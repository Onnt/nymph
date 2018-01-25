package cn.virde.nymph.net.weather;

import cn.virde.nymph.entity.weather.RealtimeWeatherEntity;
import cn.virde.nymph.enums.common.SkyconsConstant;

public class RealtimeWeatherBriefMaker {
	
	private RealtimeWeatherEntity weather ;
	
	private StringBuffer brief ;
	public RealtimeWeatherBriefMaker(RealtimeWeatherEntity weather) {
		this.weather = weather ;
	}
	
	private void calculation() {
		switch(weather.getResult().getSkycon()) {
		case SkyconsConstant.RAIN:
		case SkyconsConstant.SNOW:
		case SkyconsConstant.CLEAR_DAY:
		case SkyconsConstant.CLEAR_NIGHT:
		case SkyconsConstant.CLOUDY:
		case SkyconsConstant.FOG:
		case SkyconsConstant.HAZE:
		case SkyconsConstant.PARTLY_CLOUDY_DAY:
		case SkyconsConstant.PARTLY_CLOUDY_NIGHT:
		case SkyconsConstant.SLEET:
		case SkyconsConstant.WIND:
		}
	}
	
}