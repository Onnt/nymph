package cn.virde.nymph.util;

import java.util.Date;

import cn.virde.nymph.Nym;
import cn.virde.nymph.text.TextOut;

public class Log {
	//TODO 模式切换，日志文件输出模式 和 控制台输出模式 以及 双输出模式
	private static String mode = "console" ;
	private static String logFile ;
	
	public static void info(String msg){
		
        String traceInfo = getTraceInfo(new Throwable().getStackTrace());
		String time = Nym.time.toString(new Date(), "hh:mm:ss");
		
		syso(time + " " + msg );
		syso(traceInfo);
		
	}
	
	public static void info(String msg,Exception e){
		
        String traceInfo = getTraceInfo(new Throwable().getStackTrace());
		String time = Nym.time.toString(new Date(), "hh:mm:ss");
		
		syso(time + " " + msg + "。 异常信息："+e.getMessage());
		syso(traceInfo);
		
	}

	public static void info(String msg,String alert){
		
        String traceInfo = getTraceInfo(new Throwable().getStackTrace());
		String time = Nym.time.toString(new Date(), "hh:mm:ss");
		
		syso(time + " " + msg);
		syso("异常提示信息："+alert);
		syso(traceInfo);
		
	}
	
	private static String getTraceInfo(StackTraceElement[] stacks){
        StringBuffer sb = new StringBuffer();     
        sb.append("class: " ).append(stacks[1].getClassName()).append("; method: ").append(stacks[1].getMethodName()).append("; number: ").append(stacks[1].getLineNumber());
        return sb.toString();
	}	
	
	public static void setFileOutMode(String file){
		Log.logFile = file ;
		Log.mode = "fileOut" ;
	}
	public static void setDoubleMode(String file){
		Log.logFile = file ;
		Log.mode = "console_and_file" ;
	}
	
	private static void syso(String text){
		switch(mode){
		case "console" :
			System.out.println(text);
			break;
		case "fileOut" :
			new TextOut(logFile).putln(text);
			break;
		case "console_and_file" :
			System.out.println(text);
			new TextOut(logFile).putln(text);
			break;
		default : ;
		}
	}
}
