package cn.virde.nymph.system;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
 * 
 * @author Virde
 * 2018年4月13日 下午3:24:56
 */
public class SystemInfo {

	private InetAddress inet = null; 
	
	public SystemInfo(){
		try {
			inet = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
		}
	}
	
	/**
	 * 
	 * @author Virde
	 * 2018年4月13日 下午3:25:02
	 * @return 返回
	 */
	public String getMac(){
		if(isInetNull()) return "";
		
		byte[] mac = getMacByte();
		if(mac == null) return "";
		
		return macByteToString(mac);
	}
	/**
	 * 
	 * @author Virde
	 * 2018年4月13日 下午3:25:07
	 * @return 返回
	 */
	private byte[] getMacByte(){
		try {
			return NetworkInterface.getByInetAddress(inet).getHardwareAddress();
		} catch (SocketException e) {
			return null;
		}
	}
	/**
	 * 
	 * @author Virde
	 * 2018年4月13日 下午3:25:11
	 * @param mac mac地址
	 * @return 返回
	 */
	private String macByteToString(byte[] mac){
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<mac.length; i++) {
			if(i!=0) {
				sb.append("-");
			}
			//字节转换为整数
			int temp = mac[i]&0xff;
			String str = Integer.toHexString(temp);
			if(str.length()==1) {
				sb.append("0"+str);
			}else {
				sb.append(str);
			}
		}
		return sb.toString().toUpperCase();
	}
	
	/**
	 * 
	 * @author Virde
	 * 2018年4月13日 下午3:25:17
	 * @return 返回
	 */
	public String getHostName(){
		
		if(isInetNull()) return "";
		
		return inet.getHostName();
	}
	
	/**
	 * 
	 * @author Virde
	 * 2018年4月13日 下午3:25:20
	 * @return 返回
	 */
	public String getLANIP(){
		
		if(isInetNull()) return "";
		
		return inet.getHostAddress();
	}
	/**
	 * 
	 * @author Virde
	 * 2018年4月13日 下午3:25:24
	 * @return 返回
	 */
	private boolean isInetNull(){
		if(inet == null){
		}
		return inet == null ? true : false ;
	}
	
}
