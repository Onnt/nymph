

import java.util.Scanner;
/**
 * 这个类有点蠢，遗弃吧
 * @author Blacard
 * @联系方式 邮箱：blacard@163.com <br/> 手机：18037170703
 * @create 2016年9月26日 上午11:23:52
 */
@Deprecated
public class MasterInput {
	private static final Scanner sca = new Scanner(System.in);
		
	
	public static String getMasterInput(){
		return sca.nextLine();
	}
	
	public static String[] getMasterInputs(){
		return getMasterInput().split(" ");
	}
}
