package cn.virde.nymph.test.util;


public class Test {
	
	public static void main(String[] args) throws Exception {
		ClassA a = new ClassA();
		a.setName("sunao");
		a.setPass("this is pass");
		a.setChecked(false);
		
		ClassB b = BeanCopyUtil.copy(a,ClassB.class);
		System.out.println(b.getName());
		System.out.println(b.getPass());
		System.out.println(b.getChecked());
	}
	
}
