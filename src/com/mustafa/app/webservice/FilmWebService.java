package com.mustafa.app.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mustafa.app.dataservice.FilmDataService;
import com.mustafa.app.entity.Film;

@Path("/film")
public class FilmWebService {

	private final FilmDataService filmService;
	
	public FilmWebService(FilmDataService filmService) {
		this.filmService = filmService;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Film getFilmById(@PathParam("id") String id) {
		Film film = filmService.getFilmById(id);
		return film;
	}
	
}
