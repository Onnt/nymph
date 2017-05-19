package cn.virde.nymph;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Nymph 代码使用示例
 */
public class NymphDemo {
	
	/**
	 * 中国农历转换工具 使用说明
	 */
	public static void main_chineseCalendar(String[] args) {
		String date_str = "2017-02-02"; //一个农历日期
		Date date = Nym.time.toDate(date_str);
		
		//农历 转换为 阳历
		System.out.println(Nym.chineseCalendar.toSunDate(date));
		
		//阳历 转换为 农历
		System.out.println(Nym.chineseCalendar.toMoonDate(new Date()));
	}
	
	/**
	 * 时间转换以及计算工具
	 * @param args
	 */
	public static void main(String[] args) {
		//Date类型转字符串类型
		System.out.println(Nym.time.toString(new Date()));
		
		//Date类型转换为指定格式的字符串类型
		System.out.println(Nym.time.toString(new Date(), "yyyyMMdd"));
		
		//将几种常见格式的字符串日期转换为 Date类型
		System.out.println(Nym.time.toDate("2017年2月8日 11:45:04"));
		System.out.println(Nym.time.toDate("2017年2月8日"));
		System.out.println(Nym.time.toDate("2017-2-8 11:45:28"));
		System.out.println(Nym.time.toDate("2017-2-8"));
		//将时间戳转换为 Date类型 支持String，Long类型，支持Unix和java两种不同时间戳
		System.out.println(Nym.time.toDate("1486525596472"));
		System.out.println(Nym.time.toDate(1486525596472L));
		System.out.println(Nym.time.toDate(1486525596L));
		//将指定格式的时间字符串转换成Date类型
		System.out.println(Nym.time.toDate("20170809","yyyyMMdd"));
		System.out.println(Nym.time.toDate("20170809",new SimpleDateFormat("yyyyMMdd")));
		//将Date类型转换为时间戳（jdk自带的方法名有歧义，所以自己又写了一个）
		System.out.println(Nym.time.toTimestamp(new Date()));
		
		//时间加减计算方法
		//算出明天的日期
		System.out.println(Nym.time.addTime(new Date(), Calendar.DAY_OF_MONTH, 1));
		//算出下个月今天的日期
		System.out.println(Nym.time.addTime(new Date(),Calendar.MONTH,1));
		//算出48天之后的日期
		System.out.println(Nym.time.addTime(new Date(),Calendar.DAY_OF_MONTH,48));
		//算出56小时之前的日期
		System.out.println(Nym.time.addTime(new Date(), Calendar.HOUR_OF_DAY, -56));
	
		Nym.time.setDate(new Date()).timeToZero().format("").format("").format("").format("").format("").addTime(0, 0).getDate();
	}
	
	/**
	 * 随机数计算 使用演示
	 * @author Blacard
	 * @create 2017年2月8日 下午1:54:50
	 * @param args
	 */
	public static void main_random(String[] args) {
		//在某个数的基础上，随机增减，比如：在80的基础上随机减20或增加35
		System.out.println(Nym.random.getRandom(80, 35, 20));
		
		//取 某个数 到 某个数 之间的某个数，比如：取 20 到 99之间随机的某个数
		System.out.println(Nym.random.getRandom(20,79));
	}
	
	/**
	 * 格式化工具
	 * @author Blacard
	 * @create 2017年2月8日 下午2:09:06
	 * @param args
	 */
	public static void main_format(String[] args) {
		//将数字转换为自然语言描述的文件大小，比如：下面转换之后是 953MB
		System.out.println(Nym.format.fileLength(1000023232L));
		
		//将自然语言描述的文件大小转换为 Long类型数字大小，比如：
		System.out.println(Nym.format.fileSizeToLong("953MB"));
	}
	
	/**
	 * String字符串处理小工具 说明代码
	 * @author Blacard
	 * @create 2017年2月8日 下午2:20:42
	 * @param args
	 */
	public static void main_string(String[] args) {
		
		//去掉字符串中所有空白符(空格，制表符，回车符)
		String str = "this is a demo String";
		System.out.println(Nym.string.replaceBlank(str));
		
		//获取文件后缀名
		System.out.println(Nym.string.getSuffix("haha.mp4"));
	}
	
	/**
	 * 文本读取
	 * @author Blacard
	 * @create 2017年3月1日 上午11:13:41
	 * @param args
	 */
	public static void main_TextRead(String[] args) {
//		String path = "文本的路径";
		String path="D://a.txt";
		Nym.textRead.read(new File(path));
		Nym.textRead.read(path);
	}
}
