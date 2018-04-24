package com.mustafa.app.webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mustafa.app.dataservice.FilmDataService;
import com.mustafa.app.entity.Film;
import com.mustafa.app.entity.FilmShort;

@Path("/film")
@Produces(MediaType.APPLICATION_JSON)
public class FilmWebService {

	private final FilmDataService filmService;
	
	public FilmWebService(FilmDataService filmService) {
		this.filmService = filmService;
	}
	
	@GET
	@Path("/{id}")
	public Film getFilmById(@PathParam("id") String id) {
		Film film = filmService.getFilmById(id);
		return film;
	}
	
	@GET
	public List<Film> getAllFilms(){
		return filmService.getAllFilms();
	}
	
	@GET
	@Path("/short/{order}/{dir}/{page}")
	public List<FilmShort> getFilmShortPage(
			@PathParam("dir") String dir,
			@PathParam("page") String page,
			@PathParam("order") String order){
		return filmService.getPageAll(page, order, dir);
	}
	
}
