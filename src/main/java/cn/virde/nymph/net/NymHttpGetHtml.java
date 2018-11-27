package cn.virde.nymph.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.StringEscapeUtils;


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
		} catch (IOException e) {
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
			;
		} finally{
			try {
				bos.close();
				return bos.toByteArray(); 
			} catch (IOException e) {
				return null;
			} 
		}
	}
	
	public String getData(String path) throws IOException{
		return StringEscapeUtils.unescapeJava(getHtml(path));
	}
	
}
