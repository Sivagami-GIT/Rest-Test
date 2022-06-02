package com.apex.core;

import org.apache.http.HttpResponse;
import org.testng.Assert;

public class HttpResponseValidator {
	public static void basicValidation(HttpResponse response, int statusCode, String statusCodeMessage) {
		Assert.assertEquals(response.getStatusLine().getStatusCode(),statusCode );
		Assert.assertEquals(response.getStatusLine().getReasonPhrase(),statusCodeMessage);
	}
}
