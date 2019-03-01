package ARSW.filter;

import java.util.*;

import ARSW.entities.Cinema;
import ARSW.entities.Movie;
import ARSW.Persistence.CinemaPersitence;

public interface FilterFilm {
	public List<Movie> filtreType(String cine,String date,String data,CinemaPersitence cps);
}
