package cn.virde.nymph.net.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import cn.virde.nymph.Nym;

public class NymHttpTest {
	

	public static void doPost2(){
	   String url = "http://localhost:8099/note/notepaper/add.do";
	    //拼接参数
	    List <NameValuePair> nvps = new ArrayList <NameValuePair>();
	    nvps.add(new BasicNameValuePair("jwt", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ7XCJpZFwiOjIsXCJpcFwiOlwiMTgwLjE2OS4xNC4zNFwiLFwibmFtZVwiOlwic3VuYW9cIixcInRpbWVvdXRcIjowfSIsImlhdCI6MTQ5ODcxODk2OCwic3ViIjoiYXV0aCIsImV4cCI6Mjk5NzQzNzkzN30.SfKlgQEFb70QeSGmPcj5QO_nH8qa_nR5vydX9m6_qEQ"));
	    nvps.add(new BasicNameValuePair("content", "是中文啊aa"));
	    
	    Nym.http.post(url, nvps);
	}
	public static void main(String[] args) {
		doPost2();
	}
	
}
