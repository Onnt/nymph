package cn.virde.nymph;

import java.util.Date;

public class Nymph {
	
	public void log(String msg){
		String name = this.getClass().getName();
		String time = Nym.time.toString(new Date(), "hh:mm:ss");
		System.out.println(name + " " + time + " : "+ msg);
	}
	
}
