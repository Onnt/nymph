package cn.test;

import cn.blacard.nymph.date.ChineseCalendar;

/**
 * 
 * <h3>title:</h3>
 * <p>测试类</p>
 * @author Blacard
 * @createTime 下午2:21:40
 * @e_mail blacard@163.com
 * @phone 18037170703
 */
public class Test {
	public static void main(String[] args) {
		String solar = ChineseCalendar.sCalendarLundarToSolar(2016, 10, 11);
		System.out.println(solar);
	}
}