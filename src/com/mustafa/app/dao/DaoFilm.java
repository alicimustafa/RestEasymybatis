package com.mustafa.app.dao;

import org.apache.ibatis.session.SqlSession;

import com.mustafa.app.entity.Film;

import mappers.FilmMapper;

public class DaoFilm extends Dao {
	
	private final static DaoFilm INSTANCE = new DaoFilm();
	
	public static DaoFilm getInstance()	{
		return INSTANCE;
	}
	
	private DaoFilm() {
	}
	
	public Film getFilmById(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		Film film = null;
		try {
			FilmMapper mapper = session.getMapper(FilmMapper.class);
			film = mapper.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return film;
	}
}
