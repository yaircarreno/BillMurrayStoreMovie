package com.billmurray.beans;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPerson {
	
	private String page;
	private List<Actor> results = new ArrayList<Actor>();
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public List<Actor> getResults() {
		return results;
	}
	public void setResults(List<Actor> results) {
		this.results = results;
	}

}
