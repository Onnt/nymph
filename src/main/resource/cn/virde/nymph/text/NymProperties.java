package cn.virde.nymph.text;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 获取properties文件中参数 
 * <br/>
 * 
 * 这个方法被证明是一个很傻比的方法
 * @author Blacard
 * @联系方式 邮箱：blacard@163.com <br/> 手机：18037170703
 * @create 2016年9月22日 下午4:22:17
 */
@Deprecated
public class NymProperties {
	
	private String filePath;
	public NymProperties(String filePath){
		this.filePath = filePath;
	}
	/**
	 * 
	 * @author Blacard
	 * @create 2016年9月22日 下午4:22:09
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getValue(String key) throws IOException{
        Properties props = new Properties();  
        InputStream in = null;  
        try {  
            in = new FileInputStream(filePath);  
            // 如果将in改为下面的方法，必须要将.Properties文件和此class类文件放在同一个包中  
            //in = propertiesTools.class.getResourceAsStream(fileNamePath);  
            props.load(in);  
            String value = props.getProperty(key);  
            // 有乱码时要进行重新编码  
            // new String(props.getProperty("name").getBytes("ISO-8859-1"), "GBK");  
            return value;  
  
        } catch (IOException e) {  
            e.printStackTrace();  
            return null;  
  
        } finally {  
            if (null != in)  
                in.close();  
        }  
	}
}
