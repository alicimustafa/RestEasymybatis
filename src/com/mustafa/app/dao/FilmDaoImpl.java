package com.mustafa.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mustafa.app.entity.Film;

import mappers.FilmMapper;

public class FilmDaoImpl extends Dao implements FilmDao{
	
	private final static FilmDao INSTANCE = new FilmDaoImpl();
	
	public static FilmDao getInstance()	{
		return INSTANCE;
	}
	
	private FilmDaoImpl() {
	}
	
	@Override
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

	@Override
	public List<Film> getAllFilms() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Film> films = null;
		try {
			FilmMapper mapper = session.getMapper(FilmMapper.class);
			films = mapper.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return films;
	}
}
