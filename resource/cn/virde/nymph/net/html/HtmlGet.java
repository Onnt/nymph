package cn.virde.nymph.net.html;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.StringEscapeUtils;

@Deprecated
public class HtmlGet{
	
	@SuppressWarnings("unused")
	public String getPage(String path) throws IOException{
		
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		InputStream inputStream = conn.getInputStream();
		byte[] data = readInputStream(inputStream);
		String str = new String(data,"UTF-8");
			
		return  new String(data,"UTF-8");
	}
	
	public String getData(String path) throws IOException{
		return StringEscapeUtils.unescapeJava(getPage(path));
	}
	
	private byte[] readInputStream(InputStream inputStream) throws IOException { 
		byte[] buffer = new byte[1024]; 
		int len = 0; 
		ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
		while((len = inputStream.read(buffer)) != -1) { 
			bos.write(buffer, 0, len); 
		} 
		bos.close(); 
		return bos.toByteArray(); 
	} 
}
