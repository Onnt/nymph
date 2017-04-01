package cn.test;

public class Test2 {
	public static void main(String[] args) {
		new SomeDeal().aMethod().bMethod().cMethod().fMethod().aMethod();
	}
}
class SomeDeal{
	public SomeDeal aMethod(){
		System.out.println("你调用了a方法");
		return this;
	}

	public SomeDeal bMethod(){
		System.out.println("你调用了b方法");
		return this;
	}

	public SomeDeal cMethod(){
		System.out.println("你调用了c方法");
		return this;
	}

	public SomeDeal dMethod(){
		System.out.println("你调用了d方法");
		return this;
	}

	public SomeDeal eMethod(){
		System.out.println("你调用了e方法");
		return this;
	}

	public SomeDeal fMethod(){
		System.out.println("你调用了f方法");
		return this;
	}
	
}