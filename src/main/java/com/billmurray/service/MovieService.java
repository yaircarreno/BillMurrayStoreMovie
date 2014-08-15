package com.billmurray.service;

import java.util.List;

import com.billmurray.beans.Actor;
import com.billmurray.beans.Movie;
import com.billmurray.beans.Person;

public interface MovieService {
	
	public void getCastMovie();
	
	public List<Actor> searchPerson(String name);
	
	public List<Movie> searchMovies(Person p);

}
