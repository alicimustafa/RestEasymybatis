package com.mustafa.app.dataservice;

import com.mustafa.app.dao.DaoFilm;
import com.mustafa.app.entity.Film;

public class FilmDataService {

	private final static FilmDataService INSTANCE = new FilmDataService();

	public static FilmDataService getInstance() {
		return INSTANCE;
	}
	
	private FilmDataService() {
	}
	
	private final DaoFilm daoFilm = DaoFilm.getInstance();
	
	public Film getFilmById(String id) {
		int intId = Integer.parseInt(id);
		return daoFilm.getFilmById(intId);
	}
}
