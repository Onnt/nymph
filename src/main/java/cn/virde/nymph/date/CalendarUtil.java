package cn.virde.nymph.date;

import java.util.Calendar;
import java.util.Date;

import cn.virde.nymph.entity.date.TimeInterval;

/**
 * 
 * @author SunAo
 * 2018年4月10日 下午8:54:49
 */
public class CalendarUtil {
	
	public TimeInterval getTimeInterval(Date date,int field , int amount1,int amount2) {
		TimeInterval time = new TimeInterval();
		Calendar cal = Calendar.getInstance() ;
		
		cal.setTime(date);
		cal.add(field, amount1);
		time.setStartDate(cal.getTime());

		cal.add(field, amount2);
		time.setEndDate(cal.getTime());
		
		return time ;
	}
	public TimeInterval getTimeInterval(int field , int amount1,int amount2) {
		return getTimeInterval(new Date(), field, amount1, amount2) ;
	}

	public TimeInterval getTimeIntervalOnDay(int amount1 , int amount2 ) {
		TimeInterval time = new TimeInterval();
		Calendar cal = Calendar.getInstance() ;
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.add(Calendar.DAY_OF_MONTH, amount1);
		time.setStartDate(cal.getTime());

		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.add(Calendar.DAY_OF_MONTH, amount2);
		time.setEndDate(cal.getTime());
		
		return time ;
	}
	/**
	 * 获取某个时间间隔。
	 * 这个时间间隔由两个参数指定
	 * @author SunAo
	 * 2018年4月10日 下午8:56:19
	 * 
	 * 这个方法已经遗弃，请使用getTimeIntervalOnDay替代
	 * @author SunAo
	 * 2018年4月13日 15:15:33
	 * 
	 * @param amount1 第一次计算
	 * @param amount2 第二次计算
	 */
//	@Deprecated
//	public TimeInterval getTimeInterval(int amount1 , int amount2 ) {
//		return getTimeIntervalOnDay(amount1, amount2);
//	}
	
	/**
	 * 获取昨天的开始结束时间
	 * @author SunAo
	 * 2018年4月10日 下午8:59:05
	 */
	public TimeInterval getYesterdayTimeInterval() {
		return getTimeIntervalOnDay(-1, 0);
	}
	
	/**
	 * 
	 * @author SunAo
	 * 2018年4月11日 下午3:24:53
	 * @param a 几个月前的 -1 上个月 -2 上上个月
	 * @return 返回
	 */
	public TimeInterval getOneMonth(int a) {
		TimeInterval respObj = new TimeInterval();
		Calendar cal = Calendar.getInstance() ;
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		cal.add(Calendar.MONTH,  a);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		respObj.setStart(cal.getTime().getTime());
		
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		
		respObj.setEnd(cal.getTime().getTime());
		return respObj ;
	}
	
}
