package com.mustafa.app.webservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.mustafa.app.dao.FilmDaoImpl;
import com.mustafa.app.dataservice.FilmDataService;

@ApplicationPath("/services")
public class FilmAplication extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	
	public FilmAplication() {
        singletons.add(new FilmWebService(
        		new FilmDataService(
        		FilmDaoImpl.getInstance())));
        singletons.add(new MyMessageService());
    }
	
	@Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
