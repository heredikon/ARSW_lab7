package filter;

import java.util.*;

import entities.Cinema;
import entities.Movie;
import Persistence.CinemaPersitence;

public interface FilterFilm {
	public List<Movie> filtreType(String cine,String date,String data,CinemaPersitence cps);
}
