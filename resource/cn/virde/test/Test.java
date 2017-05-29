package cn.virde.test;


import java.util.Set;

import cn.virde.nymph.net.page.Page;

public class Test {	
	public static void main(String[] args) {
		Page page = new Page("http://www.mmjpg.com/mm/997");
		
		System.out.println(page.getHtml());
		
		Set<String> urls = page.getUrls();
		for(String s : urls ){
			System.out.println(s);
		}
		
	}
}
