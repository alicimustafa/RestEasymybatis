package com.mustafa.app.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mustafa.app.dataservice.FilmDataService;
import com.mustafa.app.dto.JsonResponse;
import com.mustafa.app.dto.ReturnPage;
import com.mustafa.app.entity.Film;

@Path("/film")
@Produces(MediaType.APPLICATION_JSON)
public class FilmWebService {

	private final FilmDataService filmService;
	
	public FilmWebService(FilmDataService filmService) {
		this.filmService = filmService;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON) 
    @Consumes(MediaType.APPLICATION_JSON)
	public JsonResponse getFilmById(@PathParam("id") String id) {
		Film film = filmService.getFilmById(id);
		JsonResponse json = new JsonResponse();
		if(film == null) {
			json.setErrors("there was a problem");
		} else {
			json.setData(film);
		}
		return json;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
    @Consumes(MediaType.APPLICATION_JSON)
	public  JsonResponse getAllFilms(){
		List<Film> films = filmService.getAllFilms();
		JsonResponse json = new JsonResponse();
		if(films == null) {
			json.setErrors("there was a problem");
		} else {
			json.setData(films);
		}
		return json;
	}
	
	@GET
	@Path("/short/{order}/{dir}/{page}")
	@Produces(MediaType.APPLICATION_JSON) 
    @Consumes(MediaType.APPLICATION_JSON)
	public JsonResponse getFilmShortPage(
			@PathParam("dir") String dir,
			@PathParam("page") String page,
			@PathParam("order") String order){
		JsonResponse json = new JsonResponse();
		ReturnPage returnPage = filmService.getPageAll(page, order, dir);
		if(returnPage == null) {
			json.setErrors("There was problem");
		} else {
			json.setData(returnPage);
		}
		return json;
	}
	
}
