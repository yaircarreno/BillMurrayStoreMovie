package com.billmurray.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Movie implements Comparator<Movie>{
	
	    private String adult;
	    private String character;
	    private String credit_id;
	    private String id;
	    private String original_title;
	    private String poster_path;
	    private String release_date;
	    private String title;
	    
		public String getAdult() {
			return adult;
		}
		public void setAdult(String adult) {
			this.adult = adult;
		}
		public String getCharacter() {
			return character;
		}
		public void setCharacter(String character) {
			this.character = character;
		}
		public String getCredit_id() {
			return credit_id;
		}
		public void setCredit_id(String credit_id) {
			this.credit_id = credit_id;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getOriginal_title() {
			return original_title;
		}
		public void setOriginal_title(String original_title) {
			this.original_title = original_title;
		}
		public String getPoster_path() {
			return poster_path;
		}
		public void setPoster_path(String poster_path) {
			this.poster_path = poster_path;
		}
		public String getRelease_date() {
			return release_date;
		}
		public void setRelease_date(String release_date) {
			this.release_date = release_date;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		
		@Override
		public int compare(Movie o1, Movie o2) {
			
			if (o1.getRelease_date() == null || o2.getRelease_date() == null) {
				
				return 1;
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1;
			Date date2;
			
			try {
				
				date1 = sdf.parse(o1.getRelease_date());
				date2 = sdf.parse(o2.getRelease_date());
				
				if (date2.after(date1)) return -1;
				if (date1 == date2) return 0;
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return 1;
		}
}
