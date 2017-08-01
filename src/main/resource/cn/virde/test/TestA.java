package cn.virde.test;

import cn.virde.nymph.net.page.Page;

public class TestA{
	
	public static void main(String[] args) throws Exception {
		Page page = new Page("http://www.yy.com/shenqu/");
		System.out.println(page.getHtml());
	}
	
}
