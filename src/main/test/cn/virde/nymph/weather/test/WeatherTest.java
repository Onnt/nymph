package cn.virde.nymph.weather.test;

import java.util.Date;

import org.junit.Test;

import cn.virde.nymph.Nym;
import cn.virde.nymph.entity.base.LocationEntity;
import cn.virde.nymph.entity.weather.forecast.AstroEntity;
import cn.virde.nymph.net.weather.Weather;

public class WeatherTest {
	
	@Test
	public void getSunState(){
		String ip = "180.169.14.34";
		LocationEntity location = Nym.position.getLocationByIp(ip);
		Weather weather = new Weather(location);
		AstroEntity[] astro = weather.getForecastWeather().getResult().getDaily().getAstro();
		
		Date now = Nym.time.toDate("2017-6-8 21:59:11");
//		Date now = new Date();
		
		Date sunrise = Nym.time.toDate(astro[0].getDate()+" "+astro[0].getSunrise().getTime()+":00");
		Date sunset = Nym.time.toDate(astro[0].getDate()+" "+astro[0].getSunset().getTime()+":00");
		Date tomorrow = Nym.time.toDate(astro[1].getDate()+" "+astro[1].getSunset().getTime()+":00");
		
		if(now.before(sunrise)){
			long diff = sunrise.getTime() - now.getTime() ; 
			System.out.println("日出将在"+stampToNatural(diff)+"后");
		}else if(now.before(sunset)){
			System.out.println("日出后，日落前……");
			long diff = sunset.getTime() - now.getTime();
			System.out.println("将于" + stampToNatural(diff)+"后日落");
		}else{
			System.out.println("日落后……");
			long diff = tomorrow.getTime() - now.getTime() ; 
			System.out.println("太阳将在"+stampToNatural(diff)+"后上升");
			
		}
	}

    private String stampToNatural(long stamp){
    	long s = stamp/1000;
    	if(s < 60){
    		return s+"秒";
    	}else if( s < 60*60){
    		return s/60 + "分 " + s%60 + "秒"; 
    	}else if( s < 60*60*24){
    		return s/(60*60) + "小时 " + (s%(60*60))/60 + "分"; 
    	}else{
    		return s/(60*60*24) + "天 " + (s%(60*60*24))/(60*60) +"小时" ;
    	}
    }
}
