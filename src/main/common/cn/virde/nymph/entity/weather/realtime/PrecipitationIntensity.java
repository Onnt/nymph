package cn.virde.nymph.entity.weather.realtime;

import cn.virde.nymph.enums.common.SkyconsConstant;

/**
 * 计算降水强度
 * @author Virde
 * @time 2018年1月25日 下午1:33:46
 */
public class PrecipitationIntensity {
	private String skycon ;
	private double intensity ;
	
	private String name ;
	private String description ;
	
	public PrecipitationIntensity(String skycon,double d) {
		this.skycon = skycon ;
		intensity = d ;
		
		calculation();
	}

	private void calculation() {
		if(skycon.equals(SkyconsConstant.SNOW)) {
			calculationSnow();
		}else if(skycon.equals(SkyconsConstant.RAIN)){
			calculationRain();
		}
	}
	private void calculationSnow() {
		double mm = intensity * 12 ;
		if(mm <= 1) {
			name = "小雪";
		}else if(mm < 3) {
			name = "中雪";
		}else if(mm < 6) {
			name = "大雪";
		}else {
			name = "暴雪";
		}
	}
	private void calculationRain() {
		double mm = intensity * 12 ;
		if(mm <= 4.9) {
			name = "小雨";
		}else if(mm < 15) {
			name = "中雨";
		}else if(mm < 30) {
			name = "大雨" ;
		}else if(mm < 70) {
			name= "暴雨" ;
		}else if(mm < 140) {
			name= "大暴雨" ;
		}else {
			name= "特大暴雨" ;
		}
	}
	

	public String getSkycon() {
		return skycon;
	}

	public void setSkycon(String skycon) {
		this.skycon = skycon;
	}

	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

/**
中国气象主管部门规定的降水强度等级划分表
名称			20小时降水量(mm)	12小时降水量(mm)	注
小雨、阵雨		0.1～9.9			≤4.9
小雨─中雨		5.0～16.9			3.0～9.9
中雨  			10.0～24.9			5.0～14.9
中雨—大雨		17.0～37.9			10.0～22.9
大雨 			25.0～49.9			15.0～29.9
大雨—暴雨 		33.0～74.9			23.0～49.9
暴雨 			50.0～99.9			30.0～69.9
暴雨—大暴雨 	75.0～174.9			50.0～104.9
大暴雨 			100.0～249.9		70.0～139.9
大暴雨─特大暴雨 175.0～299.9		105.0～169.9
特大暴雨		≥250.0				≥140.0

		折合为融化后的雨水量			或过程积雪深度达
小雪	≤2.5						≤1.0
中雪	2.4～4.9				1.1～2.9	30mm
大雪	5.0～9.9				3.0～5.9	50mm
暴雪	≥10.0					≥6.0			80mm
**/
