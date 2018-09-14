package cn.virde.test;

public class TestException {
	public static void main(String[] args) {
		Excep ep = new Excep();
		ep.onException(()->{
			System.out.println("Hi,发生了一个异常");
		});
		ep.haha();
	}
	
}

class Excep{
	
	private OnError oe ;
	
	public void haha() {
		try {
			throw new Exception("发生一个异常");
		} catch (Exception e) {
			oe.doSomeThing();
		}
	}

	public void onException(OnError oe) {
		this.oe = oe ;
	}
	
}
