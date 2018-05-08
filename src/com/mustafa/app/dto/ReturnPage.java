package com.mustafa.app.dto;

import java.util.List;

import com.mustafa.app.entity.FilmShort;

public class ReturnPage {

	private int pages;
	private List<FilmShort> films;

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<FilmShort> getFilms() {
		return films;
	}

	public void setFilms(List<FilmShort> films) {
		this.films = films;
	}

}
