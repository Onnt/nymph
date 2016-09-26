package cn.blacard.nymph.inputAndOutput;

import java.util.Scanner;

/**
 * 这个类也有点儿蠢，‘
 * 也遗弃吧
 * @author Blacard
 * @联系方式 邮箱：blacard@163.com <br/> 手机：18037170703
 * @create 2016年9月26日 上午11:24:25
 */
@Deprecated
public class OrderAnaly {
	private static final Scanner sca = new Scanner(System.in);
		
	
	public static String getOrder(){
		return sca.nextLine();
	}
	
	public static String[] getOrders(){
		return getOrder().split(" ");
	}
}
