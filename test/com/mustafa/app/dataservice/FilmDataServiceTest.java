package com.mustafa.app.dataservice;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.mustafa.app.dao.FilmDao;
import com.mustafa.app.entity.Film;

@RunWith(MockitoJUnitRunner.class)
public class FilmDataServiceTest {
	
	
	private FilmDataService filmDataService;
	private FilmDao mockDao = Mockito.mock(FilmDao.class);
	
	@Before
	public void setUp() {
		filmDataService = new FilmDataService(mockDao);
	}
	
	@After
	public void tearDown() {
		filmDataService = null;
	}
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test_getFilmById_returns_correct_film() {
		Film film = new Film(1L, 
				"my movie", "stuff", Date.valueOf("2000-1-1"), 3, 4, 
				BigDecimal.valueOf(1.99), 120, BigDecimal.valueOf(15.99), 
				"R", "none");
		when(mockDao.getFilmById(1)).thenReturn(film);
		assertEquals("my movie", filmDataService.getFilmById("1").getTitle());
		assertEquals("stuff", filmDataService.getFilmById("1").getDescription());
		assertEquals(Date.valueOf("2000-1-1"), filmDataService.getFilmById("1").getReleaseYear());
		
	}
	
	@Test
	public void test_getAllFilms_returns_list_of_films() {
		List<Film> films = new ArrayList<>();
		films.add(new Film(1L, 
				"my movie", "stuff", Date.valueOf("2000-1-1"), 3, 4, 
				BigDecimal.valueOf(1.99), 120, BigDecimal.valueOf(15.99), 
				"R", "none"));
		films.add(new Film(3L, 
				"fun movie", "more stuff", Date.valueOf("2012-1-1"), 2, 5, 
				BigDecimal.valueOf(2.99), 90, BigDecimal.valueOf(18.99), 
				"PG", "lots"));
		when(mockDao.getAllFilms()).thenReturn(films);
		assertEquals(2, filmDataService.getAllFilms().size());
		assertEquals("fun movie", filmDataService.getAllFilms().get(1).getTitle());
	}
}
