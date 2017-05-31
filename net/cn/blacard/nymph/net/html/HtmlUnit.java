package cn.blacard.nymph.net.html;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class HtmlUnit {
	@SuppressWarnings("resource")
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
        
        
        final HtmlPage page = webClient.getPage(path);  
        
        webClient.waitForBackgroundJavaScript(1000*3);  
        webClient.setJavaScriptTimeout(0); 
          
        webClient.getOptions().setJavaScriptEnabled(true);
        
		return page.asXml();
	}
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		System.out.println(new HtmlUnit().getPage("https://www..com/"));
	}
}
