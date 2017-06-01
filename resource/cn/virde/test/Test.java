package cn.virde.test;

import java.io.IOException;

import cn.virde.nymph.Nym;

public class Test{
	
	public static void main(String[] args) throws IOException {
		
		
		String sunRise = Nym.getWeather("上海市").getForecastWeather().getResult().getDaily().getAstro()[0].getSunset().getTime();
		
		System.out.println(sunRise);
		
	}
	
}
