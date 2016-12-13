package cn.blacard.nymph.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;


/**
@author  Blacard
邮箱：blacard@163.com
@date 创建时间：2016年8月25日 下午9:23:15 
  */
public class TextRead {
	public static String read(File file){
		StringBuffer sb = new StringBuffer();
		try {
			String encoding="GBK";
		    if(file.isFile() && file.exists()){ //判断文件是否存在
		        InputStreamReader read = new InputStreamReader(
		        new FileInputStream(file),encoding);//考虑到编码格式
		        BufferedReader bufferedReader = new BufferedReader(read);
		        String lineTxt = null;
		        while((lineTxt = bufferedReader.readLine()) != null){
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
	
	public static String read(String file){
		return read(new File(file));
	}

}
