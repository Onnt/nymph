package cn.virde.nymph.string;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.virde.nymph.Nym;
import cn.virde.nymph.datetime.DateTime;
import cn.virde.nymph.net.NymUrl;

/**
 * 字符串处理工具
 * @author Blacard
 * 
 * 2016年7月11日 下午10:51:59
 */
public class StringTool {
	/**
	 * 在给定的字符串中匹配对应正则表达式，
	 * 所有符合表达式的字符打包至集合中返回
	 * @param str 给定的字符串
	 * @param regEx  正则表达式
	 * @return 返回 
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
	 * 在给定的字符串中匹配对应正则表达式，
	 * 只返回第一个匹配的结果
	 * @author Blacard
	 * 2017年2月7日 下午5:49:30
	 * @param str 给定的字符串
	 * @param regEx 正则表达式
	 * @return 返回
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
	 * 去除字符中的所有空白符
	 * 
	 * @author Blacard
	 * 2017年1月24日 下午2:49:23
	 * @param str 字符串
	 * @return 返回
	 */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
	
	/**
	 * 获取后缀名
	 * @author Blacard
	 * 2016年9月1日 下午2:38:51
	 * @param str 字符串
	 * @return 返回 后缀名
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
	 * 2016年9月1日 下午3:05:21
	 * @param str 字符串
	 * @return 返回
	 */
	public static String getFileName(String str){
		return str.substring(str.lastIndexOf("/")+1,str.length());
	}

	/**
	 * 返回url中名字为name的参数值。
	 * 如果没有这个参数值或者发生异常，则返回NULL
	 * 
	 * @param url url地址
	 * @param name 名字
	 * @return 返回
	 */
	@Deprecated
	public static String getParam(String url,String name) {
		Map<String,String> map = getQueryMap(url);
		return map.containsKey(name)?map.get(name):null;
	}

	/**
	 * 将url中的请求参数转换为map并返回。
	 * @param str 完整的url连接，或者是单独的请求部分 
	 * @return 解析好的map
	 * @author Virde
	 * 2018年11月5日 11:22:51
	 */
	@Deprecated
	public static Map<String,String> getQueryMap(String str){
		String queryString = getQueryString(str);
		if(queryString==null) return null;
		
		Map<String,String> respMap = new HashMap<>();
		String[] kvs = queryString.split("&");
		for(String kv : kvs) {
			if(kv.contains("=")) {
				String[] param = kv.split("=");
				respMap.put(param[0], param[1]);
			}else {
				respMap.put(kv, "");
			}
		}
		return respMap ;
	}

	@Deprecated
	private static String getQueryString(String str){
		try {
			return new NymUrl(str).getQuery();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return str;
		}
	}
	
	/**
	 * 传入链接和参数，拼接返回。
	 * 缺陷：没有验证url的既有参数
	 * @author Blacard
	 * 2017年12月20日 14:25:21
	 * @param url url地址
	 * @param params 参数
	 * @return 返回
	 */
	public static String makeUrlWithParams(String url,Map<String,String> params) {
		if(params==null||params.size()==0) return url ;
		
		StringBuffer sb = new StringBuffer();
		for(Map.Entry<String, String> m : params.entrySet()) {
			sb.append(m.getKey()+"="+m.getValue()+"&");
		}
		return url +"?"+ sb.toString().substring(0, sb.length()-1);
	}
	public static String makeUrlWithParams(String...args) {
		if(args.length == 0 )
			return null ;
		if(args.length == 1) 
			return args[0] ;
		
		Map<String,String> map = new HashMap<String,String>();
		String key = "" ;
		for(int i = 1 ; i < args.length ; i++) {
			if(i % 2 == 1) {
				key = args[i] ;
			}else {
				map.put(key, args[i]) ;
			}
		}
		return makeUrlWithParams(args[0], map);
	}
	
