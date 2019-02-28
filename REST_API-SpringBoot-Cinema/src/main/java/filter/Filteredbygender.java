package filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import entities.Cinema;
import entities.CinemaFunction;
import entities.Movie;
import Persistence.CinemaPersistenceException;
import Persistence.CinemaPersitence;

@Service("Bean3")
public class Filteredbygender implements FilterFilm {
	public CinemaPersitence cps = null;

	@Override
	public List<Movie> filtreType(String cine, String date, String data,CinemaPersitence cps) {
		this.cps=cps;
		List<Movie> movies = new ArrayList();
		try {
			Cinema cineD = cps.getCinema(cine);
			List<CinemaFunction> functions = cineD.getFunctions();
			for (CinemaFunction cf : functions) {
				if (cf.getDate().equals(date) && cf.getMovie().getGenre().equals(data))
					movies.add(cf.getMovie());
			}
		} catch (CinemaPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;

	}

	public CinemaPersitence getCps() {
		return cps;
	}

	public void setCps(CinemaPersitence cps) {
		this.cps = cps;
	}

}
