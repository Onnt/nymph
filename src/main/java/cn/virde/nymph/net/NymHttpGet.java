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

import cn.virde.nymph.Nym;

@Deprecated
public class NymHttpGet {

	private URLConnection connection ;
	private BufferedReader reader ; 
	
	
	public String get(String url,Map<String,String> params) throws IOException {
		return get(Nym.string.makeUrlWithParams(url, params));
	}
	public String makeUrlWithParams(String url,Map<String,String> params) {
		
		return null;
	}
	public String get(String str) throws IOException{
		URL url = new URL(str);
		connection = url.openConnection();
		
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        
        connection.connect();
        
        reader = new BufferedReader(new InputStreamReader(
		        connection.getInputStream(),getCharset()));
        
        String line;
        StringBuffer result = new StringBuffer();
		while ((line = reader.readLine()) != null) {
		    result.append(line);
		}
		return result.toString() ; 
	}
	
	protected String getCharset(){

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
}
