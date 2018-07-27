package cn.virde.nymph.net.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import cn.virde.nymph.Nym;
import cn.virde.nymph.exception.Not200Exception;
import cn.virde.nymph.net.NymHttpGetHtml;
import cn.virde.nymph.util.Log;

/**
 * 
 * @author Virde
 * @date 2018年6月7日 下午3:40:29
 */
public class NymHttpPostRequest extends NymHttpGetRequest{

	/**
	 * 
	 * @author Virde
	 * @date 2018年6月7日 下午3:44:13
	 * @param url
	 * @param params
	 * @param clazz
	 * @return
	 * @throws NymHttpException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws Not200Exception 
	 * @throws IOException 
	 */
	public <T> T post(String url,Object params,Class<T> clazz) throws NymHttpException{
		try {
			Map<String, String> mapParams = Nym.clazz.getField(params);
			return post(url, mapParams, clazz);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new NymHttpException("params error, detail info:"+e.getMessage()) ;
		}
	}
	public <T> T post(String url,Map<String,String> map,Class<T> clazz) throws NymHttpException{
		try {
			String result = post(url, map);
			return Nym.json.jsonToObject(result, clazz);
		}catch (IOException | Not200Exception e) {
			throw new NymHttpException("IO Exception, detail info:"+e.getMessage()) ;
		}
	}
	public <T> T post(String url,String key,String value,Class<T> clazz) throws NymHttpException {
		Map<String,String> map = new HashMap<String,String>();
		map.put(key, value);
		return post(url, map, clazz);
	}

	public <T> T post(Class<T> clazz,String...args) throws NymHttpException {
		String url = args[0];
		if(args.length > 1 && args.length % 2 != 1) {
			throw new NymHttpException("a key required need a value");
		}
		if(args.length == 1) {
			return post(url,null,clazz) ;
		}
		return get(url, getParams(args), clazz) ;
	}
	/**
	 * 
	 * @author Virde
	 * @date 2018年6月7日 下午3:43:35
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws Not200Exception
	 */
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
	
	/**
	 * 
	 * @param url
	 * @param key
	 * @param value
	 * @param raw
	 * @param clazz
	 * @return
	 * @throws NymHttpException
	 */
	public <T> T postRaw(String url,String key,String value,Object raw,Class<T> clazz) throws NymHttpException {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();  
			HttpPost post = new HttpPost(Nym.string.makeUrlWithParams(url,key,value));  
			StringEntity postingString = new StringEntity(Nym.json.objectToJsonString(raw),"utf-8");
			// json传递  
		    post.setEntity(postingString); 
		    post.setHeader("Content-type", "application/json; charset=utf-8");  
		    HttpResponse response = httpClient.execute(post);  
		    String content = EntityUtils.toString(response.getEntity());
			return Nym.json.jsonToObject(content, clazz); 
		} catch (IOException e) {
			throw new NymHttpException("io error，detail info :" + e.getMessage() );
		}
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
}
