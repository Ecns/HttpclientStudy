package com.crawler;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpclientTimeout2 {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault(); //初始化httpClient
		HttpGet httpGet=new HttpGet("http://www.w3school.com.cn/b.asp");//Get请求(Post方法相似)
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();//设置请求和传输超时时间
		httpGet.setConfig(requestConfig);  //httpget信息配置
		CloseableHttpResponse response = null;  
		try {  
			response = httpClient.execute(httpGet);  //使用get方法发送请求
		}catch (Exception e){  
			e.printStackTrace();  
		} 
		String result = EntityUtils.toString(response.getEntity(),"gbk");  //获取结果，html
		System.out.println(result);   //输出结果
	}

}
