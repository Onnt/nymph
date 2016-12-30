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
	 * 
	 */
	private Date date;
	
	/**
	 * 
	 * @param date
	 */
	public NymTime(Date date){
		this.date = date;
	}
	/**
	 * 
	 * @param timestamp
	 */
	public NymTime(long timestamp){
		this.date = NymTime.timestampToDate(timestamp);
	}
	/**
	 * 
	 * @param date
	 */
	public NymTime(String date){
		this.date = NymTime.toDate(date,format);
	}
	/**
	 * 
	 * @param date
	 * @param format
	 */
	public NymTime(String date,String format){
		setFormat(format);
		this.date = NymTime.toDate(date, format);
	}
	public NymTime(Date date,String format){
		setFormat(format);
		this.date = date;
	}
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月30日 下午7:30:54
	 * @return
	 */
	public String getString(){
		return format.format(date);
	}
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月30日 下午7:31:18
	 * @param date
	 * @return
	 */
	public static String toString(Date date){
		return sdf.format(date);
	}
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月30日 下午7:31:30
	 * @param date
	 * @param format
	 * @return
	 */
	public static String toString(Date date,String format){
		SimpleDateFormat this_sdf = new SimpleDateFormat(format);
		return this_sdf.format(date);
	}
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月30日 下午7:31:57
	 * @return
	 */
	public Date getDate(){
		return date;
	}
	/**
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
	 * 
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
