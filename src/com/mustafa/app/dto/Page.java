package com.mustafa.app.dto;

public class Page {

	int page;
	String order;
	String dir;

	public Page(int page, String order, String dir) {
		super();
		this.page = page;
		this.order = order;
		this.dir = dir;
	}

	public int getPage() {
		return page;
	}

	public String getOrder() {
		return order;
	}

	public String getDir() {
		return dir;
	}

}
