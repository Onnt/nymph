package cn.virde.nymph.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.virde.nymph.util.Log;

public class NymHttp{

	private URLConnection connection ;
	private BufferedReader reader ; 
	
	public String get(String str){
		if(!getURLConnect(str)) return null;
		setReqeustPara();
		if(!connect()) return null;
		if(!getReader()) return null;
		
		return getRespStr();
	}
	
	private boolean getURLConnect(String str){
		URL url;
		try {
			url = new URL(str);
			connection = url.openConnection();
			return true ;
		} catch (IOException e) {
			Log.info("请求时出现错误，操作已经终止，请求：" + str,e);
			return false;
		}
	}
	private void setReqeustPara(){
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	}
	private boolean connect(){
		try {
			connection.connect();
			return true ;
		} catch (IOException e) {
			Log.info("Connection在打开实际链接时出现异常",e);
			return false ;
		}
	}
	
	private String getRespStr(){
        try {
            String line;
            StringBuffer result = new StringBuffer();
			while ((line = reader.readLine()) != null) {
			    result.append(line);
			}
			return result.toString() ; 
		} catch (IOException e) {
			Log.info("从BufferReader中获取返回值时出现异常",e);
			return null;
		}
	}
	private boolean getReader(){
		try {
			reader = new BufferedReader(new InputStreamReader(
			        connection.getInputStream(),getCharset()));
			return true ;
		} catch (IOException e) {
			Log.info("获取BufferReader时出现异常",e);
			return false ;
		}
	}
	private String getCharset(){

        // 网页编码  
        String strencoding = "utf-8";  
  
        /** 
         * 首先根据header信息，判断页面编码 
         */  
        // map存放的是header信息(url页面的头信息)  
        Map<String, List<String>> map = connection.getHeaderFields();  
        Set<String> keys = map.keySet();  
        Iterator<String> iterator = keys.iterator();  
  
        // 遍历,查找字符编码  
        String key = null;  
        String tmp = null;  
        while (iterator.hasNext()) {  
            key = iterator.next();  
            tmp = map.get(key).toString().toLowerCase();  
            // 获取content-type charset  
            if (key != null && key.equals("Content-Type")) {  
                int m = tmp.indexOf("charset=");  
                if (m != -1) {  
                    strencoding = tmp.substring(m + 8).replace("]", "");  
                    return strencoding;  
                }  
            }  
        }  
        return strencoding;  
	}
	public static String post(){
		return null;
	}
	
}
