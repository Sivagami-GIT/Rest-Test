package com.apex.constants;

public interface TestConstants {
	public static final String BASE_URL = "https://gorest.co.in//";
	public static final String USER_RESOURCE_PATH = "public//v2//users//";
	
	public static final String FINAL_TOKEN = "ead986ce4dad0788edbb55db3285b4942c6ea82ba6e8add2ca78a4330dc7c9d0";
	public static final String AUTH_HEADER = "Authorization";
	public static final String AUTH_TYPE = "Bearer ";
	// Status code ok
	public static final int STATUS_CODE_200 = 200;
	public static final String STATUS_MESSAGE_OK = "OK";
	// Status code created
	public static final int STATUS_CODE_201 = 201;
	public static final String STATUS_MESSAGE_CREATED = "Created";
	// Status code no content
	public static final int STATUS_CODE_204 = 204;
	public static final String STATUS_MESSAGE_NOCONTENT = "NO CONTENT";
	// Status code bad request
	public static final int STATUS_CODE_400 = 400;
	public static final String STATUS_MESSAGE_BAD_REQUEST = "BAD REQUEST";
	// Status code unauthorized
	public static final int STATUS_CODE_401 = 401;
	public static final String STATUS_MESSAGE_UNAUTHORIZED = "unauthorized";
	// Status code Forbidden
	public static final int STATUS_CODE_403 = 403;
	public static final String STATUS_MESSAGE_FORBIDDEN = "Forbidden";
	// Status code not found
	public static final int STATUS_CODE_404 = 404;
	public static final String STATUS_MESSAGE_NOT_FOUND = "Not Found";
	// Status code conflict
	public static final int STATUS_CODE_409 = 409;
	public static final String STATUS_MESSAGE_CONFLICT = "conflict";
	//Status code Unprocessable Entity
	public static final int STATUS_CODE_422=422;
	public static final String STATUS_MESSAGE_UNPROCESSABLE_ENTITY = "Unprocessable Entity";
	
	// Status code server error
	public static final int STATUS_CODE_500 = 500;
	public static final String STATUS_MESSAGE_SERVER_ERROR = "server error";
	
}
