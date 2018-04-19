package com.mustafa.app.dao;

import java.util.List;

import com.mustafa.app.entity.Film;

public interface FilmDao {
	Film getFilmById(int id);
	List<Film> getAllFilms();
}
