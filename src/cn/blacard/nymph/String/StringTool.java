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
}
