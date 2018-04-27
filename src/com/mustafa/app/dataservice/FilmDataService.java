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
		System.out.println(page);
		System.out.println(order);
		System.out.println(dir);
		try {
			int num = (Integer.parseInt(page) -1) * 20;
			String orderBy = null;
			String direction = null;
			if(dir.equals("asc")) {
				direction = "ASC";
			} else if(dir.equals("des")) {
				System.out.println("in desc");
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
				System.out.println("in rating");
				if(dir.equals("asc")) {
					System.out.println("in rating asc");
					return filmDao.AllpageOrderRatingAsc(num);
				} else if(dir.equals("des")) {
					return filmDao.AllpageOrderRatingDesc(num);
				} 
				break;
			}
			System.out.println(num);
			System.out.println(orderBy);
			System.out.println(direction);
			Page pageObj = new Page(num, orderBy, direction);
			return filmDao.AllpageOrder(pageObj);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
