package cn.virde.nymph.net;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import cn.virde.nymph.util.Log;

public class NymHttp extends NymHttpGet{
	
	public void post(String url,List<NameValuePair> params) throws IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
	    HttpPost httpPost = new HttpPost(url);
	    //拼接参数
	    if(params != null){
	    	httpPost.setEntity(new UrlEncodedFormEntity(params,StandardCharsets.UTF_8));
	    }
	    CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
	        Log.info("状态："+response.getStatusLine()+" 请求url：" + url);
	        HttpEntity entity2 = response.getEntity();
	        EntityUtils.consume(entity2);
		} catch (IOException e) {
			Log.info("请求url："+url+"时出现IO异常", e);
			throw e ;
		}finally {
	        try {
				response.close();
			} catch (IOException e) {
				Log.info("请求url："+url+"在关闭返回时出现IO异常", e);
				throw e ;
			}
	    }
		
	}
	
	public String getHtml(String url){
		return new NymHttpGetHtml().getHtml(url);
	}
	
	
}
