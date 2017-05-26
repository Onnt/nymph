package cn.virde.nymph.net.page;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashSet;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

import cn.blacard.nymph.net.html.HtmlGet;
import cn.blacard.nymph.net.html.HtmlUnit;



/**
 * 一个页面
 * 由一个url地址，生成一个Page对象。
 * 包含html文本，页面url地址，页面的域名
 * @author  Blacard
 * @邮箱：blacard@163.com
 * @date 创建时间：2016年7月10日 下午7:03:58 
 */
public class Page{
	
	/**
	 * 页面的文本内容，文本内容主要是html
	 */
	private String html;
	
	/**
	 * 页面的url地址
	 */
	private String pageUrl;
	
	/**
	 * 页面的域名
	 */
	private String host;
	
	/**
	 * 页面中包含的url的集合
	 */
	private HashSet<String> urls = new HashSet<String>();
	
	
	private HtmlGet htmlGet = new HtmlGet();
	
	/**
	 * 由url 生成 Page对象，
	 * 在Page对象实例化的时候就会获取设置所有的属性，
	 * 只能由此构造函数实例化，
	 * @param pageUrl 页面url地址
	 */
	public Page(String pageUrl){
		this.pageUrl = pageUrl;
		//获取页面html内容
		try {
			this.html = htmlGet.getPage(pageUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//顺序不能乱，setUrls 需要  Host
		//设置页面hostname
		setHost(PageDeal.getHostName(this));
		//获取页面中包含的所有url
		setUrls();
	}

	/**
	 * 获取页面html内容，
	 * html内容在构造函数内已经初始化（获取）
	 * @author Blacard
	 * @Create 2016年12月8日 上午11:22:30
	 * @return 页面html内容
	 */
	public String getHtml(){
		return html;
	}
	 
	/**
	 * 获取页面的url地址
	 * @author Blacard
	 * @Create 2016年12月8日 上午11:24:11
	 * @return 页面url地址
	 */
	public String getPageUrl(){
		return pageUrl;
	}

	/**
	 * 获取页面中包含的所有url地址，
	 * 对象实例化时已经获取生成
	 * @author Blacard
	 * @Create 2016年12月8日 上午11:24:46
	 * @return url集合
	 */
	public HashSet<String> getUrls(){
		
		return urls;
	}
	
	/**
	 * 获取页面的hostName
	 * @author Blacard
	 * @Create 2016年12月8日 上午11:27:52
	 * @return
	 */
	public String getHost() {
		
		return host;
	}
//****************************
//**       以下为私有方法         **
//****************************
	/**
	 * 设置页面的hostName
	 * @author Blacard
	 * @Create 2016年12月8日 上午11:29:28
	 * @param host
	 */
	private void setHost(String host) {
		this.host = host;
	}

	/**
	 * 获取生成页面内包含的所有url的set集合
	 * 目前仅获取了href 和 src 中的链接，其他的忽略
	 * @author Blacard
	 * @Create 2016年12月8日 上午11:31:32
	 */
	private void setUrls(){
		try {
			urls = PageDeal.getHref(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 这个方法怎么使用还不是很明确
	 * @author Blacard
	 * @Create 2016年12月8日 上午11:31:08
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getPageByJavScript(){
		HtmlUnit htmlUnit = new HtmlUnit();
		String page = "";
		try {
			page = htmlUnit.getPage(pageUrl);
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return page;
	}
	
}
