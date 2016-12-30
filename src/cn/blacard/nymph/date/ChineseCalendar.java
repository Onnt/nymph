package cn.blacard.nymph.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ChineseCalendar { 
	
	public static Date toSunDate(Date moonDate){
		Calendar cal = Calendar.getInstance();
		cal.setTime(moonDate);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String chineseDateStr = ChineseCalendarDeal.sCalendarLundarToSolar(year, month, day);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date resultDate = null;
		try {
			resultDate = format.parse(chineseDateStr);
			//减去偏移量
			resultDate = NymTime.addTime(resultDate, Calendar.DAY_OF_MONTH, -1);
		} catch (ParseException e) {
			System.out.println("ChineseCalendar - toChineseDate ： 将结果字符转换为Date类型时发生异常");
			e.printStackTrace();
		}
		return resultDate;
	}
	public static Date toSunDate(String moonDate){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return toSunDate(format.parse(moonDate));
		} catch (ParseException e) {
			System.out.println("ChineseCalendar - toSunDate(String moonDate)：时间转换为Date类型时出现异常");
			e.printStackTrace();
		}
		return null;
	}
	public static Date toMoonDate(Date sunDate){
		return null;
	}
}