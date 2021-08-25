package com.rentify.java.RentifyApplication.entity;

public class ApiResponse {

	private String successResponse;
	private String errorResponse;
	public ApiResponse(String successResponse, String errorResponse) {
		super();
		this.successResponse = successResponse;
		this.errorResponse = errorResponse;
	}
	
	
}
