package cn.virde.nymph.net.weather;

import cn.virde.nymph.Nym;
import cn.virde.nymph.enums.common.SkyconsEnum;

/**
 * 
 * @author Virde
 * @time 2018年1月25日 上午11:02:26
 */
public class Skycon {
	private SkyconsEnum skycon ;
	
	private String descript ;
	
	public Skycon(SkyconsEnum skycon) {
		this.skycon = skycon ;
		calculation();
	}
	public void calculation() {
		switch(skycon) {
		case CLEAR_DAY:
			descript = Nym.random.string("晴天","晴朗天气") ;
			break;
		case CLEAR_NIGHT:
			descript = Nym.random.string("晴天","晴朗夜空","晴朗天气");
			break;
		case CLOUDY:
			descript = Nym.random.string("阴天");
			break;
		case FOG:
			descript = Nym.random.string("大雾天气");
			break;
		case HAZE:
			descript = Nym.random.string("雾霾天气");
			break;
		case PARTLY_CLOUDY_DAY:
			descript = Nym.random.string("多云天气");
			break;
		case PARTLY_CLOUDY_NIGHT:
			descript = Nym.random.string("多云天气");
			break;
		case RAIN:
			descript = Nym.random.string("雨水天气");
			break;
		case SLEET:
			descript = Nym.random.string("冻雨天气");
			break;
		case SNOW:
			descript = Nym.random.string("雪，这到底咋写？");
			break;
		case WIND:
			descript = Nym.random.string("风");
			break;
		default:
			break;
		}
	}
	
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public static void main(String[] args) {
		System.out.println(Nym.random.string("sdfsdf"));
	}
}
