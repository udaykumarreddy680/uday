package com.jspiders.hibernate.tester;

import java.util.ArrayList;
import java.util.List;

import com.jspiders.hibernate.dao.ActorDAO;
import com.jspiders.hibernate.dao.MovieDAO;
import com.jspiders.hibernate.dto.ActorDTO;
import com.jspiders.hibernate.dto.MovieDTO;

public class AppTester {

/*	public static void main(String[] args) {
		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setMovieName("ABCD");
		movieDTO.setType("Dance");
		
		
		ActorDTO actorDTO1 = new ActorDTO();
		actorDTO1.setActorName("PrabhuDeva");
		actorDTO1.setAge(45);
		
		ActorDTO actorDTO2 = new ActorDTO();
		actorDTO2.setActorName("Varun");
		actorDTO2.setAge(27);
		
		List<ActorDTO> actorList = new ArrayList<ActorDTO>();
		actorList.add(actorDTO1);
		actorList.add(actorDTO2);
		
		List<MovieDTO> movieList = new ArrayList<MovieDTO>();
		movieList.add(movieDTO);
		
		
		actorDTO1.setMovie(movieList);
		actorDTO2.setMovie(movieList);
		movieDTO.setActor(actorList);
		
		MovieDAO movieDAO = new MovieDAO();
		movieDAO.save(movieDTO);
	}*/
	
	public static void main(String[] args) {
		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setMovieName("Juduva");
		movieDTO.setType("Comedy");
		
		ActorDAO actorDAO = new ActorDAO();
		ActorDTO actorDTO = actorDAO.getActorByName("Varun");
		
		
		List<ActorDTO> listOfActors = new ArrayList<ActorDTO>();
		listOfActors.add(actorDTO);
		
		List<MovieDTO> listOfMovies = actorDTO.getMovie();
		listOfMovies.add(movieDTO);
				
		movieDTO.setActor(listOfActors);
		actorDTO.setMovie(listOfMovies);
		
		MovieDAO movieDAO = new MovieDAO();
		movieDAO.save(movieDTO);
		System.out.println("hello");
	}

}
