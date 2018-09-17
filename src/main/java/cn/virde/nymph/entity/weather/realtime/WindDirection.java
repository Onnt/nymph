package cn.virde.nymph.entity.weather.realtime;

/**
 * 风向，是指风吹来的方向。
 * 一般在测定时有不同的方法。
 * 主要分海洋，大陆，高空进行确定。
 * 利用风向可以在人们的生活，生产，建厂，农业，交通，军事等各种领域发挥积极作用
 * @author Virde
 * 2018年1月24日 下午6:09:58
 */
public class WindDirection {
	
	// 风向刻度值，单位是度。正北方向为0度，顺时针增加到360度。
	private double direction ;
	// 风向名称。如，正北风，正南风，西南风。偏北风
	private String name ;
	// 方向名字
	private String directionName ;
	
	/**
	 * direction 如果大于360 ,会进行取余计算
	 * @param direction
	 */
	public WindDirection(double direction) {
		this.direction = direction % 360 ;
		calculation();
	}
	
	private void calculation() {
		if(direction <= 22.5 ) {
			directionName = "北" ;
		}else if(direction <= 67.5) {
			directionName = "东北" ;
		}else if(direction <= 112.5) {
			directionName = "东" ;
		}else if(direction <= 157.5) {
			directionName = "东南" ;
		}else if(direction <= 202.5) {
			directionName = "南" ;
		}else if(direction <= 247.5) {
			directionName = "西南" ;
		}else if(direction <= 292.5) {
			directionName = "西" ;
		}else if(direction <= 337.5) {
			directionName = "西北" ;
		}else{
			directionName = "北" ;
		}
		name = directionName + "风" ;
	}
	
	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDirectionName() {
		return directionName;
	}

	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}
}
