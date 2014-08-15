package com.billmurray.beans;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cast {
	
	private String id;
	private List<Movie> cast;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Movie> getCast() {
		return cast;
	}
	public void setCast(List<Movie> cast) {
		this.cast = cast;
	}
}
