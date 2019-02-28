/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence.impl;



import Persistence.CinemaException;
import Persistence.CinemaPersistenceException;
import Persistence.CinemaPersitence;
import entities.Cinema;
import entities.CinemaFunction;
import entities.Movie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import services.CinemaServices;

/**
 *
 * @author cristian
 */

@Service("Bean1")
public class InMemoryCinemaPersistence implements CinemaPersitence{
	
    public CinemaServices cs;
    private final Map<String,Cinema> cinemas=new HashMap<>();

    public InMemoryCinemaPersistence() {
        //load stub data
    	cs = new CinemaServices();
        String functionDate = "2018-12-18 15:30";
        List<CinemaFunction> functions= new ArrayList<>();
        CinemaFunction funct1 = new CinemaFunction(new Movie("SuperHeroes Movie","Action"),functionDate);
        CinemaFunction funct2 = new CinemaFunction(new Movie("The Night","Horror"),functionDate);
        functions.add(funct1);
        functions.add(funct2);
        Cinema c=new Cinema("cinemaX",functions);
        Cinema c2=new Cinema("cinemaY",functions);
        cinemas.put("cinemaX", c);
        cinemas.put("CinemaY", c2);
    }    

    @Override
    public void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaException {
		try {
			for(CinemaFunction cf : this.getCinema(cinema).getFunctions()) {
				if(cf.getMovie().equals(movieName) && cf.getDate().equals(date)) {
					cf.buyTicket(row, col);
					break;
				}
			}
		} catch (CinemaPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @Override
    public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date) {
        //return cs.getFunctionsbyCinemaAndDate(cinema, date);
    	List<CinemaFunction> funcionesTotales = null;
		try {
			funcionesTotales = getCinema(cinema).getFunctions();
		} catch (CinemaPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<CinemaFunction> escogidos = new ArrayList();
		for (CinemaFunction cf : funcionesTotales) {
			if (cf.getDate().equals(date))
				escogidos.add(cf);

		}
		return escogidos;
        
    }

    @Override
    public void saveCinema(Cinema c) throws CinemaPersistenceException {
        if (cinemas.containsKey(c.getName())){
            throw new CinemaPersistenceException("The given cinema already exists: "+c.getName());
        }
        else{
            cinemas.put(c.getName(),c);
        }   
    }

    @Override
    public Cinema getCinema(String name) throws CinemaPersistenceException {
        return cinemas.get(name);
    }

}
