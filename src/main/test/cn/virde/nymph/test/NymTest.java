package cn.virde.nymph.test;

import java.io.IOException;
import java.util.Set;

import org.junit.Test;

import cn.virde.nymph.Nym;
import cn.virde.nymph.net.page.Page;

public class NymTest {

	@Test
	public void nym() throws IOException{
		System.out.println(Nym.http.get("http://5sing.kugou.com/"));
		Page page = new Page("http://5sing.kugou.com/");
		Set<String> sets = page.getUrls();
		for(String s : sets){
			System.out.println(s);
		}
	}
	
}