	/**
	 * 
	 * @author Virde
	 * 2018年6月7日 下午3:04:30
	 * @param url url地址
	 * @param params 参数
	 * @return 返回
	 * @throws InvocationTargetException  异常
	 * @throws IllegalArgumentException  异常
	 * @throws IllegalAccessException  异常
	 */
	public static String makeUrlWithParams(String url,Object params) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return makeUrlWithParams(url, Nym.clazz.getField(params)) ;
	}

	@Deprecated
	public static String getHost(String url) {
		return getStringByReg(url, "(http|ftp|https):\\/\\/([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}");
	}
	/**
	 * 将数字转换为 自然语言描述的文件大小
	 * @author Blacard
	 * 2016年9月7日 下午5:29:35
	 * @param length 文件大小
	 * @return 返回
	 */
	public static String fileLength(long length){
		int level = 0 ;
		double d_length = length ;
		while(d_length > 1024){
			d_length = d_length / 1024;
			level++;
		}
		
		String fmt = "";
		switch(level){
			case 0:
				fmt = " B";
				break;
			case 1:
				fmt = " KB";
				break;
			case 2:
				fmt = " MB";
				break;
			case 3:
				fmt = " GB";
				break;
			case 4:
				fmt = " TB";
				break;
			case 5:
				fmt = "PB";
				break;
			case 6:
				fmt = "EB";
				break;
				default : ;
		}
		DecimalFormat df = new DecimalFormat("#0.00");   
		return df.format(d_length) + fmt;
	}
	/**
	 * 将以数字加单位形式的文件大小转换成具体数字
	 * 例：“3.3MB” 转换为 “3460300” 
	 * 目前仅支持 KB,MB,GB 单位的转换
	 * @author Blacard
	 * 2016年9月19日 上午11:42:32
	 * @param str 数字加单位形式表示的文件大小
	 * @return 返回 转换后的纯数字文件大小
	 */
	public static long fileSizeToLong(String str){
		str = str.toUpperCase().replaceAll(" ", "");
		
		int index = 2 ; 
		if(!str.contains("B"))
			index = 1 ;

		float n = Float.parseFloat(str.substring(0,str.length() - index));
		String unit = str.substring(str.length() - index ,str.length());
		//定义返回结果
		long result = 0;
		//将参数的数字部分转换成long类型，乘1000是防止丢失小数部分
		long  num = (long)(n*1000);
		switch(unit.toUpperCase()){
		case "K":
		case "KB":
			result = 1024*num;
			break;
		case "M" :
		case "MB":
			result = 1024*1024*num;
			break;
		case "G" :
		case "GB":
			result =  1024*1024*1024*num;
			break;
		}
		//将上面的1000还回去
		result = result/1000;
		return result;
	}
	
	public static String getAPM(Date date){
		return getAPM(DateTime.toString(date));
	}
	public static String getAPM(String time){
		int hour = Integer.parseInt(time.substring(11, 13));
		String apm = "";
		switch(hour){
		case 0:
			apm = "子时";
			break;
		case 1:
			apm = "丑时";
			break;
		case 2:
			apm = "丑时";
			break;
		case 3:
			apm = "寅时";
			break;
		case 4:
			apm = "寅时";
			break;
		case 5:
			apm = "早上";
			break;
		case 6:
			apm = "早上";
			break;
		case 7:
			apm = "早上";
			break;
		case 8:
			apm = "早上";
			break;
		case 9:
			apm = "上午";
			break;
		case 10:
			apm = "上午";
			break;
		case 11:
			apm = "中午";
			break;
		case 12:
			apm = "中午";
			break;
		case 13:
			apm = "下午";
			break;
		case 14:
			apm = "下午";
			break;
		case 15:
			apm = "下午";
			break;
		case 16:
			apm = "下午";
			break;
		case 17:
			apm = "下午";
			break;
		case 18:
			apm = "下午";
			break;
		case 19:
			apm = "晚上";
			break;
		case 20:
			apm = "晚上";
			break;
		case 21:
			apm = "晚上";
			break;
		case 22:
			apm = "晚上";
			break;
		case 23:
			apm = "子时";
			break;
		}
		return apm;
	}
}
