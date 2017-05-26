package cn.virde.test;


import java.util.Set;

import cn.virde.nymph.net.page.Page;

public class Test {	
	public static void main(String[] args) {
		Page page = new Page("http://www.50888.com");
		Set<String> urls = page.getUrls();
		for(String s : urls ){
			System.out.println(s);
		}
	}
}
