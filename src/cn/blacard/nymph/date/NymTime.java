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
		return toTime(gc.getTime());
	}
	/**
	 * 将Date类型的日期转换成String类型。
	 * 格式默认为"yyyy-MM-dd HH:mm:ss"
	 * @param d
	 * @return
	 */
	public static String toTime(Date d){
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
	
	
	public static Date timestampToDate(String timestamp){
		return timestampToDate(Long.parseLong(timestamp));
	}
	public static Date timestampToDate(long timestamp){
		return new Date(timestamp * 1000);
	}
	
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
}
