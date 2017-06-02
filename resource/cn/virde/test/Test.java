package cn.virde.test;

import cn.virde.nymph.Nym;

public class Test{
	
	public static void main(String[] args) throws Exception {
		
		String str = Nym.code.encode("{name:'user',pass:'pass'}", "sdfsd");
		
		System.out.println(str);
		
		System.out.println(Nym.code.decode(str));
		
	}
	
}
