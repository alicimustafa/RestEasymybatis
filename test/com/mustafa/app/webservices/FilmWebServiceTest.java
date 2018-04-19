package com.mustafa.app.webservices;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.sql.Date;

import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.jayway.jsonassert.JsonAssert;
import com.mustafa.app.dataservice.FilmDataService;
import com.mustafa.app.entity.Film;
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
	public void test_film_id_path_film_web_service() {
		Film film = new Film(1L, 
				"my movie", "stuff", Date.valueOf("2000-1-1"), 3, 4, 
				BigDecimal.valueOf(1.99), 120, BigDecimal.valueOf(15.99), 
				"R", "none");
		when(fds.getFilmById("1")).thenReturn(film);
		try {
			MockHttpRequest request = MockHttpRequest.get("/film/1");
			MockHttpResponse response = new MockHttpResponse();
			dispatcher.invoke(request, response);
			assertEquals(200, response.getStatus());
			JsonAssert.with(response.getContentAsString())
				.assertEquals("$", hasSize(1));
//				.assertThat("$", hasSize(1));
		
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
