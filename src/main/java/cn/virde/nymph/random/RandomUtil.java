package cn.virde.nymph.random;

import java.util.Random;
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
	private static long stringSize(long x) {
		for(int i = 0;; i++) {
			if(x <= sizeTable[i])
				return i + 1;
		}
	}
    public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 返回一个定长的带因子的固定的随机字符串(只包含大小写字母、数字)
     *
     * @param length
     *            随机字符串长度
     * @return 随机字符串
     */
    public static String generateStringByKey(int length, int channel) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random(channel);
        for (int i = 0; i < length; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        return sb.toString();
    }


    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     *
     * @param length
     *            随机字符串长度
     * @return 随机字符串
     */
    public static String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
        }
        return sb.toString();
    }

    public static final String LETTERCHAR = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * 返回一个定长的随机纯字母字符串(只包含大小写字母)
     *
     * @param length
     *            随机字符串长度
     * @return 随机字符串
     */
    public static String generateMixString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(ALLCHAR.charAt(random.nextInt(LETTERCHAR.length())));
        }
        return sb.toString();
    }

    /**
     * 返回一个定长的随机纯大写字母字符串(只包含大小写字母)
     *
     * @param length
     *            随机字符串长度
     * @return 随机字符串
     */
    public static String generateLowerString(int length) {
        return generateMixString(length).toLowerCase();
    }

    /**
     * 返回一个定长的随机纯小写字母字符串(只包含大小写字母)
     *
     * @param length
     *            随机字符串长度
     * @return 随机字符串
     */
    public static String generateUpperString(int length) {
        return generateMixString(length).toUpperCase();
    }

    /**
     * 根据数字生成一个定长的字符串，长度不够前面补0
     *
     * @param num
     *            数字
     * @param fixdlenth
     *            字符串长度
     * @return 定长的字符串
     */
    public static String toFixdLengthString(long num, int fixdlenth) {
        StringBuffer sb = new StringBuffer();
        String strNum = String.valueOf(num);
        if (fixdlenth - strNum.length() >= 0) {
            sb.append(generateZeroString(fixdlenth - strNum.length()));
        } else {
            throw new RuntimeException("将数字" + num + "转化为长度为" + fixdlenth + "的字符串发生异常！");
        }
        sb.append(strNum);
        return sb.toString();
    }
    /**
     * 生成一个定长的纯0字符串
     *
     * @param length
     *            字符串长度
     * @return 纯0字符串
     */
    public static String generateZeroString(int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append('0');
        }
        return sb.toString();
    }
    /**
     * 每次生成的len位数都不相同
     *
     * @param param
     * @return 定长的数字
     */
    public static int getNotSimple(int[] param, int len) {
        Random rand = new Random();
        for (int i = param.length; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = param[index];
            param[index] = param[i - 1];
            param[i - 1] = tmp;
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = result * 10 + param[i];
        }
        return result;
    }
	public static void main(String[] args) {
//		long a = getRandom(100);
//		System.out.println(a);
		int a= 0;
		for(int i = 0 ; i<101;i++) {
			System.out.println(a+=i);
		}
	}
}
