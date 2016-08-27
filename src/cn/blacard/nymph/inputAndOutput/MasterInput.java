package cn.blacard.nymph.inputAndOutput;

import java.util.Scanner;

public class MasterInput {
	private static final Scanner sca = new Scanner(System.in);
		
	
	public static String getMasterInput(){
		return sca.nextLine();
	}
	
	public static String[] getMasterInputs(){
		return getMasterInput().split(" ");
	}
}
