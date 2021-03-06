/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARSW.Persistence;



import ARSW.entities.Cinema;
import ARSW.entities.CinemaFunction;
import java.util.List;

/**
 * @author cristian
 */
public interface CinemaPersitence {

    /**
     * @param row       the row of the seat
     * @param col       the column of the seat
     * @param cinema    the cinema's name
     * @param date      the date of the function
     * @param movieName the name of the movie
     * @throws CinemaException if the seat is occupied,
     *                         or any other low-level persistence error occurs.
     */
    public void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaException;

    /**
     * @param cinema cinema's name
     * @param date   date
     * @return the list of the functions of the cinema in the given date
     */
    public List<CinemaFunction> getFunctionsbyCinemaAndDate(String cinema, String date);

    /**
     * @param cinema new cinema
     * @throws CinemaPersistenceException n if a cinema with the same name already exists
     */
    public void saveCinema(Cinema cinema) throws CinemaPersistenceException;

    /**
     * @param name name of the cinema
     * @return Cinema of the given name
     * @throws CinemaPersistenceException if there is no such cinema
     */
    public Cinema getCinema(String name) throws CinemaPersistenceException;
    
    /**
     * @param cinemaName name of the cinema
     * @param newFunction function to add 
     */
    public void addFunction(String cinemaName, CinemaFunction newFunction);
    /**
     * @param name name of the cinema
     * @param date date(with HH:mm) of the movie
     * @param movieName name of the movie
     * @return CinemaFunction
     * @throws CinemaPersistenceException if there is no such cinema
     */
    public CinemaFunction getExactFunction(String name, String date, String movieName) throws CinemaPersistenceException;
    

}
