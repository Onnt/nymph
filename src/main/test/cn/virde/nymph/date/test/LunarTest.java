package cn.virde.nymph.date.test;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import cn.virde.nymph.Nym;

public class LunarTest {
	
	/**
	 * 公农历转换测试
	 * @throws ParseException 
	 */
	@Test
	public void lunarDateTrans() throws ParseException {
		
		Date lunarDate = Nym.lunar.toLunarDate(new Date());
		
		System.out.println("今天农历日期：" + Nym.time.toString(lunarDate));
		
		Date date = Nym.lunar.lunarDateTo(lunarDate);
		
		System.out.println("今天公历日期：" + Nym.time.toString(date));
		
		
	}
}
