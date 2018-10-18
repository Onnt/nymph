package cn.virde.nymph.random;

import java.util.UUID;

import cn.virde.nymph.Nym;
import cn.virde.nymph.entity.base.LocationEntity;

public class Random extends NumberRandom{
	final static int[] sizeTable = {9,99,999,9999,99999,999999,9999999,99999999,99999999,999999999,Integer.MAX_VALUE};
	/**
	 * 随机获取一个参数
	 * @author Virde
	 * 2018年1月25日 上午11:32:07
	 * @param args 传入的参数列表
	 * @return 返回 如果没有传入参数，则返回null
	 */
	public String string(String...args) {
		if(args.length == 0 ) return null;
		int randomIndex = Nym.random.getRandom(0, args.length-1);
		return args[randomIndex];
	}
	
	/**
	 * 随机获取全国范围内任一地点
	 * @author Virde
	 * 2018年1月26日 下午2:47:45
	 * @return 返回
	 */
	public LocationEntity randomChineseAddress() {
		return null;
	}
	
	/**
	 * 
	 * @author SunAo
	 * 2018年3月26日 下午1:39:48
	 * @return 返回
	 */
	public String uuid() {
		return UUID.randomUUID().toString();
	}
	/**
	 * 生成一个固定位数的随机数字，通常做验证码使用
	 * 
	 * @return 固定位数的随机数字
	 */
	public String number(int size) {
		String result = "";
		int add = (int) (Math.pow(10, size) - 1);
		Integer random = getRandom(0, add);
		int diff = size - stringSize(random);
		for(int i = 0 ; i < diff;i++) {
			result += "0";
		}
		result += random;
		return result;
	}
	static int stringSize(int x) {
		for(int i = 0;; i++) {
			if(x <= sizeTable[i])
				return i + 1;
		}
	}
	public static void main(String[] args) {
		for(int i = 0 ; i < 1000 ; i ++) {
			System.out.println(new Random().number(6));
			
		}
	}
	
}
