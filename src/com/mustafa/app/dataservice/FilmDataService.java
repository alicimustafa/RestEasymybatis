package com.mustafa.app.dataservice;

import java.util.List;

import com.mustafa.app.dao.FilmDao;
import com.mustafa.app.dto.Page;
import com.mustafa.app.dto.ReturnPage;
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
	
	public ReturnPage getPageAll(String page, String order, String dir){
		try {
			ReturnPage returnPage = new ReturnPage();
			int count = filmDao.getAllCount();
			returnPage.setPages(count % 20 == 0? count/20:(count/20)+1);
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
					returnPage.setFilms(filmDao.AllpageOrderRatingAsc(num));
					return returnPage;
				} else if(dir.equals("des")) {
					returnPage.setFilms(filmDao.AllpageOrderRatingDesc(num));
					return returnPage;
				} 
				break;
			}
			Page pageObj = new Page(num, orderBy, direction);
			returnPage.setFilms(filmDao.AllpageOrder(pageObj));
			return returnPage;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
