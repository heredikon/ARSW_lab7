/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Cinema;
import entities.CinemaFunction;
import entities.Movie;
import Persistence.CinemaException;
import Persistence.CinemaPersistenceException;
import Persistence.CinemaPersitence;
import filter.FilterFilm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author cristian
 */
@Service("BeanServices")
public class CinemaServices {

	@Autowired
	@Qualifier("Bean1")
	public CinemaPersitence cps =null;
	
	@Autowired
	@Qualifier("Bean3")
	public FilterFilm  filtro;
	public CinemaFunction cf;
	public Cinema cine;

	public void addNewCinema(Cinema c) {
		try {
			cps.saveCinema(c);
		} catch (CinemaPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getAllCinemas() {
		return "probando shys";
	}

	/**
	 * @param name cinema's name
	 * @return the cinema of the given name created by the given author
	 * @throws CinemaException
	 */
	public Cinema getCinemaByName(String name) throws CinemaException {

		try {
			return this.cps.getCinema(name);
		} catch (CinemaPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cine;
	}

	public  List<Movie> showFilter(String cine, String date,String filtroes) {
		
		if(filtro.getClass().getName().equals("Filteredbygender")) {
			return filtro.filtreType(cine, date, filtroes,cps);
			
		}
		else {
			return filtro.filtreType(cine, date, filtroes,cps);
		}
		
		
	}
	public void buyTicket(int row, int col, String cinema, String date, String movieName)
			 {
		try {
			cps.buyTicket(row, col, cinema, date, movieName);
		} catch (CinemaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date) {
		return cps.getFunctionsbyCinemaAndDate(cinema, date);
	}

	public CinemaPersitence getCps() {
		return cps;
	}

	public void setCps(CinemaPersitence cps) {
		this.cps = cps;
	}

}
