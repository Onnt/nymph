package cn.virde.nymph.text;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

import cn.virde.nymph.util.Log;

/**
 * 获取properties文件中参数 
 * 
 * 
 * 这个方法被证明是一个很傻比的方法
 * @author Blacard
 * 
 * 2016年9月22日 下午4:22:17
 */
public class NymProperties {
	
	private String file ;
	
	public NymProperties(String filePath){
		this.file = filePath ;
	}
	/**
	 * 
	 * @author Blacard
	 * 2016年9月22日 下午4:22:09
	 * @param key key值
	 * @return 返回
	 */
	public String getValue(String key){
		return getValueByKey(file, key);
	}
	public void setValue(String key,String value){
		try {
			writeProperties(file, key, value);
		} catch (IOException e) {
			Log.info("写配置文件时出现IO异常", e);
		} 
	}
	
    //根据Key读取Value
    private static String getValueByKey(String filePath, String key) {
        Properties pps = new Properties();
        try {
            InputStream in = new BufferedInputStream (new FileInputStream(filePath));  
            pps.load(in);
            String value = pps.getProperty(key);
            return value;
            
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    //写入Properties信息
    private static void writeProperties (String filePath, String pKey, String pValue) throws IOException {
        Properties pps = new Properties();
        
        InputStream in = new FileInputStream(filePath);
        //从输入流中读取属性列表（键和元素对） 
        pps.load(in);
        //调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。  
        //强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
        OutputStream out = new FileOutputStream(filePath);
        pps.setProperty(pKey, pValue);
        //以适合使用 load 方法加载到 Properties 表中的格式，  
        //将此 Properties 表中的属性列表（键和元素对）写入输出流  
        pps.store(out, "Update " + pKey + " name");
    }
    //读取Properties的全部信息
    @SuppressWarnings("unused")
	private static void getAllProperties(String filePath) throws IOException {
        Properties pps = new Properties();
        InputStream in = new BufferedInputStream(new FileInputStream(filePath));
        pps.load(in);
        Enumeration<?> en = pps.propertyNames(); //得到配置文件的名字
        
        while(en.hasMoreElements()) {
            String strKey = (String) en.nextElement();
            String strValue = pps.getProperty(strKey);
            System.out.println(strKey + "=" + strValue);
        }
    }
}
