package cn.blacard.nymph.String;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
@author  Blacard
���䣺blacard@163.com
@date ����ʱ�䣺2016��7��11�� ����10:51:59 
  */
public class StringTool {
	/**
	 * ƥ���str��
	 * �������������ʽƥ����ַ�
	 * ��ӵ�List�з���
	 * @param str  ����ƥ����ַ�
	 * @param regEx  ���������ʽ
	 * @return ƥ�䵽���ַ��list����
	 */
	public static List<String> getStringsByReg(String str,String regEx){
		List<String> list = new ArrayList<String>();
		Matcher m = Pattern.compile(regEx).matcher(str);
		while(m.find()){
			list.add(m.group());
		}
		return list;
	}
	/**
	 * ƥ���str��
	 * ���������ʽ ƥ����ַ�
	 * ������ֻ��һ��ƥ��������
	 * @param str Ҫƥ����ַ�
	 * @param regEx ���������ʽ
	 * @return ���û��ƥ����򷵻�null
	 */ 
	public static String getStringByReg(String str,String regEx){
		List<String> list = getStringsByReg(str,regEx);
		if(list==null||list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
	}
	/**
	 * 获取后缀名
	 * @author Blacard
	 * @Create 2016年9月1日 下午2:38:51
	 * @param str
	 * @return 后缀名
	 */
	public static String getSuffix(String str){
		if(str.contains(".") && str.lastIndexOf(".") < str.length())
			return str.substring(str.lastIndexOf(".")+1, str.length());
		else
			return null;
	}
	/**
	 * 获取文件名
	 * @author Blacard
	 * @Create 2016年9月1日 下午3:05:21
	 * @param str
	 * @return
	 */
	public static String getFileName(String str){
		return str.substring(str.lastIndexOf("/")+1,str.length());
	}
}
