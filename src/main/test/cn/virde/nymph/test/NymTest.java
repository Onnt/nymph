package cn.virde.nymph.test;

import java.io.IOException;

import org.junit.Test;

import cn.virde.nymph.Nym;

public class NymTest {

	@Test
	public void nym() throws IOException{
		System.out.println(Nym.ip.getLocationByIp("180.169.14.34"));
	}
}
