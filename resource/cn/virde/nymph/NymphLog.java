package cn.virde.nymph;

import java.util.Date;

public class NymphLog {
	public void i(String msg){
		String name = this.getClass().getName();
		String time = Nym.time.toString(new Date(), "hh:mm:ss");
		System.out.println(name + " " + time + " : "+ msg);
	}
	public static void i(String name,String msg){
		String time = Nym.time.toString(new Date(), "hh:mm:ss");
		System.out.println(name + " " + time + " : "+ msg);
	}
	public void i(String msg,Exception e){
		String name = this.getClass().getName();
		String time = Nym.time.toString(new Date(), "hh:mm:ss");
		System.out.println(name + " " + time + " : "+ msg);
		System.out.println("错误信息："+e.getMessage());
	}
}
