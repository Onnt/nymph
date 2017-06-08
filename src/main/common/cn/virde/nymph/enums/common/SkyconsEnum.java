package cn.virde.nymph.enums.common;

public enum SkyconsEnum {
	
	CLEAR_DAY("晴天"),
	CLEAR_NIGHT("晴夜"),
	PARTLY_CLOUDY_DAY("多云"),
	PARTLY_CLOUDY_NIGHT("多云"),
	CLOUDY("阴"),
	RAIN("雨"),
	SLEET("冻雨"),
	SNOW("雪"),
	WIND("风"),
	FOG("雾"),
	HAZE("霾");
	
	private String skycon;
	
	private SkyconsEnum(String skycon){
		this.skycon = skycon;
	}

	public String getSkycon() {
		return skycon;
	}

	public void setSkycon(String skycon) {
		this.skycon = skycon;
	}
}
