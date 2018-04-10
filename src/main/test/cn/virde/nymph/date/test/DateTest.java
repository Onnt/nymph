package cn.virde.nymph.date.test;

import java.util.Date;

import cn.virde.nymph.Nym;

public class DateTest {
	public static void main(String[] args) {
		long tims = new Date().getTime() ;
		System.out.println(Nym.time.toString(tims));
				 
	}
}