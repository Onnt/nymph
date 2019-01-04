package cn.virde.nymph.random;

import java.util.UUID;

/**
 * 
 * 随机数生成工具
 * @author Virde
 * 
 * 2019年1月4日 20:25:22
 */
public class RandomUtil {

	private final static int[] sizeTable = {9,99,999,9999,99999,999999,9999999,99999999,99999999,999999999,Integer.MAX_VALUE};
	/**
	 * 在某个数的基础上，
	 * 随机增减
	 * @author Blacard
	 * 2016年9月18日 下午5:12:11
	 * @param base 以base为基础
	 * @param add 随机增
	 * @param substract 随即减
	 * @return 返回 result
	 */
	public static long getRandom(long base,long add,long substract){
		return base+getRandom(add)-getRandom(substract);
	}

	/**
	 * 某个数字 加 另一个数字以内的随机数
	 * @author Blacard
	 * 2016年9月18日 下午5:15:47
	 * @param base 某个数字，用来作为基础值
	 * @param add 基础值 加 这个数字以内的随机数
	 * @return 返回
	 */
	public static long getRandom(long base,long add){
		return getRandom(base,add,0);
	}
	/**
	 * 按百分比获取boolean值，
	 * 比如 base = 20 ，20%几率返回true。
	 * 算法有待优化。
	 * @author Virde
	 * 2018年4月23日 上午9:56:33
	 * @return 返回
	 */
	public static boolean getBoolean(long base) {
		return  getRandom(100) < base ;
	}
	/**
	 * 在某个范围取随机数
	 * @author Virde
	 * 2018年5月10日 下午2:06:59
	 * @param start 开始
	 * @param end 结束
	 * @return 返回
	 */
	public static long getRandomRange(long start, long end) {
		return getRandom(start, end - start) ;
	}
	/**
	 * 在某个数以内的随机数
	 * @author Blacard
	 * 2016年9月18日 下午5:13:48
	 * @param base 某个数字
	 * @return 返回 某个数字以内的随机数，int类型
	 */
	private static long getRandom(long base){
		return (long) Math.floor((Math.random()*(base+1)));
	}
	

	/**
	 * 随机获取一个参数
	 * @author Virde
	 * 2018年11月1日 10:52:04
	 * @param args 传入的参数列表
	 * @return 返回 如果没有传入参数，则返回null
	 */
	public static Object getOne(Object...args) {
		if(args.length == 0 ) return null;
		int randomIndex = (int)RandomUtil.getRandom(0, args.length-1);
		return args[randomIndex];
	}
	
//	/**
//	 * 随机获取全国范围内任一地点
//	 * @author Virde
//	 * 2018年1月26日 下午2:47:45
//	 * @return 返回
//	 */
//	private static LocationEntity randomChineseAddress() {
//		return null;
//	}
	
	/**
	 * 
	 * @author SunAo
	 * 2018年3月26日 下午1:39:48
	 * @return 返回
	 */
	public static String uuid() {
		return UUID.randomUUID().toString();
	}
	/**
	 * 生成一个固定位数的随机数字，通常做验证码使用
	 * 
	 * @return 固定位数的随机数字
	 */
	public static String number(long size) {
		String result = "";
		int add = (int) (Math.pow(10, size) - 1);
		long random = getRandom(0, add);
		long diff = size - stringSize(random);
		for(int i = 0 ; i < diff;i++) {
			result += "0";
		}
		result += random;
		return result;
	}
	static long stringSize(long x) {
		for(int i = 0;; i++) {
			if(x <= sizeTable[i])
				return i + 1;
		}
	}
}
