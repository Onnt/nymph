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
	 * 设置时间区间为这一分钟
	 * @author Virde
	 * 2018年11月1日 10:40:47
	 * 2019年3月28日 11:35:02
	 * @param date 时间基点
	 */
	public void setThisMinute(Date date) {
		Calendar cal = getInstance();
		cal.setTime(date);
		cal.set(SECOND,cal.getActualMinimum(SECOND));
		setBeginDate(cal.getTime());
		cal.set(SECOND,cal.getActualMaximum(SECOND));
		setEndDate(cal.getTime());
	}

	/**
	 * 获取这一分钟的区间
	 * @author Virde
	 * 2018年11月1日 10:40:47
	 * 2019年3月28日 11:35:08
	 * @param date 时间基点
	 * @return 生成好的时间区间
	 */
	public static TimeInterval getThisMinute(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setThisMinute(date);
		return timeInterval;
	}
	/**
	 *  设置时间区间为这一小时
	 * @author Virde
	 * 2018年8月22日 17:04:46
	 *  2019年3月28日 11:34:49
	 */
	public void setThisHour(Date date) {
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
	 *  获取这一小时的时间区间
	 * @param date 这一小时
	 * @return 设置好的时间区间
	 * @author Virde
	 * 2018年10月24日 19:39:17
	 * 2019年3月28日 11:45:50
	 * 
	 */
	public static TimeInterval getThisHour(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setThisHour(date);
		return timeInterval;
	}
	/**
	 * 设置这一日的时间区间
	 * @author Virde
	 * 2018年8月22日 17:04:46
	 * 2019年3月28日 11:46:25
	 */
	public void setThisDay(Date date) {
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
	 * 获取这一日的时间区间
	 * 这个时间的00:00:00,23:59:59
	 * @param date 时间基数
	 * @return 设好的时间区间
	 * @author Virde
	 * 2018年10月24日 19:42:29
	 * 2019年3月28日 11:48:03
	 */
	public static TimeInterval getThisDay(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setThisDay(date);
		return timeInterval;
	}
	
	/**
	 * 设置这一周的时间区间
	 * 分别设置开始结束为这个时间的周一 00:00:00,周日 23:59:59
	 *  2019年3月28日 11:48:14
	 * @param date 时间基点
	 */
	public void setThisWeek(Date date) {
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
	 * 获取这一周的时间区间
	 * 开始结束为这个时间的周一 00:00:00,周日 23:59:59
	 * 2019年3月28日 11:48:31
	 * @param date 时间基点
	 * @return 设置好的时间区间
	 */
	public static TimeInterval getThisWeek(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setThisWeek(date);
		return timeInterval;
	}
	/**
	 * 设置这个月的时间区间
	 * 设置开始时间为这个月的1日 00:00:00，
	 * 结束时间为这个月最后一天的23:59:59
	 * @author Virde
	 * 2018年8月22日 17:04:46
	 * 2019年3月28日 11:50:02
	 */
	public void setThisMonth(Date date) {
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
	/**
	 * 获取这个月的时间区间
	 * 开始时间为这个月的1日 00:00:00，
	 * 结束时间为这个月最后一天的23:59:59
	 * @author Virde
	 * 2018年8月22日 17:04:46
	 * 2019年3月28日 11:50:02
	 */
	public static TimeInterval getThisMonth(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setThisMonth(date);
		return timeInterval;
	}
	/**
	 * 设置这一年的时间区间
	 * 设置开始时间为这一年的第一天的00:00:00，
	 * 结束时间为这一年最后一天的23:59:59
	 * @author Virde
	 * 2018年8月22日 17:04:46
	 * 2019年3月28日 11:52:14
	 */
	public void setThisYear(Date date) {
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
	 * 获取这一年的时间区间
	 * 开始结束为这个时间所在年份的第一天 00:00:00,最后一天的23:59:59
	 * 2019年3月28日 11:52:35
	 * @param date 时间基点
	 * @return 设置好的时间区间
	 */
	public static TimeInterval getThisYear(Date date) {
		TimeInterval timeInterval = new TimeInterval();
		timeInterval.setThisYear(date);
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
	public List<TimeInterval> intervalOfEveryMinute(){
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
			TimeInterval ti = getThisMinute(start);
			respList.add(ti);
			cal.setTime(start);
			cal.add(MINUTE, +1);
			start = cal.getTime();
		}
		
		return respList;
	}

	public static List<TimeInterval> intervalOfEveryMinute(Date startDate,Date endDate){
		return new TimeInterval(startDate,endDate).intervalOfEveryMinute();
	}
	/**
	 * 获取开始时间到结束时间中间的每一个小时，不包含开始时间和结束时间所在的小时
	 * 如果没有符合条件的结果则返回空的列表
	 * @author Virde
	 * 2018年8月22日 17:04:46
	 * @return 返回开始时间到结束时间之间的每小时区间列表
	 */
	public List<TimeInterval> intervalOfEveryHour() {
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
			TimeInterval ti = getThisHour(start);
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
	public static List<TimeInterval> intervalOfEveryHour(Date startDate,Date endDate){
		return new TimeInterval(startDate,endDate).intervalOfEveryHour();
	}
	/**
	 * 获取开始时间到结束时间中间的每一天，不包含开始结束时间所在的天
	 * 如果没有符合条件的结果则返回空的列表
	 * @author Virde
	 * 2018年8月22日 17:04:46
	 * @return 返回
	 */
	public List<TimeInterval> intervalOfEveryDay() {
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
			TimeInterval ti = getThisDay(start);
			respList.add(ti);
			
			cal.setTime(start);
			cal.add(DAY_OF_MONTH, +1);
			start = cal.getTime();
		}
		
		// 返回结果
		return respList;
	}

	public static List<TimeInterval> intervalOfEveryDay(Date startDate,Date endDate){
		return new TimeInterval(startDate,endDate).intervalOfEveryDay();
	}
	/**
	 * 获取开始时间到结束时间中间的每一个月，不包含开始结束时间所在的月
	 * 如果没有符合条件的结果则返回空的列表
	 * @author Virde
	 * 2018年8月22日 17:04:46
	 * @return 返回
	 */
	public List<TimeInterval> intervalOfEveryMonth() {
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
			TimeInterval ti = getThisMonth(start);
			respList.add(ti);
			
			cal.setTime(start);
			cal.add(MONTH, +1);
			start = cal.getTime();
		}
		
		return respList;
	}
	public static List<TimeInterval> intervalOfEveryMonth(Date startDate,Date endDate){
		return new TimeInterval(startDate,endDate).intervalOfEveryMonth();
	}
	/**
	 * 获取开始时间到结束时间中间的每一天
	 * Author Virde
	 * time 2018年9月11日 09:20:42
	 * @param isContainCurr 是否包含开始结束时间当天
	 * @return 生成的每一天的Date集合
	 */
	public List<Date> dateOfEveryDay(Boolean isContainCurr) {
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
	public List<Date> dateOfEveryDay() {
		return dateOfEveryDay(true);
	}
	public List<Date> dateOfEveryHour(Boolean isContainCurr) {
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
	public List<Date> dateOfEveryHour() {
		return dateOfEveryHour(false);
	}
	public static TimeInterval getTodayInterval() {
		return getThisDay(new Date());
	}
	public static TimeInterval getYesterdayInterval() {
		return getThisDay(DateTime.addTime(new Date(), Calendar.DAY_OF_MONTH, -1));
	}
	public static TimeInterval getThisMonth() {
		return getThisMonth(new Date());
	}
	public static TimeInterval getLastMonth() {
		return getThisMonth(DateTime.addTime(new Date(), Calendar.MONTH, -1));
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
	public int diffSeconds(){
		return diffSeconds(this.beginDate,this.endDate);
	}
	public int diffSeconds(Date beginDate,Date endDate){
		return (int) (endDate.getTime() - beginDate.getTime())/1000;
	}
	public int diffMinutes(){
		return diffMinutes(this.beginDate,this.endDate);
	}
	public static int diffMinutes(Date beginDate,Date endDate){
		return diffSeconds(beginDate,endDate)/60;
	}
	public int diffHours(){
		return diffHours(this.beginDate,this.endDate);
	}
	public static int diffHours(Date beginDate,Date endDate){
		return diffMinutes(beginDate,endDate)/60;
	}
	public int diffDays(){
		return diffDays(this.beginDate,this.endDate);
	}
	public static int diffDays(Date beginDate,Date endDate){
		return diffHours(beginDate,endDate)/24;
	}
	public int diffMonths(){
		return 0;
	}
	public int diffMonths(Date beginDate,Date endDate){
		return 0;
	}
	public int diffYears(){
		return 0;
	}
	public static int diffYears(Date beginDate,Date endDate){
		return 0;
	}
	private int diff(int UNIT){
		return 0;
	}
	public String toJSONString() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("startDate", DateTime.toString(getBeginDate()));
		map.put("endDate", DateTime.toString(getEndDate()));
		return Nym.json.objectToJsonString(map);
	}
}
