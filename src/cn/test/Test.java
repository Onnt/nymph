package cn.test;

import cn.blacard.nymph.Nym;

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
		System.out.println(Nym.time.toString(Nym.chineseCalendar.toSunDate(Nym.time.toDate("2017-01-02"))));
	}
}