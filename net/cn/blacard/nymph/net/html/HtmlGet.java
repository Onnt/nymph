package cn.blacard.nymph.net.html;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.StringEscapeUtils;

import cn.blacard.xiaoqiu.XiaoQiu;

/**
 * ֻ�ܻ�ȡ��HTML����
 * ����JS���߸��ֶ�̬��ɵĴ���Ч���
 * �Ժ����о���
 * 
 * 
 * @author Blacard
 */
public class HtmlGet extends XiaoQiu{
	/**
	 * �Ż����򣬸��ҳ����뷽ʽ����ҳ��
	 * @param path
	 * @return
	 */
	
	public String getPage(String path){
		
		try {
			URL url = new URL(path);
			//��ȡ�� ҳ������
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStream inputStream = conn.getInputStream();
			byte[] data = readInputStream(inputStream);
			return  new String(data,"UTF-8");
		} catch (MalformedURLException e) {
			log.error("URLЭ�顢��ʽ����·������",e);
		} catch (IOException e) {
			log.error("IO���쳣",e);
		}
		return null;
	}
	
	public String getData(String path){
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
