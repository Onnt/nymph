package cn.virde.nymph.datetime;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import cn.virde.nymph.Nym;

import static java.util.Calendar.*;

/**
 * 
 * @author Virde
 * 2018年1月25日 下午5:50:03
 * change 2018年8月22日 17:12:07
 */
public class TimeInterval {
	
	private Date beginDate;
	private Date endDate;
	
	public TimeInterval() {
		super();
	}
	public TimeInterval(Date beginDate, Date endDate) {
		this.beginDate = beginDate ;
		this.endDate = endDate ;
	}
	public TimeInterval(long begin, long end ) {
		this.beginDate = DateTime.toDate(begin);
		this.endDate = DateTime.toDate(end);
	}
	
	public long getStart() {
		return beginDate.getTime();
	}
	public void setStart(long begin) {
		this.beginDate = new Date(begin);
	}
	public long getEnd() {
		return endDate.getTime();
	}
	public void setEnd(long end) {
		this.endDate = new Date(end);
	}
	
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public long getBeginUnixTimestamp() {
		return beginDate.getTime() / 1000 ;
	}
	public long getEndUnixTimestamp() {
		return endDate.getTime() / 1000 ;
	}
	public boolean isNull() {
		return beginDate == null || endDate == null ;
	}

	/**
	 * 给定一百个时间
	 * 设置开始结束时间为这个时间的是零秒和59秒
	 * @author Virde
	 * 2018年11月1日 10:40:47
	 * @param date 时间基点
	 */
	public void setIntervalByMinute(Date date) {
		Calendar cal = getInstance();
		cal.setTime(date);
		cal.set(SECOND,cal.getActualMinimum(SECOND));
		setBeginDate(cal.getTime());
		cal.set(SECOND,cal.getActualMaximum(SECOND));
		setEndDate(cal.getTime());
	}

	/**
	 * 给定一百个时间
	 * 设置开始结束时间为这个时间的是零秒和59秒
	 * @author Virde
	 * 2018年11月1日 10:40:47
	 * @param date 时间基点 
	 * @return 生成好的时间区间
	 */
	public static TimeInterval getIntervalByMinute(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setIntervalByMinute(date);
		return timeInterval;
	}
	/**
	 * 给定一个时间
	 * 设置开始时间为这个时间的零分零秒
	 * 结束时间为这个时间的59分59秒
	 * @author Virde
	 * 2018年8月22日 17:04:46
	 */
	public void setIntervalByHour(Date date) {
		Calendar cal = getInstance();
		cal.setTime(date);
		cal.set(MINUTE,cal.getActualMinimum(MINUTE));
		cal.set(SECOND,cal.getActualMinimum(SECOND));
		setBeginDate(cal.getTime());
		cal.set(MINUTE,cal.getActualMaximum(MINUTE));
		cal.set(SECOND,cal.getActualMaximum(SECOND));
		setEndDate(cal.getTime());
	}
	/**
	 * 分别设置开始结束时间为给定的时间的00:00,59:59
	 * @param 设置开始结束时间的基数
	 * @return 设置好的时间区间
	 * @author Virde
	 * 2018年10月24日 19:39:17
	 * 
	 */
	public static TimeInterval getIntervalByHour(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setIntervalByHour(date);
		return timeInterval;
	}
	/**
	 * 给定一个日期，
	 * 设置开始时间为这个日期的00:00:00，
	 * 结束时间为这个日期的23:59:59
	 * @author Virde
	 * 2018年8月22日 17:04:46
	 */
	public void setIntervalByDay(Date date) {
		Calendar cal = getInstance();
		cal.setTime(date);
		cal.set(HOUR_OF_DAY, cal.getActualMinimum(HOUR_OF_DAY));
		cal.set(MINUTE,cal.getActualMinimum(MINUTE));
		cal.set(SECOND,cal.getActualMinimum(SECOND));
		setBeginDate(cal.getTime());
		cal.set(HOUR_OF_DAY, cal.getActualMaximum(HOUR_OF_DAY));
		cal.set(MINUTE,cal.getActualMaximum(MINUTE));
		cal.set(SECOND,cal.getActualMaximum(SECOND));
		setEndDate(cal.getTime());
	}
	/**
	 * 分别设置开始为这个时间的00:00:00,23:59:59
	 * @param date 时间基数
	 * @return 设好的时间区间
	 * @author Virde
	 * 2018年10月24日 19:42:29
	 */
	public static TimeInterval getIntervalByDay(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setIntervalByDay(date);
		return timeInterval;
	}
	
