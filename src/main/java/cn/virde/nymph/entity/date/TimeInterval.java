package cn.virde.nymph.entity.date;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.virde.nymph.Nym;

import static java.util.Calendar.*;

import java.util.ArrayList;

/**
 * 
 * @author Virde
 * @time 2018年1月25日 下午5:50:03
 * @change 2018年8月22日 17:12:07
 */
public class TimeInterval {
	
	private Date startDate;
	private Date endDate;
	
	public TimeInterval() {
		super();
	}
	public TimeInterval(Date startDate, Date endDate) {
		this.startDate = startDate ;
		this.endDate = endDate ;
	}
	public TimeInterval(long start , long end ) {
		this.startDate = Nym.time.toDate(start);
		this.endDate = Nym.time.toDate(end);
	}
	
	public long getStart() {
		return startDate.getTime();
	}
	public void setStart(long start) {
		this.startDate = new Date(start);
	}
	public long getEnd() {
		return endDate.getTime();
	}
	public void setEnd(long end) {
		this.endDate = new Date(end);
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public long getUnixStart() {
		return startDate.getTime() / 1000 ;
	}
	public long getUnixEnd() {
		return endDate.getTime() / 1000 ;
	}
	public boolean isNull() {
		return startDate == null || endDate == null ;
	}
	
	/**
	 * 给定一个日期，
	 * 设置开始时间为这个日期的00:00:00，
	 * 结束时间为这个日期的23:59:59
	 * @author Virde
	 * @Date 2018年8月22日 17:04:46
	 */
	public void setIntervalByDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(HOUR_OF_DAY, cal.getActualMinimum(HOUR_OF_DAY));
		cal.set(MINUTE,cal.getActualMinimum(MINUTE));
		cal.set(SECOND,cal.getActualMinimum(SECOND));
		setStartDate(cal.getTime());
		cal.set(HOUR_OF_DAY, cal.getActualMaximum(HOUR_OF_DAY));
		cal.set(MINUTE,cal.getActualMaximum(MINUTE));
		cal.set(SECOND,cal.getActualMaximum(SECOND));
		setEndDate(cal.getTime());
	}
	public static TimeInterval getIntervalByDay(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setIntervalByDay(date);
		return timeInterval;
	}
	/**
	 * 给定一个时间
	 * 设置开始时间为这个时间的零分零秒
	 * 结束时间为这个时间的59分59秒
	 * @author Virde
	 * @Date 2018年8月22日 17:04:46
	 */
	public void setIntervalByHour(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(MINUTE,cal.getActualMinimum(MINUTE));
		cal.set(SECOND,cal.getActualMinimum(SECOND));
		setStartDate(cal.getTime());
		cal.set(MINUTE,cal.getActualMaximum(MINUTE));
		cal.set(SECOND,cal.getActualMaximum(SECOND));
		setEndDate(cal.getTime());
	}
	public static TimeInterval getIntervalByHour(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setIntervalByHour(date);
		return timeInterval;
	}
	/**
	 * 给定一个日期，
	 * 设置开始时间为这个月的1日 00:00:00，
	 * 结束时间为这个月最后一天的23:59:59
	 * @author Virde
	 * @Date 2018年8月22日 17:04:46
	 */
	public void setIntervalByMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(DAY_OF_MONTH, cal.getActualMinimum(DAY_OF_MONTH));
		cal.set(HOUR_OF_DAY, cal.getActualMinimum(HOUR_OF_DAY));
		cal.set(MINUTE,cal.getActualMinimum(MINUTE));
		cal.set(SECOND,cal.getActualMinimum(SECOND));
		setStartDate(cal.getTime());
		cal.set(DAY_OF_MONTH,cal.getActualMaximum(DAY_OF_MONTH));
		cal.set(HOUR_OF_DAY, cal.getActualMaximum(HOUR_OF_DAY));
		cal.set(MINUTE,cal.getActualMaximum(MINUTE));
		cal.set(SECOND,cal.getActualMaximum(SECOND));
		setEndDate(cal.getTime());
	}

	public static TimeInterval getIntervalByMonth(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setIntervalByMonth(date);
		return timeInterval;
	}
	/**
	 * 给定一个日期，
	 * 设置开始时间为这一年的第一天的00:00:00，
	 * 结束时间为这一年最后一天的23:59:59
	 * @author Virde
	 * @Date 2018年8月22日 17:04:46
	 */
	public void setIntervalByYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(MONTH, cal.getActualMinimum(MONTH));
		cal.set(DAY_OF_MONTH, cal.getActualMinimum(DAY_OF_MONTH));
		cal.set(HOUR_OF_DAY, cal.getActualMinimum(HOUR_OF_DAY));
		cal.set(MINUTE,cal.getActualMinimum(MINUTE));
		cal.set(SECOND,cal.getActualMinimum(SECOND));
		setStartDate(cal.getTime());
		cal.set(MONTH, cal.getActualMaximum(MONTH));
		cal.set(DAY_OF_MONTH,cal.getActualMaximum(DAY_OF_MONTH));
		cal.set(HOUR_OF_DAY, cal.getActualMaximum(HOUR_OF_DAY));
		cal.set(MINUTE,cal.getActualMaximum(MINUTE));
		cal.set(SECOND,cal.getActualMaximum(SECOND));
		setEndDate(cal.getTime());
	}
	public static TimeInterval getIntervalByYear(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setIntervalByYear(date);
		return timeInterval;
	}

	/**
	 * 获取开始时间到结束时间中间的每一个小时，不包含开始时间和结束时间所在的小时
	 * 如果没有符合条件的结果则返回空的列表
	 * @author Virde
	 * @Date 2018年8月22日 17:04:46
	 * @return
	 */
	public List<TimeInterval> getEveryHour() {
		List<TimeInterval> respList = new ArrayList<TimeInterval>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		int startMinute = cal.get(MINUTE);
		int startSecond = cal.get(SECOND);
		if(startMinute != 0 || startSecond != 0) {
			cal.add(HOUR_OF_DAY, +1);
			cal.set(MINUTE, 0);
			cal.set(SECOND, 0);
		}
		Date start = cal.getTime();
		
		cal.setTime(endDate);
		int endMinute = cal.get(MINUTE);
		int endSecond = cal.get(SECOND);
		if(endMinute != 0 || endSecond != 0) {
			cal.set(MINUTE, 0);
			cal.set(SECOND, 0);
			cal.add(SECOND, -1);
		}
		Date end = cal.getTime();
		
		if(start.after(end)) {
			return respList;
		}
		
		while(start.before(end)) {
			TimeInterval ti = getIntervalByHour(start);
			respList.add(ti);
			
			cal.setTime(start);
			cal.add(HOUR_OF_DAY, +1);
			start = cal.getTime();
		}
		
		return respList;
	}
	public static List<TimeInterval> getEveryHour(Date startDate,Date endDate){
		return new TimeInterval(startDate,endDate).getEveryHour();
	}
	/**
	 * 获取开始时间到结束时间中间的每一天，不包含开始结束时间所在的天
	 * 如果没有符合条件的结果则返回空的列表
	 * @author Virde
	 * @Date 2018年8月22日 17:04:46
	 * @return
	 */
	public List<TimeInterval> getEveryDay() {
		List<TimeInterval> respList = new ArrayList<TimeInterval>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		int startHour   = cal.get(HOUR_OF_DAY);
		int startMinute = cal.get(MINUTE);
		int startSecond = cal.get(SECOND);
		if(startMinute != 0 || startSecond != 0 || startHour != 0) {
			cal.add(DAY_OF_MONTH, +1);
			cal.set(HOUR_OF_DAY, 0);
			cal.set(MINUTE, 0);
			cal.set(SECOND, 0);
		}
		Date start = cal.getTime();
		
		cal.setTime(endDate);
		int endHour   = cal.get(HOUR_OF_DAY);
		int endMinute = cal.get(MINUTE);
		int endSecond = cal.get(SECOND);
		if(endMinute != 0 || endSecond != 0 || endHour != 0) {
			cal.set(HOUR_OF_DAY, 0);
			cal.set(MINUTE, 0);
			cal.set(SECOND, 0);
			cal.add(SECOND, -1);
		}
		Date end = cal.getTime();
		
		if(start.after(end)) {
			return respList;
		}
		
		while(start.before(end)) {
			TimeInterval ti = getIntervalByDay(start);
			respList.add(ti);
			
			cal.setTime(start);
			cal.add(DAY_OF_MONTH, +1);
			start = cal.getTime();
		}
		
		return respList;
	}

	public static List<TimeInterval> getEveryDay(Date startDate,Date endDate){
		return new TimeInterval(startDate,endDate).getEveryDay();
	}
	/**
	 * 获取开始时间到结束时间中间的每一个月，不包含开始结束时间所在的月
	 * 如果没有符合条件的结果则返回空的列表
	 * @author Virde
	 * @Date 2018年8月22日 17:04:46
	 * @return
	 */
	public List<TimeInterval> getEveryMonth() {
		List<TimeInterval> respList = new ArrayList<TimeInterval>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		int startDay    = cal.get(DAY_OF_MONTH);
		int startHour   = cal.get(HOUR_OF_DAY);
		int startMinute = cal.get(MINUTE);
		int startSecond = cal.get(SECOND);
		if(startMinute != 0 || startSecond != 0 || startHour != 0 || startDay != 1) {
			cal.add(MONTH,+1);
			cal.set(DAY_OF_MONTH, 1);
			cal.set(HOUR_OF_DAY, 0);
			cal.set(MINUTE, 0);
			cal.set(SECOND, 0);
		}
		Date start = cal.getTime();
		
		cal.setTime(endDate);
		int endDay    = cal.get(DAY_OF_MONTH);
		int endHour   = cal.get(HOUR_OF_DAY);
		int endMinute = cal.get(MINUTE);
		int endSecond = cal.get(SECOND);
		if(endMinute != 0 || endSecond != 0 || endHour != 0 || endDay != 1) {
			cal.set(DAY_OF_MONTH, 1);
			cal.set(HOUR_OF_DAY, 0);
			cal.set(MINUTE, 0);
			cal.set(SECOND, 0);
			cal.add(SECOND, -1);
		}
		Date end = cal.getTime();
		
		if(start.after(end)) {
			return respList;
		}
		
		while(start.before(end)) {
			TimeInterval ti = getIntervalByMonth(start);
			respList.add(ti);
			
			cal.setTime(start);
			cal.add(MONTH, +1);
			start = cal.getTime();
		}
		
		return respList;
	}
	public static List<TimeInterval> getEveryMonth(Date startDate,Date endDate){
		return new TimeInterval(startDate,endDate).getEveryMonth();
	}
	
}
