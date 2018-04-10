package cn.virde.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.virde.nymph.Nym;

public class TestA{
	public static void main(String[] args) {
		System.out.println(new Sun().test().name);
	}
}

class Person{
	public String name = "f" ;
	public Person test() {
		return this ;
	}
}
class Sun extends Person {

	public String name = "s" ;
	
	@Override
	public Sun test() {
		super.test();
		return this ;
	}
}