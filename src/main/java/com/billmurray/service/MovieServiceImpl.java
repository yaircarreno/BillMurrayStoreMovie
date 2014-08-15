package com.billmurray.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.billmurray.beans.Actor;
import com.billmurray.beans.Cast;
import com.billmurray.beans.Movie;
import com.billmurray.beans.Person;
import com.billmurray.beans.SearchPerson;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	
	private String path = "https://api.themoviedb.org/3";
	private String apiKey = "73d93a8edf384634a2c561159294fcf0";
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public void getCastMovie() {

	}

	@Override
	public List<Actor> searchPerson(String name) {

		restTemplate = new RestTemplate();
		List<Actor> actorList = new ArrayList<Actor>();
		
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("name", name);
		vars.put("api-key", apiKey);
		SearchPerson searchPerson = restTemplate.getForObject(path + "/search/person?api_key={api-key}&query={name}", SearchPerson.class, vars);
		
		for(Actor a : searchPerson.getResults()){
			
			if ((a != null) && (a.getId() != "null") && (a.getProfile_path() != null) ){
				
				a = getDeatailPerson(a);
				List<Movie> movieList = searchMovies(a);
				orderDateMovie(movieList);
				a.setMovies(movieList);
				actorList.add(a);
			}
		}
		
		return actorList;
	}

	@Override
	public List<Movie> searchMovies(Person p) {
		
		restTemplate = new RestTemplate();
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("id", p.getId());
		vars.put("api-key", apiKey);
		Cast cast = restTemplate.getForObject(path + "/person/{id}/movie_credits?api_key={api-key}", Cast.class, vars);
		List<Movie> movieList = cast.getCast();
		
		return movieList;
	}
	
	private Actor getDeatailPerson(Actor p){
		
		restTemplate = new RestTemplate();
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("id", p.getId());
		vars.put("api-key", apiKey);
		p = restTemplate.getForObject(path + "/person/{id}?api_key={api-key}", Actor.class, vars);
		
		return p;
	}
	
	
	private void orderDateMovie(List<Movie> movieList){
		
		List<Movie> borrar = new ArrayList<Movie>();
		
		for (Movie m : movieList){
			
			if (m.getRelease_date() == null){
				borrar.add(m);
			}
		}
		movieList.removeAll(borrar);

		Comparator<Movie> comparator = new Movie();
		Collections.sort(movieList, comparator);
	}
}
