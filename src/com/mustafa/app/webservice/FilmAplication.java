package com.mustafa.app.webservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/services")
public class FilmAplication extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	
	public FilmAplication() {
        singletons.add(new FilmWebService());
        singletons.add(new MyMessageService());
    }
	
	@Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
