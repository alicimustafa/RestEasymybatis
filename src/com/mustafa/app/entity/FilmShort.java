package com.mustafa.app.entity;

import java.sql.Date;

public class FilmShort {
	private Long id;
	private String title;
	private Date releaseYear;
	private Integer length;
	private String rating;

	public FilmShort(Long id, String title, Date releaseYear, Integer length, String rating) {
		super();
		this.id = id;
		this.title = title;
		this.releaseYear = releaseYear;
		this.length = length;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public Integer getLength() {
		return length;
	}

	public String getRating() {
		return rating;
	}

}
