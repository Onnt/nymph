package cn.virde.nymph.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


import cn.virde.nymph.Nymph;

public class NymHttp implements Nymph{
	
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
			log.i("打开链接时出现错误，操作已经终止",e);
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
			log.i("Connection在打开实际链接时出现异常",e);
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
			log.i("从BufferReader中获取返回值时出现异常",e);
			return null;
		}
	}
	private boolean getReader(){
		try {
			reader = new BufferedReader(new InputStreamReader(
			        connection.getInputStream()));
			return true ;
		} catch (IOException e) {
			log.i("获取BufferReader时出现异常",e);
			return false ;
		}
	}
	public static String post(){
		return null;
	}
	
}
