package cn.virde.test;

import cn.virde.nymph.Nym;

public class Test{
	
	public static void main(String[] args) {
		
		String str = Nym.http.get("http://hot.ynet.com/2017/05/31/177422t1593.html");
		
		System.out.println(str);
		
	}
	
}
