package cn.virde.nymph.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

import cn.virde.nymph.Nym;
import cn.virde.nymph.exception.Not200Exception;
import cn.virde.nymph.net.page.Page;

public class NymTest {

	@Test
	public void nym() throws IOException{
		System.out.println(Nym.http.get("http://5sing.kugou.com/"));
		Page page = new Page("http://5sing.kugou.com/");
		Set<String> sets = page.getUrls();
		for(String s : sets){
			System.out.println(s);
		}
	}
	
	
	@Test
	public void addAccount(){
		String mobilePrefix = "13700000";
		for(int i = 1 ; i <= 500; i++){
			String mobile = mobilePrefix + getSuffix(i);
			
		}
		
	}
	
	private String getSuffix(int i){
		if(i < 10 ){
			return "00" +  i ;
		}
		if(i < 100){
			return "0" + i ;
		}
		return "" + i ; 
	}
	
	@Test
	public void sendPost(String mobile) throws IOException, Not200Exception{
//		String
		
		Nym.http.post("http://localhost:8090/readings_platform/jf/platform/user/save?user.departmentids=4cc9dec0e91c4f08a77a5a014ebc0c1d&user.departmentnames=%E6%B3%B0%E5%85%B4%E5%B8%82%E5%A4%A7%E9%98%9F%E5%85%9A%E5%A7%94&userInfo.idcard=&userInfo.names=%E6%9C%AA%E5%91%BD%E5%90%8D&user.username=13700000006&password=111111&userInfo.email=13700000006%40qq.com&userInfo.mobile=13700000006&userInfo.telephone=13700000006&userInfo.qq=13700000006&userInfo.birthday=2017-07-31", new HashMap<String,String>());
	}
	
	public static void main(String[] args) {
		System.out.print("idea git test");
	}
	
}

