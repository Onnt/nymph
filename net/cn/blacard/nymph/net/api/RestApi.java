package cn.blacard.nymph.net.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.StringEscapeUtils;
/**
 * �����������һЩ��REST API�Ĺ���
 * ���ڰٶ�API�ö๦�ܶ�����REST API�ķ�ʽ���õ�
 * �����ðɣ���֪������ô���͡�
 * ���ǣ�Ҫ֪��������һ�������õ���ͺ���
 * @author Blacard
 *
 */
public class RestApi {
	/**
	 * ��ȡ��ݣ�������
	 * @param httpUrl  ��Ч�ĵ�������
	 * @return ���ӷ��ص����
	 */
	public String getData(String httpUrl){
		BufferedReader reader = null;
		StringBuffer sbf = new StringBuffer();
		String result="";
	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        connection.setRequestProperty("apikey",  "bfec71ab14bac71a994a0c68399a540d");  //�ٶ�API �� API  KEY
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    //���ص�ʱ����������Ĵ��?û����仰���Ļ���ʲô���뷽ʽ����
		return StringEscapeUtils.unescapeJava(result);
//	    return result;
	}
}
