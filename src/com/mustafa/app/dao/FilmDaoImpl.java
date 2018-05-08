package com.mustafa.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mustafa.app.dto.Page;
import com.mustafa.app.entity.Film;
import com.mustafa.app.entity.FilmShort;

import mappers.FilmMapper;
import mappers.FilmShortMapper;

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

	@Override
	public List<FilmShort> AllpageOrder(Page page) {
		SqlSession session = sqlSessionFactory.openSession();
		List<FilmShort> films = null;
		try {
			FilmShortMapper mapper = session.getMapper(FilmShortMapper.class);
			films = mapper.AllpageOrder(page);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return films;
	}

	@Override
	public List<FilmShort> AllpageOrderRatingAsc(int page) {
		SqlSession session = sqlSessionFactory.openSession();
		List<FilmShort> films = null;
		try {
			FilmShortMapper mapper = session.getMapper(FilmShortMapper.class);
			films = mapper.AllpageOrderRatingAsc(page);
		} catch(Exception e) {
			session.close();
		}
		return films;
	}

	@Override
	public List<FilmShort> AllpageOrderRatingDesc(int page) {
		SqlSession session = sqlSessionFactory.openSession();
		List<FilmShort> films = null;
		try {
			FilmShortMapper mapper = session.getMapper(FilmShortMapper.class);
			films = mapper.AllpageOrderRatingDesc(page);
		} catch(Exception e) {
			session.close();
		}
		return films;
	}

	@Override
	public int getAllCount() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		int count = 0;
		FilmShortMapper mapper = session.getMapper(FilmShortMapper.class);
		count = mapper.count();
		return count;
	}


}
