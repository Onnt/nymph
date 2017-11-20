package cn.virde.nymph.test.thread;

public class ThreadTest {

	public static void main(String[] args) {
		final Person p = new Person();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
//					synchronized (Person.class) {
						p.setName("A");
						if(p.getName().equals("B")) System.out.println("A - 线程冲突");
//					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
//					synchronized (Person.class) {
						p.setName("B");
						if(p.getName().equals("A")) System.out.println("B - 线程冲突");
//					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {}
				}
			}
		}).start();
	}
}

class Person{
	private String name ;

	public String getName() {
		synchronized (this) {
			return name;			
		}
	}

	public void setName(String name) {
		synchronized (this) {
			this.name = name;			
		}
	}
	
}