	/**
	 * 分别设置开始结束为这个时间的周一 00:00:00,周日 23:59:59
	 * @param date 时间基点
	 */
	public void setIntervalByWeek(Date date) {
		Calendar cal = getInstance();
		cal.setTime(date);
		cal.set(DAY_OF_WEEK, cal.getActualMinimum(DAY_OF_WEEK));
		cal.set(HOUR_OF_DAY, cal.getActualMinimum(HOUR_OF_DAY));
		cal.set(MINUTE,cal.getActualMinimum(MINUTE));
		cal.set(SECOND,cal.getActualMinimum(SECOND));
		setBeginDate(cal.getTime());
		cal.set(DAY_OF_WEEK, cal.getMaximum(DAY_OF_WEEK));
		cal.set(HOUR_OF_DAY, cal.getActualMaximum(HOUR_OF_DAY));
		cal.set(MINUTE,cal.getActualMaximum(MINUTE));
		cal.set(SECOND,cal.getActualMaximum(SECOND));
		setEndDate(cal.getTime());
	}
	/**
	 * 分别设置开始结束为这个时间的周一 00:00:00,周日 23:59:59
	 * @param date 时间基点
	 * @return 设置好的时间区间
	 */
	public static TimeInterval getIntervalByWeek(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setIntervalByWeek(date);
		return timeInterval;
	}
	/**
	 * 给定一个日期，
	 * 设置开始时间为这个月的1日 00:00:00，
	 * 结束时间为这个月最后一天的23:59:59
	 * @author Virde
	 * 2018年8月22日 17:04:46
	 */
	public void setIntervalByMonth(Date date) {
		Calendar cal = getInstance();
		cal.setTime(date);
		cal.set(DAY_OF_MONTH, cal.getActualMinimum(DAY_OF_MONTH));
		cal.set(HOUR_OF_DAY, cal.getActualMinimum(HOUR_OF_DAY));
		cal.set(MINUTE,cal.getActualMinimum(MINUTE));
		cal.set(SECOND,cal.getActualMinimum(SECOND));
		setBeginDate(cal.getTime());
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
	 * 2018年8月22日 17:04:46
	 */
	public void setIntervalByYear(Date date) {
		Calendar cal = getInstance();
		cal.setTime(date);
		cal.set(MONTH, cal.getActualMinimum(MONTH));
		cal.set(DAY_OF_MONTH, cal.getActualMinimum(DAY_OF_MONTH));
		cal.set(HOUR_OF_DAY, cal.getActualMinimum(HOUR_OF_DAY));
		cal.set(MINUTE,cal.getActualMinimum(MINUTE));
		cal.set(SECOND,cal.getActualMinimum(SECOND));
		setBeginDate(cal.getTime());
		cal.set(MONTH, cal.getActualMaximum(MONTH));
		cal.set(DAY_OF_MONTH,cal.getActualMaximum(DAY_OF_MONTH));
		cal.set(HOUR_OF_DAY, cal.getActualMaximum(HOUR_OF_DAY));
		cal.set(MINUTE,cal.getActualMaximum(MINUTE));
		cal.set(SECOND,cal.getActualMaximum(SECOND));
		setEndDate(cal.getTime());
	}
	/**
	 * 分别设置开始结束为这个时间所在年份的第一天 00:00:00,最后一天的23:59:59
	 * @param date 时间基点
	 * @return 设置好的时间区间
	 */
	public static TimeInterval getIntervalByYear(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setIntervalByYear(date);
		return timeInterval;
	}

	/**
	 * 获取开始时间到结束时间中的每一分钟的00秒到59秒的时间区间，
	 * 不包含开始结束所在的分钟。
	 * 如果没有符合条件的结果则返回空的列表
	 * @author Virde
	 * 2018年11月1日 10:24:41
	 * @return
	 */
	public List<TimeInterval> getIntervalOfEveryMinute(){
		// # 初始化参数
		List<TimeInterval> respList = new ArrayList<TimeInterval>();
		Calendar cal = getInstance();
		
		// # 重新生成开始结束时间
		// * 重新生成开始时间
		cal.setTime(beginDate);
		int startSecond = cal.get(SECOND);
		if(startSecond != 0) {
			cal.add(MINUTE, +1);
			cal.set(SECOND, 0);
		}
		Date start = cal.getTime();
		// * 重新生成结束时间
		cal.setTime(endDate);
		int endSecond = cal.get(SECOND);
		if(endSecond != 0) {
			cal.set(SECOND, 0);
			cal.add(MINUTE, -1);
		}
		Date end = cal.getTime();
		
		// # 如果开始时间在结束时间之后，则返回空列表
		if(start.after(end)) {
			return respList;
		}
		
		// # 根据初始化之后的开始结束时间生成区间列表并返回
		while(start.before(end)) {
			TimeInterval ti = getIntervalByMinute(start);
			respList.add(ti);
			cal.setTime(start);
			cal.add(MINUTE, +1);
			start = cal.getTime();
		}
		
		return respList;
	}

	public static List<TimeInterval> getIntervalOfEveryMinute(Date startDate,Date endDate){
		return new TimeInterval(startDate,endDate).getIntervalOfEveryMinute();
	}
	/**
	 * 获取开始时间到结束时间中间的每一个小时，不包含开始时间和结束时间所在的小时
	 * 如果没有符合条件的结果则返回空的列表
	 * @author Virde
	 * 2018年8月22日 17:04:46
	 * @return 返回开始时间到结束时间之间的每小时区间列表
	 */
	public List<TimeInterval> getIntervalOfEveryHour() {
		// # 初始化参数
		List<TimeInterval> respList = new ArrayList<TimeInterval>();
		Calendar cal = getInstance();
		
		// # 重新生成开始结束时间
		// * 重新生成开始时间
		cal.setTime(beginDate);
		int startMinute = cal.get(MINUTE);
		int startSecond = cal.get(SECOND);
		if(startMinute != 0 || startSecond != 0) {
			cal.add(HOUR_OF_DAY, +1);
			cal.set(MINUTE, 0);
			cal.set(SECOND, 0);
		}
		Date start = cal.getTime();
		// * 重新生成结束时间
		cal.setTime(endDate);
		int endMinute = cal.get(MINUTE);
		int endSecond = cal.get(SECOND);
		if(endMinute != 0 || endSecond != 0) {
			cal.set(MINUTE, 0);
			cal.set(SECOND, 0);
			cal.add(SECOND, -1);
		}
		Date end = cal.getTime();
		
		// # 如果开始时间在结束时间之后，则返回空列表
		if(start.after(end)) {
			return respList;
		}
		
		// # 根据初始化之后的开始结束时间生成区间列表并返回
		while(start.before(end)) {
			TimeInterval ti = getIntervalByHour(start);
			respList.add(ti);
			
			cal.setTime(start);
			cal.add(HOUR_OF_DAY, +1);
			start = cal.getTime();
		}
		
		return respList;
	}
	/**
	 * 获取开始时间到结束时间中间的每一个小时，不包含开始时间和结束时间所在的小时
	 * 如果没有符合条件的结果则返回空的列表
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @return 开始时间到结束时间之间的每小时区间列表
	 */
	public static List<TimeInterval> getIntervalOfEveryHour(Date startDate,Date endDate){
		return new TimeInterval(startDate,endDate).getIntervalOfEveryHour();
	}
	/**
	 * 获取开始时间到结束时间中间的每一天，不包含开始结束时间所在的天
	 * 如果没有符合条件的结果则返回空的列表
	 * @author Virde
	 * 2018年8月22日 17:04:46
	 * @return 返回
	 */
	public List<TimeInterval> getIntervalOfEveryDay() {
		// 初始化必要变量
		List<TimeInterval> respList = new ArrayList<TimeInterval>();
		Calendar cal = getInstance();
		
		// 计算出到开始时间
		cal.setTime(beginDate);
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
		
		// 计算出结束时间
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
		
		// 如果开始时间在结束时间之后，则返回空的列表
		if(start.after(end)) {
			return respList;
		}
		
		// 根据开始时间结束时间生成所有节点的时间
		while(start.before(end)) {
			TimeInterval ti = getIntervalByDay(start);
			respList.add(ti);
			
			cal.setTime(start);
			cal.add(DAY_OF_MONTH, +1);
			start = cal.getTime();
		}
		
		// 返回结果
		return respList;
	}

	public static List<TimeInterval> getIntervalOfEveryDay(Date startDate,Date endDate){
		return new TimeInterval(startDate,endDate).getIntervalOfEveryDay();
	}
	/**
	 * 获取开始时间到结束时间中间的每一个月，不包含开始结束时间所在的月
	 * 如果没有符合条件的结果则返回空的列表
	 * @author Virde
	 * 2018年8月22日 17:04:46
	 * @return 返回
	 */
	public List<TimeInterval> getIntervalOfEveryMonth() {
		List<TimeInterval> respList = new ArrayList<TimeInterval>();
		Calendar cal = getInstance();
		cal.setTime(beginDate);
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
	public static List<TimeInterval> getIntervalOfEveryMonth(Date startDate,Date endDate){
		return new TimeInterval(startDate,endDate).getIntervalOfEveryMonth();
	}
	/**
	 * 获取开始时间到结束时间中间的每一天
	 * Author Virde
	 * time 2018年9月11日 09:20:42
	 * @param isContainCurr 是否包含开始结束时间当天
	 * @return 生成的每一天的Date集合
	 */
	public List<Date> getEveryDay(Boolean isContainCurr) {
		// 初始化参数
		List<Date> respList = new ArrayList<Date>();
		Calendar startCal = getInstance();
		Calendar endCal = getInstance();
		startCal.setTime(beginDate);
		endCal.setTime(endDate);
		// 计算出开始结束时间
		if(isContainCurr) {
			startCal.set(HOUR_OF_DAY, 0);
			startCal.set(MINUTE, 0);
			startCal.set(SECOND, 0);
			endCal.set(HOUR_OF_DAY, 0);
			endCal.set(MINUTE, 0);
			endCal.set(SECOND, 0);
			endCal.add(DAY_OF_MONTH, +1);
		}else {
			if(startCal.get(HOUR_OF_DAY)!=0&&startCal.get(MINUTE)!=0&&startCal.get(SECOND)!=0) {
				startCal.set(HOUR_OF_DAY, 0);
				startCal.set(MINUTE, 0);
				startCal.set(SECOND, 0);
			}
			startCal.add(DAY_OF_MONTH, +1);
			if(endCal.get(HOUR_OF_DAY)!=0&&endCal.get(MINUTE)!=0&&endCal.get(SECOND)!=0) {
				endCal.set(HOUR_OF_DAY, 0);
				endCal.set(MINUTE, 0);
				endCal.set(SECOND, 0);
			}
		}

		// 如果开始时间在结束时间之后，则返回空的列表
		if(startCal.getTime().after(endCal.getTime())) {
			return respList;
		}
		// 根据开始结束时间生成列表

		while(startCal.getTime().before(endCal.getTime())) {
			respList.add(startCal.getTime());
			startCal.add(DAY_OF_MONTH, +1);
		}
		return respList;
	}
	public List<Date> getEveryDay() {
		return getEveryDay(true);
	}
	public List<Date> getEveryHour(Boolean isContainCurr) {
		// 初始化参数
		List<Date> respList = new ArrayList<Date>();
		Calendar startCal = getInstance();
		Calendar endCal = getInstance();
		startCal.setTime(beginDate);
		endCal.setTime(endDate);
		// 计算出开始结束时间
		if(isContainCurr) {
			startCal.set(MINUTE, 0);
			startCal.set(SECOND, 0);
			endCal.set(MINUTE, 0);
			endCal.set(SECOND, 0);
			endCal.add(HOUR_OF_DAY, +1);
		}else {
			if(startCal.get(MINUTE)!=0&&startCal.get(SECOND)!=0) {
				startCal.set(MINUTE, 0);
				startCal.set(SECOND, 0);
			}
			startCal.add(HOUR_OF_DAY, +1);
			if(endCal.get(MINUTE)!=0&&endCal.get(SECOND)!=0) {
				endCal.set(MINUTE, 0);
				endCal.set(SECOND, 0);
			}
		}

		// 如果开始时间在结束时间之后，则返回空的列表
		if(startCal.getTime().after(endCal.getTime())) {
			return respList;
		}
		// 根据开始结束时间生成列表

		while(startCal.getTime().before(endCal.getTime())) {
			respList.add(startCal.getTime());
			startCal.add(HOUR_OF_DAY, +1);
		}
		return respList;
	}
	public List<Date> getEveryHour() {
		return getEveryHour(false);
	}
	public static TimeInterval getTodayInterval() {
		return getIntervalByDay(new Date());
	}
	public static TimeInterval getYesterdayInterval() {
		return getIntervalByDay(DateTime.addTime(new Date(), Calendar.DAY_OF_MONTH, -1));
	}
	public static TimeInterval getThisMonth() {
		return getIntervalByMonth(new Date());
	}
	public static TimeInterval getLastMonth() {
		return getIntervalByMonth(DateTime.addTime(new Date(), Calendar.MONTH, -1));
	}
	/**
	 * 往前倒推，计算时间间隔
	 * @param start 往前推的数量
	 * @param end 往前推的数量
	 * @param UNIT 时间单位，使用Calendar获取
	 * @return
	 */
	public static TimeInterval getInterval(int start,int end,int UNIT) {
		return new TimeInterval(DateTime.addTime(new Date(), UNIT, start),DateTime.addTime(new Date(), UNIT, end));
	}
	public String toJSONString() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("startDate", DateTime.toString(getBeginDate()));
		map.put("endDate", DateTime.toString(getEndDate()));
		return Nym.json.objectToJsonString(map);
	}
}
