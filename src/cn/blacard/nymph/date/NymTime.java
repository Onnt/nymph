package cn.blacard.nymph.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @author Blacard
 * @联系方式 邮箱：blacard@163.com <br/> 手机：18037170703
 * @create 2016年12月30日 下午7:07:28
 */
public class NymTime {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 本类的日期本体，如果实例化此类，必需给date赋值
	 */
	private Date date;
	
	/**
	 * 用Date类型实例化此类
	 * @param date Date类型
	 */
	public NymTime(Date date){
		this.date = date;
	}
	/**
	 * 用时间戳实例化此类
	 * @param timestamp 时间戳
	 */
	public NymTime(long timestamp){
		this.date = NymTime.timestampToDate(timestamp);
	}
	/**
	 * 用字符串类型的时间实例化此类。<br/>
	 * 字符串默认格式为“yyyy-MM-dd HH:mm:ss”<br/>
	 * 如果有其他格式请用 NymTime(String date,String format)
	 * @param date “yyyy-MM-dd HH:mm:ss” 格式的时间
	 */
	public NymTime(String date){
		this.date = NymTime.toDate(date,format);
	}
	/**
	 * 用指定格式(format)的字符串时间(date)实例化此类。
	 * format会更新此类的format
	 * @param date 时间
	 * @param format 时间格式
	 */
	public NymTime(String date,String format){
		setFormat(format);
		this.date = NymTime.toDate(date, format);
	}
	/**
	 * 用Date类型时间实例化此类。
	 * format会更新此类的format
	 * @param date Date时间
	 * @param format  format时间格式
	 */
	public NymTime(Date date,String format){
		setFormat(format);
		this.date = date;
	}
	/**
	 * 将时间转换成字符串返回。
	 * 格式由format指定
	 * @author Blacard
	 * @create 2016年12月30日 下午7:30:54
	 * @return
	 */
	public String getString(){
		return format.format(date);
	}
	/**
	 * 将给定时间转成字符串返回
	 * @author Blacard
	 * @create 2016年12月30日 下午7:31:18
	 * @param date Date类型时间
	 * @return
	 */
	public static String toString(Date date){
		return sdf.format(date);
	}
	/**
	 *  将给定时间转成字符串返回
	 * @author Blacard
	 * @create 2016年12月30日 下午7:31:30
	 * @param date Date类型时间
	 * @param format 格式
	 * @return
	 */
	public static String toString(Date date,String format){
		SimpleDateFormat this_sdf = new SimpleDateFormat(format);
		return this_sdf.format(date);
	}
	/**
	 * 获取Date类型时间
	 * @author Blacard
	 * @create 2016年12月30日 下午7:31:57
	 * @return
	 */
	public Date getDate(){
		return date;
	}
	/**
	 * 将时间转成Date类型<br/>
	 * 最好能自动匹配各种格式的时间
	 * @author Blacard
	 * @create 2016年12月30日 下午7:32:12
	 * @param date
	 * @return
	 */
	public static Date toDate(String date){
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 将时间转换成format类型的时间
	 * @author Blacard
	 * @create 2016年12月30日 下午7:32:23
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date toDate(String date,String format){
		SimpleDateFormat this_sdf = new SimpleDateFormat(format);
		try {
			return this_sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月31日 下午7:09:58
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date toDate(String date,SimpleDateFormat format){
		try {
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		return null;
	}
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月30日 下午7:32:29
	 * @param timestamp
	 * @return
	 */
	public static Date timestampToDate(long timestamp){
		return new Date(timestamp * 1000);
	}
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月30日 下午7:32:43
	 * @param timestamp
	 * @return
	 */
	public static Date timestampToDate(String timestamp){
		return timestampToDate(Long.parseLong(timestamp));
	}
	
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月30日 下午7:32:56
	 * @return
	 */
	public long getTimestamp(){
		return NymTime.dateToTimestamp(date);
	}
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月30日 下午7:33:21
	 * @param date
	 * @return
	 */
	public static long dateToTimestamp(Date date){
		return date.getTime();
	}
	
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月30日 下午8:47:12
	 * @param UNIT
	 * @param add
	 * @return
	 */
	public Date addTime(int UNIT,int add){
		return NymTime.addTime(date, UNIT, add);
	}
	
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月30日 下午8:47:09
	 * @param date
	 * @param UNIT
	 * @param add
	 * @return
	 */
	public static Date addTime(Date date,int UNIT, int add){
		Calendar cal =Calendar.getInstance();
		cal.setTime(date);
		cal.add(UNIT, add);
		return cal.getTime();
	}
	
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月30日 下午7:57:04
	 * @param format
	 */
	public void setFormat(String format){
		this.setFormat(new SimpleDateFormat(format));
	}
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月30日 下午7:57:09
	 * @param format
	 */
	public void setFormat(SimpleDateFormat format){
		this.format = format;
	}
}
