package cn.virde.test;

import java.io.File;

import cn.virde.nymph.Nym;

public class TestA{
	
	public static void main(String[] args) throws Exception {
		File file = new File("C://opt/1.mp3");
		File toFile = new File("C://opt/2.mp3");
		
		Nym.file.move(file, toFile);
	}
	
}
