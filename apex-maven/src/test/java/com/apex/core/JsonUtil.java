package com.apex.core;

import com.apex.pojo.User;
import com.google.gson.Gson;

public class JsonUtil {
	public static String toJson(User user) {
		Gson gson = new Gson();
		String jsonString = gson.toJson(user);
		return jsonString;
	}
	public static <T> T fromJson(String responseMsg, T toValue) {
		Gson gson = new Gson();
		T obj = (T) gson.fromJson(responseMsg, toValue.getClass());
		return obj;
	}
}
