package com.mustafa.app.webservices;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.ArraySizeComparator;

import com.mustafa.app.dataservice.FilmDataService;
import com.mustafa.app.entity.Film;
import com.mustafa.app.entity.FilmShort;
import com.mustafa.app.webservice.FilmWebService;

@RunWith(MockitoJUnitRunner.class)
public class FilmWebServiceTest {
	
	private static FilmDataService fds = Mockito.mock(FilmDataService.class);
	private static FilmWebService filmWeb = new FilmWebService(fds);
	private static Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
	
	
	@BeforeClass
    public static void setUpDispatcher() {
        dispatcher.getRegistry().addSingletonResource(filmWeb);
 
    }
	
	@Test
	public void smokeTest() {
		assertEquals(true, true);
	}

	@Test
	public void test_film_id_path_GET_film_web_service() {
		Film film = new Film(1L, 
				"my movie", "stuff", Date.valueOf("2000-1-1"), 3, 4, 
				BigDecimal.valueOf(1.99), 120, BigDecimal.valueOf(15.99), 
				"R", "none");
		String expected = "{id:1,title:\"my movie\",description:\"stuff\","
				+ "releaseYear:\"2000-01-01\", languageId:3,rentalDuration:4,"
				+ "rentalRate:1.99,length:120,replacementCost:15.99,rating:\"R\","
				+ "specialFeatures:\"none\"}";
		when(fds.getFilmById("1")).thenReturn(film);
		try {
			MockHttpRequest request = MockHttpRequest.get("/film/1");
			MockHttpResponse response = new MockHttpResponse();
			dispatcher.invoke(request, response);
			assertEquals(200, response.getStatus());
			JSONAssert.assertEquals(expected, response.getContentAsString(), true);
		
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_film_path_GET_filmWebServices() {
		List<Film> filmList = new ArrayList<>();
		filmList.add(new Film(1L, 
				"my movie", "stuff", Date.valueOf("2010-1-1"), 6, 4, 
				BigDecimal.valueOf(3.99), 80, BigDecimal.valueOf(25.99), 
				"R", "none"));
		filmList.add(new Film(2L, 
				"big dude", "funny", Date.valueOf("2017-1-1"), 1, 4, 
				BigDecimal.valueOf(3.99), 80, BigDecimal.valueOf(25.99), 
				"PG", "some"));
		when(fds.getAllFilms()).thenReturn(filmList);
		try {
			MockHttpRequest request = MockHttpRequest.get("/film");
			MockHttpResponse response = new MockHttpResponse();
			dispatcher.invoke(request, response);
			assertEquals(200, response.getStatus());
			JSONAssert.assertEquals("[2]", response.getContentAsString(), 
					new ArraySizeComparator(JSONCompareMode.LENIENT));
			JSONAssert.assertEquals("[{title:\"my movie\",description:\"stuff\"},{title:\"big dude\", description:\"funny\"}]", 
					response.getContentAsString(), false);
		} catch (URISyntaxException e) {
			fail();
			e.printStackTrace();
		} catch (JSONException e) {
			fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_getFilmShortPage_filmWebService() {
		List<FilmShort> films = new ArrayList<>();
		films.add(new FilmShort(1l, "mov1", Date.valueOf("2000-1-1"), 120, "G"));
		films.add(new FilmShort(2l, "mov2", Date.valueOf("2010-1-1"), 70, "PG"));
		films.add(new FilmShort(3l, "mov3", Date.valueOf("2015-1-1"), 320, "R"));
		films.add(new FilmShort(4l, "mov4", Date.valueOf("1999-1-1"), 220, "G"));
		when(fds.getPageAll("1", "stuf", "asc")).thenReturn(films);
		try {
			MockHttpRequest req = MockHttpRequest.get("/film/short/stuf/asc/1");
			MockHttpResponse res = new MockHttpResponse();
			dispatcher.invoke(req, res);
			assertEquals(200, res.getStatus());
			JSONAssert.assertEquals("[4]", res.getContentAsString(), 
					new ArraySizeComparator(JSONCompareMode.LENIENT));
			JSONAssert.assertEquals("[{id:1,length:120},{id:2},{id:3},{id:4}]", 
					res.getContentAsString(), false);
		} catch (URISyntaxException e) {
			fail();
			e.printStackTrace();
		} catch (JSONException e) {
			fail();
			e.printStackTrace();
		}
	}
}
