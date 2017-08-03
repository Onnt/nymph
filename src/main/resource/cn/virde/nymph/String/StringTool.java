package cn.virde.nymph.String;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理工具
 * @author Blacard
 * @联系方式 邮箱：blacard@163.com <br/> 手机：18037170703
 * @create 2016年7月11日 下午10:51:59
 */
public class StringTool {
	/**
	 * 在给定的字符串中匹配对应正则表达式，
	 * 所有符合表达式的字符打包至集合中返回
	 * @param str 
	 * @param regEx  正则表达式
	 * @return 
	 */
	public List<String> getStringsByReg(String str,String regEx){
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
	 * @create 2017年2月7日 下午5:49:30
	 * @param str
	 * @param regEx
	 * @return
	 */
	public String getStringByReg(String str,String regEx){
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
	 * @create 2017年1月24日 下午2:49:23
	 * @param str
	 * @return
	 */
    public String replaceBlank(String str) {
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
	 * @Create 2016年9月1日 下午2:38:51
	 * @param str
	 * @return 后缀名
	 */
	public String getSuffix(String str){
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
	public String getFileName(String str){
		return str.substring(str.lastIndexOf("/")+1,str.length());
	}
	

    public boolean isIP(String str){  
        if(str.length() < 7 || str.length() > 15 || "".equals(str)){  
            return false;  
        }  
        
        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";  
        Pattern pat = Pattern.compile(rexp);    
        Matcher mat = pat.matcher(str);    
        boolean ipAddress = mat.find();  
        return ipAddress;  
    }
    
    public boolean isFormat(String str,String regFormat){
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regFormat);
	    Matcher matcher = pattern.matcher(str);
	    return matcher.matches();
    }
}
