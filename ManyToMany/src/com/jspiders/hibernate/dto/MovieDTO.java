package com.jspiders.hibernate.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "movie_table")
public class MovieDTO implements Serializable {
	@Id
	@GenericGenerator(name = "jsp", strategy = "increment")
	@GeneratedValue(generator = "jsp")
	@Column(name = "movie_id")
	private int movieId;
	@Column(name = "movie_name")
	private String movieName;
	@Column(name = "movie_type")
	private String type;
	
	@ManyToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ActorDTO> actor;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ActorDTO> getActor() {
		return actor;
	}

	public void setActor(List<ActorDTO> actor) {
		this.actor = actor;
	}

}
