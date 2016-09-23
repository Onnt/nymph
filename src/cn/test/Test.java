package cn.test;

import java.io.IOException;

import cn.blacard.nymph.date.NymTime;
import cn.blacard.nymph.text.NymProperties;

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
		String time =NymTime.toTime(NymTime.timestampToDate(1443418222l));
		System.out.println("time:"+time);
	}
	/**
	 * 测试properties参数获取
	 * @author Blacard
	 * @create 2016年9月22日 下午4:23:10
	 * @param args
	 * @throws IOException 
	 */
	public static void main_proper(String[] args) throws IOException {
		NymProperties nymPptis = new NymProperties("src/cn/test/hehe.properties");
		System.out.println(nymPptis.getValue("username"));
	}

}
