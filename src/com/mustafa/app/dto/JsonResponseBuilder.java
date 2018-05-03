package com.mustafa.app.dto;

public class JsonResponseBuilder {

	private JsonResponse jsonResponse;
	
	public JsonResponseBuilder() {
		this.jsonResponse = new JsonResponse();
	}
	
	public JsonResponseBuilder status(int status) {
		this.jsonResponse.setStatus(status);
		return this;
	}
	
	public JsonResponseBuilder errors(String error) {
		this.jsonResponse.setErrors(error);
		return this;
	}
	
	public JsonResponseBuilder information(String information) {
		this.jsonResponse.setInformation(information);
		return this;
	}
	
	public JsonResponseBuilder data(Object data) {
		this.jsonResponse.setData(data);
		return this;
	}
	
	public JsonResponse build() {
		return this.jsonResponse;
	}
}
