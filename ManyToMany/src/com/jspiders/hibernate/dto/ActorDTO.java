package com.jspiders.hibernate.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "actor_table")
public class ActorDTO implements Serializable {
	@Id
	@GenericGenerator(name = "jsp", strategy = "increment")
	@GeneratedValue(generator = "jsp")
	@Column(name = "actor_id")
	private int actorId;
	@Column(name = "actor_name")
	private String actorName;
	@Column(name = "actor_age")
	private double age;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "movie_actor", 
				joinColumns = {@JoinColumn(name = "a_id")},
				inverseJoinColumns = {@JoinColumn(name = "m_id")})
	private List<MovieDTO> movie;

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public List<MovieDTO> getMovie() {
		return movie;
	}

	public void setMovie(List<MovieDTO> movie) {
		this.movie = movie;
	}

}
