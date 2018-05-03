package com.mustafa.app.dataservice;

import java.util.List;

import com.mustafa.app.dao.FilmDao;
import com.mustafa.app.dto.Page;
import com.mustafa.app.entity.Film;
import com.mustafa.app.entity.FilmShort;

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
	
	public List<FilmShort> getPageAll(String page, String order, String dir){
		try {
			int num = (Integer.parseInt(page) -1) * 20;
			String orderBy = null;
			String direction = null;
			if(dir.equals("asc")) {
				direction = "ASC";
			} else if(dir.equals("des")) {
				direction = "DESC";
			} 
			switch(order) {
			case "title": 
				orderBy = "title";
				break;
			case "year": 
				orderBy = "release_year";	
				break;
			case "length":
				orderBy = "length";
				break;
			case "rating":
				if(dir.equals("asc")) {
					return filmDao.AllpageOrderRatingAsc(num);
				} else if(dir.equals("des")) {
					return filmDao.AllpageOrderRatingDesc(num);
				} 
				break;
			}
			Page pageObj = new Page(num, orderBy, direction);
			return filmDao.AllpageOrder(pageObj);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
