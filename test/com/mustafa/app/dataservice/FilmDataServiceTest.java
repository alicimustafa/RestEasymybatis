package com.mustafa.app.dataservice;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mustafa.app.dao.FilmDao;
import com.mustafa.app.dto.Page;
import com.mustafa.app.entity.Film;
import com.mustafa.app.entity.FilmShort;

@RunWith(MockitoJUnitRunner.class)
public class FilmDataServiceTest {
	
	
	
	@Mock
	private FilmDao mockDao;
	
	@InjectMocks
	private FilmDataService filmDataService;
	
	@Captor
	private ArgumentCaptor<Page> pageCapture;
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}
	
	@Test
	public void test_getFilmById_calls_Dao_with_correct_value() {
		filmDataService.getFilmById("1");
		verify(mockDao).getFilmById(1);
		verify(mockDao, times(1)).getFilmById(1);
	}
	
	@Test
	public void test_getFilmById_returns_correct_film() {
		Film filmIn = new Film(1L, 
				"my movie", "stuff", Date.valueOf("2000-1-1"), 3, 4, 
				BigDecimal.valueOf(1.99), 120, BigDecimal.valueOf(15.99), 
				"R", "none");
		when(mockDao.getFilmById(1)).thenReturn(filmIn);
		assertEquals("my movie", filmDataService.getFilmById("1").getTitle());
		assertEquals("stuff", filmDataService.getFilmById("1").getDescription());
		assertEquals(Date.valueOf("2000-1-1"), filmDataService.getFilmById("1").getReleaseYear());
		verify(mockDao, times(3)).getFilmById(1);
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
		verify(mockDao, times(2)).getAllFilms();
	}
	
	@Test
	public void test_getPageAll_calls_AllpageOrderRatingAsc_corrct_page_num_when_passed_rating_asc() {
		filmDataService.getPageAll("1", "rating", "asc");
		verify(mockDao).AllpageOrderRatingAsc(0);
		verify(mockDao, times(1)).AllpageOrderRatingAsc(0);
		filmDataService.getPageAll("2", "rating", "asc");
		verify(mockDao).AllpageOrderRatingAsc(20);
		verify(mockDao, times(1)).AllpageOrderRatingAsc(20);
		filmDataService.getPageAll("3", "rating", "asc");
		verify(mockDao).AllpageOrderRatingAsc(40);
		verify(mockDao, times(1)).AllpageOrderRatingAsc(40);
		filmDataService.getPageAll("4", "rating", "asc");
		verify(mockDao).AllpageOrderRatingAsc(60);
		verify(mockDao, times(1)).AllpageOrderRatingAsc(60);
	}
	
	@Test
	public void test_getPageAll_calls_AllpageOrderRatingDesc_corrct_page_num_when_passed_rating_des() {
		filmDataService.getPageAll("1", "rating", "des");
		verify(mockDao).AllpageOrderRatingDesc(0);
		verify(mockDao, times(1)).AllpageOrderRatingDesc(0);
		filmDataService.getPageAll("2", "rating", "des");
		verify(mockDao).AllpageOrderRatingDesc(20);
		verify(mockDao, times(1)).AllpageOrderRatingDesc(20);
		filmDataService.getPageAll("3", "rating", "des");
		verify(mockDao).AllpageOrderRatingDesc(40);
		verify(mockDao, times(1)).AllpageOrderRatingDesc(40);
		filmDataService.getPageAll("4", "rating", "des");
		verify(mockDao).AllpageOrderRatingDesc(60);
		verify(mockDao, times(1)).AllpageOrderRatingDesc(60);
	}
	
	@Test
	public void test_getPageAll_calls_AllpageOrder_with_correct_page_when_release_year_asc() {
		filmDataService.getPageAll("1", "year", "asc");
		verify(mockDao).AllpageOrder(pageCapture.capture());
		assertEquals(0, pageCapture.getValue().getPage());
		assertEquals("release_year", pageCapture.getValue().getOrder());
		assertEquals("ASC", pageCapture.getValue().getDir());
	}
	
	@Test
	public void test_getPageAll_calls_AllPageOrder_with_correct_page_when_release_year_des() {
		filmDataService.getPageAll("2", "year", "des");
		verify(mockDao).AllpageOrder(pageCapture.capture());
		assertEquals(20, pageCapture.getValue().getPage());
		assertEquals("release_year", pageCapture.getValue().getOrder());
		assertEquals("DESC", pageCapture.getValue().getDir());
	}
	
	@Test
	public void test_getPageAll_calls_AllPageOrder_with_correct_page_when_title_asc() {
		filmDataService.getPageAll("3", "title", "asc");
		verify(mockDao).AllpageOrder(pageCapture.capture());
		assertEquals(40, pageCapture.getValue().getPage());
		assertEquals("title", pageCapture.getValue().getOrder());
		assertEquals("ASC", pageCapture.getValue().getDir());
	}
	
	@Test
	public void test_getPageAll_calls_AllPageOrder_with_correct_page_when_title_des() {
		filmDataService.getPageAll("3", "title", "des");
		verify(mockDao).AllpageOrder(pageCapture.capture());
		assertEquals(40, pageCapture.getValue().getPage());
		assertEquals("title", pageCapture.getValue().getOrder());
		assertEquals("DESC", pageCapture.getValue().getDir());
	}
	
	@Test
	public void test_getPageAll_calls_AllPageOrder_with_correct_page_when_lenght_asc() {
		filmDataService.getPageAll("3", "length", "asc");
		verify(mockDao).AllpageOrder(pageCapture.capture());
		assertEquals(40, pageCapture.getValue().getPage());
		assertEquals("length", pageCapture.getValue().getOrder());
		assertEquals("ASC", pageCapture.getValue().getDir());
	}
	
	@Test
	public void test_getPageAll_calls_AllPageOrder_with_correct_page_when_lenght_des() {
		filmDataService.getPageAll("3", "length", "des");
		verify(mockDao).AllpageOrder(pageCapture.capture());
		assertEquals(40, pageCapture.getValue().getPage());
		assertEquals("length", pageCapture.getValue().getOrder());
		assertEquals("DESC", pageCapture.getValue().getDir());
	}
	
	@Test
	public void test_getPageAll_calls_AllpageOrder_with_correct_page() {
		List<FilmShort> films = new ArrayList<>();
		films.add(new FilmShort(1L, "fun", Date.valueOf("2000-1-1"), 90, "R"));
		films.add(new FilmShort(2L, "boring", Date.valueOf("1990-1-1"), 80, "G"));
		films.add(new FilmShort(3L, "stuf", Date.valueOf("2010-1-1"), 120, "PG"));
		
		Page page = new Page(0, "release_year", "ASC");
		
		when(mockDao.AllpageOrder(page)).thenReturn(films);
		when(mockDao.getAllCount()).thenReturn(3);
		
		assertEquals(3, filmDataService.getPageAll("1", "year", "asc").getFilms().size());
		assertEquals(1, filmDataService.getPageAll("1", "year", "asc").getPages());
		assertEquals("fun", filmDataService.getPageAll("1", "year", "asc")
				.getFilms().get(0).getTitle());
		assertEquals(Date.valueOf("2010-1-1"), 
				filmDataService.getPageAll("1", "year", "asc")
				.getFilms().get(2).getReleaseYear());
		assertEquals(90, 
				filmDataService.getPageAll("1", "year", "asc")
				.getFilms().get(0).getLength().intValue());
		assertEquals("G", 
				filmDataService.getPageAll("1", "year", "asc")
				.getFilms().get(1).getRating());
		verify(mockDao, times(6)).AllpageOrder(page);
	}
}
