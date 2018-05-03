package com.mustafa.app.dto;

import java.util.ArrayList;
import java.util.List;

public class JsonResponse {

	private int status;
	private List<String> errors = new ArrayList<>();
	private List<String> warnings = new ArrayList<>();
	private List<String> information = new ArrayList<>();
	private Object data;
	
	public JsonResponse() {
		status = 200;
	}

	public JsonResponse(int status) {
		super();
		this.status = status;
	}

	public JsonResponse(Object data) {
		super();
		this.status = 200;
		this.data = data;
	}

	public JsonResponse(int status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}
	
	public JsonResponse(String error) {
		super();
		this.status = 500;
		this.errors.add(error);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors.add(errors);
	}

	public List<String> getWarnings() {
		return warnings;
	}

	public void setWarnings(String warnings) {
		this.warnings.add(warnings);
	}

	public List<String> getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information.add(information);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
