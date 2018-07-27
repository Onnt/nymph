package cn.virde.test;

import cn.virde.nymph.code.AES;

public class TestA{
	public static void main(String[] args) {
		String key = "3234sadf" ;
		System.out.println(AES.encode("哈哈哈哈哈哈哈。asdf32342345《<>你是傻逼吧", key));
		
		System.out.println(AES.decode("493B3C7C5957687829B31862F0A50FEF1C017A1E77BF3FADFD1F79A56171B80D9A5EBD2CE4DF7885B90478450696770C7BF5378E41463EA4404FC929E462087F", key));
		
	}
}
