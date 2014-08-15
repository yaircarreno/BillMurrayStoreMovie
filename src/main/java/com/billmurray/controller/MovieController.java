package com.billmurray.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.billmurray.beans.Actor;
import com.billmurray.service.MovieService;


@Controller
@RequestMapping("/movies")
public class MovieController {
	
	
	@Autowired
    private MovieService movieService;
	
	
	@RequestMapping("/cast")
    public String getCastMovie() {
		
		movieService.getCastMovie();
		return "movies/layout";
    }
	
	@RequestMapping("/search/{name}")
	public @ResponseBody List<Actor> searchPerson(@PathVariable("name") String name) {
		List<Actor> actores = movieService.searchPerson(name);
		return actores;
    }
	
	@RequestMapping("/documentation")
    public String getDocumentation() {
		
		return "movies/layout";
    }
	
	@RequestMapping("/layout")
    public String getMoviePartialPage() {
        return "movies/layout";
    }

}
