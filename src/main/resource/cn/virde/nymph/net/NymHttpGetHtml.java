package cn.virde.nymph.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.StringEscapeUtils;

import cn.virde.nymph.util.Log;

public class NymHttpGetHtml {

	public String getHtml(String path){		
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStream inputStream = conn.getInputStream();
			byte[] data = readInputStream(inputStream);
			String str = new String(data,"UTF-8");
			
			return str;
		} catch (MalformedURLException e) {
			Log.error("URL地址解析错误，URL:" + path, e);
		} catch (IOException e) {
			Log.error("出现IO异常,URL:" + path, e);
		}
		return null ;
	}
	
	@SuppressWarnings("finally")
	private byte[] readInputStream(InputStream inputStream){ 
		byte[] buffer = new byte[1024]; 
		int len = 0; 
		ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
		try {
			while((len = inputStream.read(buffer)) != -1) { 
				bos.write(buffer, 0, len); 
			}
		} catch (IOException e) {
			Log.error("读取输入流时IO异常", e);
		} finally{
			try {
				bos.close();
				return bos.toByteArray(); 
			} catch (IOException e) {
				Log.error("关闭时IO异常", e);
				return null;
			} 
		}
	}
	
	public String getData(String path) throws IOException{
		return StringEscapeUtils.unescapeJava(getHtml(path));
	}
	
}
