package cn.virde.nymph.string;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import cn.virde.nymph.datetime.DateTime;
import cn.virde.nymph.net.url.URLParse;

public class Test {
	
	public static void main(String[] args) throws MalformedURLException, ParseException {
//		URLParse url = new URLParse("http://xianhang.lofter.com/tag/%E7%94%9F%E6%B4%BB?page=2&t=-1535789446843");
//		System.out.println(url.getProtocol());
//		System.out.println(url.getHost());
//		System.out.println(url.getPath());
//		System.out.println(url.getPort());
//		System.out.println(url.getQuery());
//		
//		url.removeQueryByName("t");
//		System.out.println(url.toString());
//		
//		url.removeRef();
//		System.out.println(url.toString());
		
        Date begin = DateTime.toDate("2018年2月18日");
        Date end = DateTime.toDate("2019-1-18");

        long diff = end.getTime() - begin.getTime();
        long oneYear = 31536000000l; //365 * 24 * 60 * 60 * 1000
        System.out.println(diff);
        System.out.println(oneYear);
        if(diff > oneYear ){
            System.out.println("a");
        }else{
        	System.out.println("b");
        }
		
		
	}
	
	public static void testURL() throws MalformedURLException {
		URL url = new URL("http://xianhang.lofter.com/tag/%E7%94%9F%E6%B4%BB?page=2&t=-1535789446843#23sdf");
		System.out.println(url.getRef());
		System.out.println(url.getFile());
	}

}
