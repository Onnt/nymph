package cn.virde.nymph.sort;

import java.util.ArrayList;
import java.util.List;

public class SortTest {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("张三 12",12));
		list.add(new Person("李四 6",6));
		list.add(new Person("王五 5",5));
		list.add(new Person("周六 36",36));
		list.add(new Person("孙七87",87));
		
//		Collections.sort(list);
		list.sort(null);
		for(Person p : list) {
			System.out.println(p.getAge());
		}
	}
}


class Person implements Comparable<Person>{
	private String name ;
	private int age ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
//	@Override
//	public int compare(Person o1, Person o2) {
//		if(o1.getAge() > o2.getAge())
//			return 1 ;
//		else
//			return -1 ;
//	}
	@Override
	public int compareTo(Person o) {
		if(this.getAge() > o.getAge())
			return 1;
		else
			return -1 ;
	}
	
}