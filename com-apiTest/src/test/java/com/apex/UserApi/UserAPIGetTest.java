package com.apex.UserApi;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apex.constants.TestConstants;
import com.apex.core.HttpResponseValidator;
import com.apex.core.HttpUtil;
import com.apex.core.JsonUtil;
import com.apex.pojo.User;
import com.google.gson.Gson;

public class UserAPIGetTest implements TestConstants {

	@DataProvider
	public Object[][] getValidUserIds() {
		String[][] data = { { "2382" }, { "2390" }, { "2220" } };
		return data;
	}

	@DataProvider
	public Object[][] getInValidUsers() {
		String[][] data = { { "abc" }, { "xyca" } };
		return data;
	}

	@Test(dataProvider = "getValidUserIds")
	public void testSuccessDataValidUser(String userID) throws ClientProtocolException, IOException {

		String resourcePath = USER_RESOURCE_PATH + userID;

		HttpResponse response = HttpUtil.getResponse(resourcePath);

		String responseMsg = HttpUtil.getResponseMessage(response);
		System.out.println("Message " + responseMsg);
		User user=new User();
		user = JsonUtil.fromJson(responseMsg,user);

		System.out.println("Gson :" + user.toString());
		HttpResponseValidator.basicValidation(response, STATUS_CODE_200, STATUS_MESSAGE_OK);
	}

	

	@Test
	public void testBlankUserId() throws ClientProtocolException, IOException {
		String userID = "";
		String resourcePath = USER_RESOURCE_PATH + userID;

		HttpResponse response = HttpUtil.getResponse(resourcePath);

		String responseMsg = HttpUtil.getResponseMessage(response);
		System.out.println("Message " + responseMsg);
		Gson gson = new Gson();
		User[] user = gson.fromJson(responseMsg, User[].class);
		for(User u:user) {
			System.out.println(u);
		}
		
		HttpResponseValidator.basicValidation(response, STATUS_CODE_200, STATUS_MESSAGE_OK);
	}

	@Test
	public void testNullUserId() throws ClientProtocolException, IOException {
		String userID = null;
		String resourcePath = USER_RESOURCE_PATH + userID;

		HttpResponse response = HttpUtil.getResponse(resourcePath);

		String responseMsg = HttpUtil.getResponseMessage(response);
		System.out.println("Message " + responseMsg);

		HttpResponseValidator.basicValidation(response, STATUS_CODE_404, STATUS_MESSAGE_NOT_FOUND);

	}

	@Test(dataProvider = "getInValidUsers")
	public void testInvalidUserId(String userID) throws ClientProtocolException, IOException {

		String resourcePath = USER_RESOURCE_PATH + userID;

		HttpResponse response = HttpUtil.getResponse(resourcePath);

		String responseMsg = HttpUtil.getResponseMessage(response);
		System.out.println("Message " + responseMsg);

		HttpResponseValidator.basicValidation(response, STATUS_CODE_404, STATUS_MESSAGE_NOT_FOUND);

	}
}
