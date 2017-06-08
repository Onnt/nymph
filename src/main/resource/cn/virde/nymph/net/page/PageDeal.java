package cn.virde.nymph.net.page;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import cn.virde.nymph.Nym;




/**
 * 对获取到的page进行处理
 * 
 * @author  Blacard
 * @邮箱：blacard@163.com
 * @date 创建时间：2016年7月11日 下午11:06:32 
  */
public class PageDeal {
	
	/**
	 * 
	 * @author Blacard
	 * @Create 2017年1月23日 下午2:11:55
	 * @param page
	 * @return
	 * @throws IOException
	 */
	public static HashSet<String> getSrc(Page page) throws IOException{
		String html = Nym.string.replaceBlank(page.getHtml());        
		List<String> list = Nym.string.getStringsByReg(html, "src=([\"\"\'])[\\x21-\\x7ea-zA-Z0-9]{0,1000}([\"\"\'])");
		HashSet<String> newSet = new HashSet<String>();
		for(String s : list){
			s = s.substring(5, s.length()-1);
			s = pinJie(page,s);
			if(s!=null){
				newSet.add(s);
			}
		}
		return newSet;
	}
	
	/**
	 * 获取页面中href中包含的连接
	 * 返回的都是直接能用的链接
	 * @author Blacard
	 * @Create 2016年12月8日 上午11:50:53
	 * @param page 页面
	 * @return 返回页面内直接能用的链接集合
	 * @throws IOException
	 */
	public static HashSet<String> getHref(Page page) throws IOException{
		String html = Nym.string.replaceBlank(page.getHtml());       
		//正则表达式 匹配href
		List<String> list = Nym.string.getStringsByReg(html, "href=([\"\"\'])[\\x21-\\x7ea-zA-Z0-9]{0,1000}([\"\"\'])");
		HashSet<String> newSet = new HashSet<String>();
		
		for(String str : list){
			//减去href=""
			str = str.substring(6, str.length()-1);
			
			//对href中的链接进行处理
			str = pinJie(page,str);

			if(str!=null){
				//对爬取得链接范围进行限制，只爬取指定hostname范围的链接
				if(getHostName(str).equals(page.getHost())){
					newSet.add(str);
				}
			}
		}
		return newSet;
	}
	
	/**
	 * 根据页面的链接 获取到 hostName
	 * @return
	 */
	public static String getHostName(Page page){
		return Nym.string.getStringByReg(page.getPageUrl(), 
				"(http|ftp|https):\\/\\/([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}");
	}

	/**
	 * 根据页面的链接 获取到 hostName
	 * @return
	 */
	public static String getHostName(String page){
		return Nym.string.getStringByReg(page, 
				"(http|ftp|https):\\/\\/([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}");
	}
	
	/**
	 * 判断并处理href里的内容
	 * 优化方向：增加处理相对路径的能力，比如../../ 或者./
	 * 
	 * @param page WangZhi，这个参数里面的host要用
	 * @param str href里的内容
	 * @return 处理过的链接，可以直接使用，不保证有效性。
	 * 如果内容明显无效，返回null
	 */
	@Deprecated
	private static String pinJie(Page page,String str){
		//判断非null，非空
		if(str==null) return null;
		str = str.replaceAll(" ","");
		if(str.equals("")) return null;
		
		//判断是否包含无用字符
		if(str.contains("javascript")||str.contains("favicon.ico")
				||str.contains(".js") || str.contains(".css")){
			return null;
		}
		
		//判断str是否是一个网络链接
		if(str.matches("http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?.*")){
			return correcting(str);
		}

		//如果是绝对路径，加上域名组成完整的路径
		if(str.toCharArray()[0]=='/'){
			return correcting(page.getHost()+str);
		}
		
		//如果是当前相对路径
		if(str.startsWith("./")){
			return relativeCurrPathDeal(page,str);
		}
		
		//判断str是否是相对路径
		if(str.startsWith("../")){
			return relativePathDeal(page,str);
		}
		//其他情况全部当作相对当前路径
		return relativeCurrPathDeal(page,str);
	}
	
	/**
	 * 校正链接，防止出现格式不正确的链接
	 * @param str 被校正的链接
	 * @return 校正过的链接
	 */
	private static String correcting(String str){
		String resp = Nym.string.getStringByReg(str, "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?");
		return resp;
	}
	

	private static String relativePathDeal(Page page,String str){ 
		//将href链接分成前 和 后
		String str_front = str.substring(0,str.lastIndexOf("../")+3);
		String str_end = str.replace(str_front, "");
		
		//截取页面地址 后半部分(pageUrl_end)
		String pageUrl_end = null;
		String pageUrl = page.getPageUrl();
		String pageUrl_replace = pageUrl.replace("//", "");
		if(pageUrl_replace.contains("/")){
			pageUrl_end = pageUrl_replace.substring(
					pageUrl_replace.indexOf("/"), //startIndex 
					pageUrl_replace.length() //endIndex
					);
			if(pageUrl_end.indexOf("/")==pageUrl_end.lastIndexOf("/")){
				//页面链接只有一级深度（根目录），不能完成跳转（sample: http://baidu.com/ http://baidu.com/index.html）
				return null;
			}
			if(pageUrl_end == null || pageUrl_end.equals("") ){
				//页面链接只有一级深度（根目录），不能完成跳转（sample: http://baidu.com）
				return null;
			}
		}else{
			//页面链接只有一级深度（根目录），不能完成跳转（sample: http://baidu.com）
			return null;
		}
		
		String[] strs =  str_front.split("/");
		String[] pageUrl_ends = pageUrl_end.split("/");
		
		int pageUrl_ends_length = pageUrl_ends.length-1;
		if(!pageUrl_end.endsWith("/")) pageUrl_ends_length--;
		if(strs.length > pageUrl_ends_length){
			//href 大于 页面深度，不能完成跳转（sample: http://baidu.com/map.index href="../index.html"）
			return null;
		}
		for(String s : strs){
			if(s.equals("..")){
				pageUrl_end = pageUrl_end.substring(0, pageUrl_end.lastIndexOf("/")); 
				pageUrl_end = pageUrl_end.substring(0, pageUrl_end.lastIndexOf("/"))+"/"; 
			}
		}
		
		return page.getHost()+pageUrl_end+str_end;
	}
	/**
	 * 
	 * @author Blacard
	 * @Create 2017年1月23日 下午4:31:29
	 * @param page
	 * @param str
	 * @return
	 */
	private static String relativeCurrPathDeal(Page page,String str){
		String pageUrl = page.getPageUrl();
		String respStr = null;
		//判断页面链接是否以“/”结尾
		if(pageUrl.endsWith("/")){
			str = str.replace("./", "");
			respStr = pageUrl + str;
		}else{
			pageUrl = pageUrl.substring(0,pageUrl.lastIndexOf("/")+1);
			str = str.replace("./", "");
			respStr = pageUrl+str;
		}
		
		return correcting(respStr);
	}
}
