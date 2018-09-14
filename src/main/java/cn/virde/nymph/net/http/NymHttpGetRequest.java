package cn.virde.nymph.net.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.virde.nymph.Nym;

/**
 * 
 * @author Virde
 * 2018年6月7日 下午3:01:50
 */
public class NymHttpGetRequest {

	private URLConnection connection ;
	private BufferedReader reader ; 
	
	public String get(String url,Map<String,String> params) throws NymHttpException{
		try {
			return get(Nym.string.makeUrlWithParams(url, params));
		} catch (IOException e) {
			throw new NymHttpException("IO Exception,detail info:" + e.getMessage());
		}
	}
	public <T> T get(String url,Class<T> clazz) throws NymHttpException {
		try {
			String result = get(url);
			return Nym.json.jsonToObject(result, clazz);
		} catch (IOException e) {
			throw new NymHttpException("IO Exception,detail info:" + e.getMessage());
		}
	}
	public <T> T get(String url,Object params,Class<T> clazz) throws NymHttpException {
		try {
			String result = get(Nym.string.makeUrlWithParams(url, params));
			return Nym.json.jsonToObject(result, clazz);
		} catch (IOException e) {
			throw new NymHttpException("IO Exception,detail info:" + e.getMessage());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new NymHttpException("parames error,detail info:" + e.getMessage());
		}
	}
	public <T> T get(String url,Map<String,String> map,Class<T> clazz) throws NymHttpException {
		String result = get(url,map);
		return Nym.json.jsonToObject(result, clazz);
	}
	public <T> T get(String url,String key,String value,Class<T> clazz) throws NymHttpException {
		Map<String,String> map = new HashMap<String,String>();
		map.put(key, value);
		return get(url, map, clazz);
	}

	public <T> T get(Class<T> clazz,String...args) throws NymHttpException {
		String url = args[0];
		if(args.length > 1 && args.length % 2 != 1) {
			throw new NymHttpException("a key required need a value");
		}
		if(args.length == 1) {
			return get(url, clazz) ;
		}
		return get(url, getParams(args), clazz) ;
	}
	protected Map<String,String> getParams(String[] args){
		Map<String,String> map = new HashMap<String,String>();
		String key = null ;
		for(int i = 1; i < args.length ; i++ ) {
			if(i % 2 == 1) {
				key = args[i] ;
			}else {
				map.put(key, args[i]);
			}
		}
		return map ;
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
