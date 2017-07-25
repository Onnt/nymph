package cn.virde.nymph.net;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import cn.virde.nymph.util.Log;

public class NymHttp extends NymHttpGet{
	
	public void post(String url,List<NameValuePair> params){
		CloseableHttpClient httpclient = HttpClients.createDefault();
	    HttpPost httpPost = new HttpPost(url);
	    //拼接参数
	    httpPost.setEntity(new UrlEncodedFormEntity(params,StandardCharsets.UTF_8));
	    CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
	        Log.info("状态："+response.getStatusLine()+" 请求url：" + url);
	        HttpEntity entity2 = response.getEntity();
	        EntityUtils.consume(entity2);
		} catch (IOException e) {
			Log.info("请求url："+url+"时出现IO异常", e);
		}finally {
	        try {
				response.close();
			} catch (IOException e) {
				Log.info("请求url："+url+"在关闭返回时出现IO异常", e);
			}
	    }
		
	}
	
	public String getHtml(String url){
		return new NymHttpGetHtml().getHtml(url);
	}
	
	private static void doGet() throws ClientProtocolException, IOException{
	    CloseableHttpClient httpclient = HttpClients.createDefault();
	    HttpGet httpGet = new HttpGet("http://www.baidu.com");
	    CloseableHttpResponse response1 = httpclient.execute(httpGet);
	    // The underlying HTTP connection is still held by the response object
	    // to allow the response content to be streamed directly from the network socket.
	    // In order to ensure correct deallocation of system resources
	    // the user MUST either fully consume the response content  or abort request
	    // execution by calling CloseableHttpResponse#close().
	    //建立的http连接，仍旧被response1保持着，允许我们从网络socket中获取返回的数据
	    //为了释放资源，我们必须手动消耗掉response1或者取消连接（使用CloseableHttpResponse类的close方法）

	    try {
	        System.out.println(response1.getStatusLine());
	        HttpEntity entity1 = response1.getEntity();
	        // do something useful with the response body
	        // and ensure it is fully consumed
	        EntityUtils.consume(entity1);
	    } finally {
	        response1.close();
	    }
	} 
	
}
