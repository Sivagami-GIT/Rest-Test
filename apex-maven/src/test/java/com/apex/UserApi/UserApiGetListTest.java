package com.apex.UserApi;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;

import com.apex.constants.TestConstants;
import com.apex.core.HttpResponseValidator;
import com.apex.core.HttpUtil;

public class UserApiGetListTest {
	public void testSuccessData() throws ClientProtocolException, IOException {
		String resourcePath = "public//v2//users//";
		HttpResponse response = HttpUtil.getResponse(resourcePath);
		HttpResponseValidator.basicValidation(response, TestConstants.STATUS_CODE_200, TestConstants.STATUS_MESSAGE_OK);
		String responseMsg = HttpUtil.getResponseMessage(response);
		System.out.println(responseMsg);
		Assert.assertTrue(responseMsg.contains("Agnivesh Singh"));
	}
}
