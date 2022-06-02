package com.apex.UserApi;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.apex.constants.TestConstants;
import com.apex.core.HttpResponseValidator;
import com.apex.core.HttpUtil;
import com.apex.core.JsonUtil;
import com.apex.pojo.User;

public class UserApiPostTest2 implements TestConstants {

	@Test
	public void addUserValidData() throws ClientProtocolException, IOException {
//		String payload = "{\"name\":\"tenOne\"," + "\"email\":\"tttenone@one11.com\", " + "\"gender\":\"male\","
//				+ "\"status\":\"active\"}";
		User user = new User("Name1", "nam887887@name.com", "female", "inactive");

		String jsonString = JsonUtil.toJson(user);

		HttpResponse response = HttpUtil.postResponse(USER_RESOURCE_PATH, jsonString);
		String responseMsg = HttpUtil.getResponseMessage(response);
		System.out.println("Create response " + responseMsg);

		HttpResponseValidator.basicValidation(response, STATUS_CODE_201, STATUS_MESSAGE_CREATED);
	}

	@Test
	public void addNewUserWithExistingEmail() throws ClientProtocolException, IOException {
		User user = new User("Name1", "name111@name111.com", "female", "inactive");

		String jsonString = JsonUtil.toJson(user);

		HttpResponse response = HttpUtil.postResponse(USER_RESOURCE_PATH, jsonString);
		String responseMsg = HttpUtil.getResponseMessage(response);
		System.out.println("Create response " + responseMsg);

		HttpResponseValidator.basicValidation(response, STATUS_CODE_422, STATUS_MESSAGE_UNPROCESSABLE_ENTITY);
	}

	@Test
	public void addWithBlankData() throws ClientProtocolException, IOException {
		User user = new User("", "", "", "");
		String jsonString = JsonUtil.toJson(user);

		HttpResponse response = HttpUtil.postResponse(USER_RESOURCE_PATH, jsonString);
		String responseMsg = HttpUtil.getResponseMessage(response);
		System.out.println("Create response " + responseMsg);

		HttpResponseValidator.basicValidation(response, STATUS_CODE_422, STATUS_MESSAGE_UNPROCESSABLE_ENTITY);

	}

	@Test
	public void addWithSplCharData() throws ClientProtocolException, IOException {
		User user = new User("$$$$", "$$$@$$$", "^^^^", "&&&&");
		String jsonString = JsonUtil.toJson(user);

		HttpResponse response = HttpUtil.postResponse(USER_RESOURCE_PATH, jsonString);
		String responseMsg = HttpUtil.getResponseMessage(response);
		System.out.println("Create response " + responseMsg);

		HttpResponseValidator.basicValidation(response, STATUS_CODE_422, STATUS_MESSAGE_UNPROCESSABLE_ENTITY);

	}

	@Test
	public void addWithNullData() throws ClientProtocolException, IOException {
		User user = new User(null, null, null, null);
		String jsonString = JsonUtil.toJson(user);

		HttpResponse response = HttpUtil.postResponse(USER_RESOURCE_PATH, jsonString);
		String responseMsg = HttpUtil.getResponseMessage(response);
		System.out.println("Create response " + responseMsg);

		HttpResponseValidator.basicValidation(response, STATUS_CODE_422, STATUS_MESSAGE_UNPROCESSABLE_ENTITY);

	}

	@Test
	public void addWithBlankUserName() throws ClientProtocolException, IOException {
		User user = new User("", "name1@name1.com", "female", "active");
		String jsonString = JsonUtil.toJson(user);

		HttpResponse response = HttpUtil.postResponse(USER_RESOURCE_PATH, jsonString);
		String responseMsg = HttpUtil.getResponseMessage(response);
		System.out.println("Create response " + responseMsg);

		HttpResponseValidator.basicValidation(response, STATUS_CODE_422, STATUS_MESSAGE_UNPROCESSABLE_ENTITY);

	}

	@Test
	public void addWithBlankUserEmail() throws ClientProtocolException, IOException {
	}

	@Test
	public void addWithBlankUserGender() throws ClientProtocolException, IOException {
	}

	@Test
	public void addWithBlankUserStatus() throws ClientProtocolException, IOException {
	}

}
