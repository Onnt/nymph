package cn.virde.nymph;

import java.util.Date;

public class NymLog {
	
	private String name ;
	
	public NymLog(String className){
		this.name = className ;
	}
	
	public void i(String msg){
        StringBuffer sb = new StringBuffer();     
        StackTraceElement[] stacks = new Throwable().getStackTrace();    
        int stacksLen = stacks.length;    
        sb.append("class: " ).append(stacks[1].getClassName()).append("; method: ").append(stacks[1].getMethodName()).append("; number: ").append(stacks[1].getLineNumber()).append("/n");    
        System.out.println(sb);
		String time = Nym.time.toString(new Date(), "hh:mm:ss");
		System.out.println(name + " " + time + " : "+ msg);
	}
	public static void i(String name,String msg){
		String time = Nym.time.toString(new Date(), "hh:mm:ss");
		System.out.println(name + " " + time + " : "+ msg);
	}
	public void i(String msg,Exception e){
		String time = Nym.time.toString(new Date(), "hh:mm:ss");
		System.out.println(name + " " + time + " : "+ msg);
		System.out.println("错误信息："+e.getMessage());
	}
	
	

	public static String getTraceInfo(){    
        StackTraceElement[] stacks = new Throwable().getStackTrace();   
        StringBuffer sb = new StringBuffer();      
        int stacksLen = stacks.length;    
        sb.append("class: " ).append(stacks[1].getClassName()).append("; method: ").append(stacks[1].getMethodName()).append("; number: ").append(stacks[1].getLineNumber()).append("/n");    
            
        return sb.toString();    
    }    

	//String _methodName =  
	//  
	//new Exception().getStackTrace()[1].getMethodName();// 获得调用者的方法名  
	//  
	//String _thisMethodName =  
	//  
	//new Exception().getStackTrace()[0].getMethodName();// 获得当前的方法名 
	
}
