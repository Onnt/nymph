package cn.blacard.nymph.inputAndOutput;

import java.util.Scanner;

public class OrderAnaly {
	private static final Scanner sca = new Scanner(System.in);
		
	
	public static String getOrder(){
		return sca.nextLine();
	}
	
	public static String[] getOrders(){
		return getOrder().split(" ");
	}
}
