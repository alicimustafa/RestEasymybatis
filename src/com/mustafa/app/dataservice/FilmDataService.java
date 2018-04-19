package com.mustafa.app.dataservice;

import java.util.List;

import com.mustafa.app.dao.FilmDao;
import com.mustafa.app.entity.Film;

public class FilmDataService {

	private final FilmDao filmDao;
	
    public FilmDataService(FilmDao filmDao) {
		this.filmDao = filmDao;
	}
	
	public Film getFilmById(String id) {
		int intId = Integer.parseInt(id);
		return filmDao.getFilmById(intId);
	}
	
	public List<Film> getAllFilms(){
		return filmDao.getAllFilms();
	}
}
