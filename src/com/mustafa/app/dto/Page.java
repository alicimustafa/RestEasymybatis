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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dir == null) ? 0 : dir.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + page;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		if (dir == null) {
			if (other.dir != null)
				return false;
		} else if (!dir.equals(other.dir))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (page != other.page)
			return false;
		return true;
	}
	
}
