package cn.blacard.nymph.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * description 
 * author SunAo
 * create time 2016年8月9日 下午3:26:55
 * e-mail : blacard@163.com
 */
public class NymTime {
	/**
	 * 时间格式化工具
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public NymTime(String format){
		this.sdf =new SimpleDateFormat(format);
	}
	public NymTime(){
		
	}
	
	/**
	 *	时间计算工具
	 *
	 * 根据给定的时间，
	 * 以及要进行计算的单位（时分秒）
	 *	还有要加减的时间量（减为负数）
	 * 返回结果
	 * @author Blacard
	 * @param date 要进行运算的时间
	 * @param i 要计算的单位，时分秒。
	 * 可参考 Calendar类 。比如要进行分钟级的加减运算
	 * 可传递Calendar.MINUTE。小时级别 Calendar.HOUR
	 * @param add  
	 * @return
	 */
	public static String addTime(Date date,int i,int add){
		GregorianCalendar gc =new GregorianCalendar();
		gc.setTime(date);
		gc.add(i, add);
		return toString(gc.getTime());
	}
	/**
	 * 将Date类型的日期转换成String类型。
	 * 格式默认为"yyyy-MM-dd HH:mm:ss"
	 * @param d
	 * @return
	 */
	public static String toString(Date d){
		return sdf.format(d);
	}
	/**
	 * 把String类型的日期转换成Date类型
	 * @param strDate
	 * @return
	 */
	public static Date toDate(String strDate){
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 时间戳转换成Date
	 * @param timestamp
	 * @return
	 */
	public static Date timestampToDate(String timestamp){
		return timestampToDate(Long.parseLong(timestamp));
	}
	/**
	 * 时间戳转Date
	 * @param timestamp
	 * @return
	 */
	public static Date timestampToDate(long timestamp){
		return new Date(timestamp * 1000);
	}
	/**
	 * Date转时间戳
	 * @param date
	 * @return
	 */
	public static long dateToTimestamp(Date date){
		return date.getTime();
	}
	/**
	 * 给定时间是否和现在相等
	 * @param time
	 * @return
	 */
	public static boolean itsTimeNow(String time){
		return itsTimeNow(time,"yyyy-MM-dd HH:mm:ss");
	}
	
	public static boolean itsTimeNow(String time,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return time.equals(sdf.format(new Date()));
	}

	public static String getAPM(Date date){
		return getAPM(toString(date));
	}
	public static String getAPM(String time){
		int hour = Integer.parseInt(time.substring(11, 13));
		String apm = "";
		switch(hour){
		case 0:
			apm = "子时";
			break;
		case 1:
			apm = "丑时";
			break;
		case 2:
			apm = "丑时";
			break;
		case 3:
			apm = "寅时";
			break;
		case 4:
			apm = "寅时";
			break;
		case 5:
			apm = "早上";
			break;
		case 6:
			apm = "早上";
			break;
		case 7:
			apm = "早上";
			break;
		case 8:
			apm = "早上";
			break;
		case 9:
			apm = "上午";
			break;
		case 10:
			apm = "上午";
			break;
		case 11:
			apm = "中午";
			break;
		case 12:
			apm = "中午";
			break;
		case 13:
			apm = "下午";
			break;
		case 14:
			apm = "下午";
			break;
		case 15:
			apm = "下午";
			break;
		case 16:
			apm = "下午";
			break;
		case 17:
			apm = "下午";
			break;
		case 18:
			apm = "下午";
			break;
		case 19:
			apm = "晚上";
			break;
		case 20:
			apm = "晚上";
			break;
		case 21:
			apm = "晚上";
			break;
		case 22:
			apm = "晚上";
			break;
		case 23:
			apm = "子时";
			break;
		}
		return apm;
	}
}
