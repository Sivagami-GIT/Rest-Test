package com.apex.core;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.apex.constants.TestConstants;

public class HttpUtil implements TestConstants {

	public static HttpResponse getResponse(String resorucePath) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(BASE_URL + resorucePath);

		request.setHeader(AUTH_HEADER, AUTH_TYPE + FINAL_TOKEN);
		HttpResponse response = client.execute(request);
		return response;
	}

	public static HttpResponse postResponse(String resorucePath, String data)
			throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(BASE_URL + resorucePath);
		request.setHeader(AUTH_HEADER, AUTH_TYPE + FINAL_TOKEN);
		StringEntity entity = new StringEntity(data);
		request.setEntity(entity);
		request.setHeader("Accept", "application/json");
		request.setHeader("Content-type", "application/json");
		HttpResponse response = client.execute(request);
		return response;
	}

	public static HttpResponse putResponse(String resorucePath, String data)
			throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPut request = new HttpPut(BASE_URL + resorucePath);
		request.setHeader(AUTH_HEADER, AUTH_TYPE + FINAL_TOKEN);
		StringEntity entity = new StringEntity(data);
		request.setEntity(entity);
		HttpResponse response = client.execute(request);
		return response;
	}

	public static HttpResponse deleteResponse(String resorucePath, String data)
			throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete request = new HttpDelete(BASE_URL + resorucePath);
		request.setHeader(AUTH_HEADER, AUTH_TYPE + FINAL_TOKEN);
		HttpResponse response = client.execute(request);
		return response;
	}

	public static String getResponseMessage(HttpResponse response) throws IOException {
		HttpEntity entity = response.getEntity();
		String reponseMessage = "";
		if (entity != null) {
			reponseMessage = EntityUtils.toString(entity);
		}
		return reponseMessage;
	}

}
