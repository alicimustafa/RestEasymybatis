package com.mustafa.app.dao;

import java.util.List;

import com.mustafa.app.dto.Page;
import com.mustafa.app.entity.Film;
import com.mustafa.app.entity.FilmShort;

public interface FilmDao {
	Film getFilmById(int id);
	List<Film> getAllFilms();
	List<FilmShort> AllpageOrder(Page page);
	List<FilmShort> AllpageOrderRatingAsc(int page);
	List<FilmShort> AllpageOrderRatingDesc(int page);
	int getAllCount();

}
