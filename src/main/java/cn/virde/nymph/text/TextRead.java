package cn.virde.nymph.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * 读取文本内容
 * @author Blacard
 * @联系方式 邮箱：blacard@163.com <br/> 手机：18037170703
 * @create 2016年8月25日 下午9:23:15 
  */
public class TextRead {
	public String read(File file){
		StringBuffer sb = new StringBuffer();
		try {
			String encoding="GBK";
		    if(file.isFile() && file.exists()){ //判断文件是否存在
		        InputStreamReader read = new InputStreamReader(
		        new FileInputStream(file),encoding);//考虑到编码格式
		        BufferedReader bufferedReader = new BufferedReader(read);
		        String lineTxt = null;
		        while((lineTxt = bufferedReader.readLine()) != null){
		        	sb.append("\r\n");
		        	sb.append(lineTxt);
		            
		        }
		        read.close();
		     }else{
		        throw new FileNotFoundException();
		     }
	     } catch (Exception e) {
	    	 //这里待处理
	       System.out.println("这里出错了，总之你来看看。");
	     }
		return sb.toString();
	}
	
	public String read(String file){
		return read(new File(file));
	}
}
