package cn.blacard.nymph.net.info;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.StringEscapeUtils;

public class IpInfo {
	private String ip;
	private String country;
	private String province;
	private String city;
	private String district;
	private String carrier;
	/**
	 * 给构造函数传IP
	 * 会自动去获取关于此IP的一些信息
	 * @param ip
	 */
	public IpInfo(String ip){
		this.ip = ip;	
		getIpInfo();
	}
	/**
	 * 空的构造函数，需要调用setIp()才能获取Info
	 */
	public IpInfo(){
		
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
		getIpInfo();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getHttpUrl() {
		return httpUrl;
	}

	public void setHttpUrl(String httpUrl) {
		this.httpUrl = httpUrl;
	}

	@Override
	public String toString() {
		return "IP:"+ip+" country:"+country+" province:"+province+" city:"+city+" district:"+district +" carrier:"+carrier;
	}
	
	
	private void getIpInfo(){
		//获取到json格式的信息
		String json = request(httpUrl,"ip="+ip);
		
		//对获取到的信息，进行解析 并赋值
		country = getValue(json,"country");
		province = getValue(json,"province");
		city = getValue(json,"city");
		district = getValue(json,"district");
		carrier = getValue(json,"carrier");
	}
	
	
	
	
	private String httpUrl = "http://apis.baidu.com/apistore/iplookupservice/iplookup";
	
	private String request(String httpUrl, String httpArg) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?" + httpArg;
	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        connection.setRequestProperty("apikey",  "bfec71ab14bac71a994a0c68399a540d");
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
	    return result;
	}
	private  String getValue(String json,String key){
		String str = json.substring(json.indexOf(key)+key.length()+3);
		return  StringEscapeUtils.unescapeJava(str.substring(0, str.indexOf("\"")));
	}
}



