package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;

public class RestClient {

	// 1. GET Method
	public void get(String url) throws ParseException, IOException{
		
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpGet httpget = new HttpGet(url);
	CloseableHttpResponse closeablehttpResponse =httpClient.execute(httpget); //hit GET
	
	//Status code
	int statusCode = closeablehttpResponse.getStatusLine().getStatusCode();
	Assert.assertEquals(statusCode, 200,"Status code is not 200");
	System.out.println("Status code: "+statusCode);

	//json string
	String responseString = EntityUtils.toString(closeablehttpResponse.getEntity(), "UTF-8");
	JSONObject responseJson = new JSONObject(responseString);
	
	System.out.println("Complete API response: "+responseJson.toString());
	
	//To get all Headers
	Header[] headerArray = closeablehttpResponse.getAllHeaders();
	
	HashMap<String, String> allHeaders = new HashMap<String, String>();
	
	for(Header header: headerArray){
		allHeaders.put(header.getName(), header.getValue());
	}
	
	System.out.println("Headers array-->"+allHeaders);
	
		
	}

}
