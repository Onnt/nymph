package cn.virde.nymph.random;

import java.util.UUID;

import cn.virde.nymph.Nym;
import cn.virde.nymph.entity.base.LocationEntity;

public class Random extends NumberRandom{

	/**
	 * 随机获取一个参数
	 * @author Virde
	 * @time 2018年1月25日 上午11:32:07
	 * @param args
	 * @return 如果没有传入参数，则返回null
	 */
	public String string(String...args) {
		if(args.length == 0 ) return null;
		int randomIndex = Nym.random.getRandom(0, args.length-1);
		return args[randomIndex];
	}
	
	/**
	 * 随机获取全国范围内任一地点
	 * @author Virde
	 * @time 2018年1月26日 下午2:47:45
	 * @return
	 */
	public LocationEntity randomChineseAddress() {
		return null;
	}
	
	/**
	 * 
	 * @author SunAo
	 * @date 2018年3月26日 下午1:39:48
	 * @return
	 */
	public String uuid() {
		return UUID.randomUUID().toString();
	}
}
