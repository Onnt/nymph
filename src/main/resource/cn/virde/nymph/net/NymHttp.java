package cn.virde.nymph.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import cn.virde.nymph.Nym;
import cn.virde.nymph.exception.Not200Exception;
import cn.virde.nymph.util.Log;

public class NymHttp extends NymHttpGet{
	
	public String post(String url,List<NameValuePair> params) throws IOException, Not200Exception{
		CloseableHttpClient httpclient = HttpClients.createDefault();
	    HttpPost httpPost = new HttpPost(url);
	    //拼接参数
	    if(params != null){
	    	httpPost.setEntity(new UrlEncodedFormEntity(params,StandardCharsets.UTF_8));
	    }
	    
	    CloseableHttpResponse response = httpclient.execute(httpPost);
	    Log.alert("状态："+response.getStatusLine()+" 请求url：" + url);
	        
	    int statusCode = response.getStatusLine().getStatusCode();
		if(statusCode != 200)
			throw new Not200Exception();
			
        InputStream is = response.getEntity().getContent();
        String responseBody = getStreamAsString(is, "UTF-8");
			
	    HttpEntity entity2 = response.getEntity();
	    EntityUtils.consume(entity2);
	    
	    response.close();
	    
	    return responseBody;
				
	}
	
	public String post(String url,Map<String,String> map) throws IOException, Not200Exception {
		return post(url,mapToListParams(map));
	}
	
	private List<NameValuePair> mapToListParams(Map<String,String> map){
		if(map==null || map.size() == 0) return null;
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for(Map.Entry<String, String> m: map.entrySet()) {
			params.add(new BasicNameValuePair(m.getKey(), m.getValue()));
		}
		return params;
	}
	public String getHtml(String url){
		return new NymHttpGetHtml().getHtml(url);
	}
	

    private static String getStreamAsString(InputStream stream, String charset) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset), 8192);
            StringWriter writer = new StringWriter();
 
            char[] chars = new char[8192];
            int count = 0;
            while ((count = reader.read(chars)) > 0) {
                writer.write(chars, 0, count);
            }
 
            return writer.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }
	
	public static void main(String[] args) throws IOException, Not200Exception {

		String reqUrl = "http://localhost:8099/note/add.do";
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		params.add(new BasicNameValuePair("jwt","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ7XCJpZFwiOjIsXCJpcFwiOlwiMTI3LjAuMC4xXCIsXCJuYW1lXCI6XCJzdW5hb1wiLFwidGltZW91dFwiOjB9IiwiaWF0IjoxNTAxNjQxNTEyLCJzdWIiOiJhdXRoIiwiZXhwIjozMDAzMjgzMDI0fQ.IqHkGenfc81DVyjdnOFdOytrd9uj1n5b2WglldfQeno"));
		params.add(new BasicNameValuePair("title", "sdfsd"));
		params.add(new BasicNameValuePair("content", "sdfsddf"));
		params.add(new BasicNameValuePair("style", "note"));
		
		Nym.http.post(reqUrl, params);
	}
	
}
