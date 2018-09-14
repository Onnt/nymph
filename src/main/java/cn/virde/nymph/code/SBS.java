package cn.virde.nymph.code;

/**
 * 中文名：原地踏步算法
 * 英文名：Step By Step，简称SBS
 * @author Virde
 * 2018年5月10日 下午8:10:21
 */
public class SBS {
	
	/**
	 * 目前Key只支持是一个十进制的字符串数字，
	 * 之后可以继续改进
	 */
	private String key ;
	
	public SBS(String key) {
		this.key = key ;
	}
	
	public String encode(String str) {
		int[] strIntArray = stringToArray(str) ;
		int[] keyIntArray = stringToArray(key) ;
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < keyIntArray.length ; i++){
			for(int j = 0 ; j < strIntArray.length ; j ++) {
				strIntArray[j] = add(strIntArray[j],keyIntArray[i]);
			}
		}
		for(int aai : strIntArray) {
			sb.append(aai) ;			
		}
		return sb.toString() ;
	}
	
	public String decode(String str) {
		int[] strIntArray = stringToArray(str) ;
		int[] keyIntArray = stringToArray(key) ;
		
		StringBuffer sb = new StringBuffer();
		for(int i = keyIntArray.length ; i > 0 ; i--){
			for(int j = 0 ; j < strIntArray.length ; j ++) {
				strIntArray[j] = sub(strIntArray[j],keyIntArray[i-1]);
			}
		}
		for(int aai : strIntArray) {
			sb.append(aai) ;			
		}
		return sb.toString() ;
	}
	
	private int sub(int a , int b) {
		return  (a < b ) ? ( a +10 - b ) : ( a - b ) ;
	}
	private static int add(int a, int b) {
		int r = a + b ;
		return r > 9 ? r % 10 : r ; 
	}
	private int[] stringToArray(String str) {
		int[] intArray = new int[str.length()] ;
		for (int i = 0; i < str.length(); i++) {
			// 遍历str将每一位数字添加如intArray
			Character ch = str.charAt(i);
			intArray[i] = Integer.parseInt(ch.toString());
		}
		return intArray;
	}
}
