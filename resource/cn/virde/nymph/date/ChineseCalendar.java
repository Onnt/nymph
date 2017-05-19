package cn.virde.nymph.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.virde.nymph.Nym;

/**
 * 中国农历 转换工具
 * @author Blacard
 * @联系方式 邮箱：blacard@163.com <br/> 手机：18037170703
 * @create 2017年2月7日 下午4:04:44
 */
public class ChineseCalendar { 
	
	/**
	 * 农历转换为阳历
	 * @author Blacard
	 * @create 2017年2月7日 下午4:05:18
	 * @param moonDate 农历
	 * @return 阳历
	 */
	public Date toSunDate(Date moonDate){
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
			resultDate = Nym.time.addTime(resultDate, Calendar.DAY_OF_MONTH, -1);
		} catch (ParseException e) {
			System.out.println("ChineseCalendar - toChineseDate ： 将结果字符转换为Date类型时发生异常");
			e.printStackTrace();
		}
		return resultDate;
	}
	
	/**
	 * 阳历转换为农历，暂时未完成
	 * @author Blacard
	 * @create 2017年2月7日 下午4:08:51
	 * @param sunDate
	 * @return
	 */
	public Date toMoonDate(Date sunDate){
		return null;
	}
}