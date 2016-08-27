package cn.blacard.nymph.net.html;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


/**
@author  Blacard
���䣺blacard@163.com
@date ����ʱ�䣺2016��7��10�� ����7:47:43 
  */
public class HtmlUnit {
	public String getPage(String path) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);  
        webClient.getOptions().setThrowExceptionOnScriptError(false);  
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false); 
        webClient.getOptions().setJavaScriptEnabled(true);  
        webClient.getOptions().setActiveXNative(false);  
        webClient.getOptions().setCssEnabled(false);  
        webClient.getOptions().setThrowExceptionOnScriptError(false);  
        webClient.waitForBackgroundJavaScript(600*1000);  
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        
        // ģ���������һ��Ŀ����ַ  
        final HtmlPage page = webClient.getPage(path);  
//      �÷�����getPage()����֮����ò�����Ч  
        webClient.waitForBackgroundJavaScript(1000*3);  
        webClient.setJavaScriptTimeout(0); 
          
        webClient.getOptions().setJavaScriptEnabled(true);
        
		return page.asXml();
	}
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
//		new PutToText("F://a.txt").put(new HtmlUnit().getPage("https://www.hao123.com/"));
		System.out.println(new HtmlUnit().getPage("https://www..com/"));
	}
}
