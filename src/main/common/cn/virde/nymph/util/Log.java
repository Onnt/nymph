package cn.virde.nymph.util;

import java.util.Date;

import cn.virde.nymph.Nym;

public class Log {
	//TODO 模式切换，日志文件输出模式 和 控制台输出模式 以及 双输出模式
	
	public static void info(String msg){
		
        String traceInfo = getTraceInfo(new Throwable().getStackTrace());
		String time = Nym.time.toString(new Date(), "hh:mm:ss");
		
		System.out.println(time + " " + msg );
		System.out.println(traceInfo);
		
	}
	public static void info(String msg,Exception e){
		
        String traceInfo = getTraceInfo(new Throwable().getStackTrace());
		String time = Nym.time.toString(new Date(), "hh:mm:ss");
		
		System.out.println(time + " " + msg + "。 异常信息："+e.getMessage());
		System.out.println(traceInfo);
		
	}
	
	private static String getTraceInfo(StackTraceElement[] stacks){
        StringBuffer sb = new StringBuffer();     
        sb.append("class: " ).append(stacks[1].getClassName()).append("; method: ").append(stacks[1].getMethodName()).append("; number: ").append(stacks[1].getLineNumber());
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
