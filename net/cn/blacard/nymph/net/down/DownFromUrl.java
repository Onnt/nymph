package cn.blacard.nymph.net.down;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import cn.blacard.nymph.Nym;
import cn.blacard.nymph.String.StringTool;

/**
 * <h3>从网络URL下载文件</h3>
 * 
 * @author Blacard
 * @联系方式 
 * 邮箱：blacard@163.com<br/>
 * 手机：18037170703
 * @createTime 2016年9月1日 下午2:10:38
 */
public class DownFromUrl {
	
	/**
	 * 从网络中下载文件
	 * @author Blacard
	 * @Create 2016年9月1日 下午2:14:09
	 * @param urlStr
	 * @param fileName
	 * @param savePath
	 * @throws IOException
	 */
    public void  downFromUrl(String urlStr,String fileName,String savePath) throws IOException{  
        URL url = new URL(urlStr);    
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();    
        //设置超时间为3秒  
        conn.setConnectTimeout(3*1000);  
        //防止屏蔽程序抓取而返回403错误  
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
  
        //得到输入流  
        InputStream inputStream = conn.getInputStream();    
        //获取自己数组  
        byte[] getData = readInputStream(inputStream);      
  
        //文件保存位置  
        File saveDir = new File(savePath);  
        if(!saveDir.exists()){  
            saveDir.mkdir();  
        }  
        File file = new File(saveDir+File.separator+fileName);      
        FileOutputStream fos = new FileOutputStream(file);       
        fos.write(getData);   
        if(fos!=null){  
            fos.close();    
        }
        if(inputStream!=null){  
            inputStream.close();  
        }  
  
        System.out.println("info:"+url+" download success");   
    }  
  
    public void downFromUrl(String url,String savePath) throws IOException{
    	downFromUrl(url, Nym.string.getFileName(url), savePath);
    }
    public void downFromUrl(String url) throws IOException{
    	downFromUrl(url, Nym.string.getFileName(url), "D://NymDownLoad");
    }
    /**
     * 从输入流中获取字节数组 
     * @author Blacard
     * @Create 2016年9月1日 下午2:22:02
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {    
        byte[] buffer = new byte[1024];    
        int len = 0;    
        ByteArrayOutputStream bos = new ByteArrayOutputStream();    
        while((len = inputStream.read(buffer)) != -1) {    
            bos.write(buffer, 0, len);    
        }    
        bos.close();    
        return bos.toByteArray();    
    }    
 
}
