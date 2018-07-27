package cn.virde.nymph.net.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class PostJsonTest {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {

	    String url = "http://127.0.0.1/note/hash/add.do?jwt=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ7XCJpZFwiOjIsXCJpcFwiOlwiMTI3LjAuMC4xXCIsXCJuYW1lXCI6XCJzdW5hb1wiLFwidGltZVwiOjE2MjcyMjk2MzkzNjl9IiwiaWF0IjoxNTI3MjI5NjM5LCJzdWIiOiJhdXRoIiwiZXhwIjozMDU0NDU5Mjc4fQ.F5xyp4DzLIkcAtQF5ppn9-9lixq1KLn_VV8FjBfkAE4";
	    String json = "{\"field\":\"teewewst\",\"obj\":{\"name\":\"zhangsan\"}}";  
	  
	    HttpClient httpClient = HttpClientBuilder.create().build();  
	    HttpPost post = new HttpPost(url);  
	    StringEntity postingString = new StringEntity(json);// json传递  
	    post.setEntity(postingString);  
	    post.setHeader("Content-type", "application/json");  
	    HttpResponse response = httpClient.execute(post);  
	    String content = EntityUtils.toString(response.getEntity());  
	    // Log.i("test",content);  
	    System.out.println(content);
	}
	
}
