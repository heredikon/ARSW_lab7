/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARSW.cinema.controllers;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import ARSW.entities.Cinema;
import ARSW.entities.CinemaFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ARSW.persistence.impl.InMemoryCinemaPersistence;
import ARSW.services.CinemaServices;

/**
 *
 * @author cristian
 */
@RestController
public class CinemaAPIController {

    @Autowired
    public InMemoryCinemaPersistence imcp;

    @GetMapping("/cinemas")
    public ResponseEntity<?> controllerGetcinemas() {
        try {
            Map<String, Cinema> cinemas = imcp.getCinemas();
            if (cinemas.isEmpty()) {
                return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(cinemas, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("ERROR 404 NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("cinemas/{name}")
    public ResponseEntity<?> controllerGetName(@PathVariable("name") String name) {
        try {
            Map<String, Cinema> cinemas = imcp.getCinemas();
            if (cinemas.get(name) == null) {
                return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(cinemas.get(name), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("ERROR 404 NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("cinemas/{name}/{date}")
    public ResponseEntity<?> controllerGetNameAndDate(@PathVariable("name") String name, @PathVariable("date") String date) {
        try {
            Map<String, Cinema> cinemas = imcp.getCinemas();
            if (cinemas.get(name) == null) {
                return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(imcp.getFunctionsbyCinemaAndDate(name, date), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("ERROR 404 NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("cinemas/{name}/{date}/{moviename}")

    public ResponseEntity<?> controllerGetExactFunction(@PathVariable("name") String name, @PathVariable("date") String date, @PathVariable("moviename") String moviename) {
        try {
            //Map<String, Cinema> cinemas = imcp.getCinemas();
            if (imcp.getExactFunction(name, date, moviename) == null) {
                return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(imcp.getExactFunction(name, date, moviename), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("ERROR 404 NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST,value ="/cinemas/{name}")
    public ResponseEntity<?> manejadorPostRecursoXX(@RequestBody CinemaFunction o,
            @PathVariable String name){
        try{
            imcp.addFunction(name, o);
            return new ResponseEntity<>("CREATED",HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>("HTTP UNSUCCESFUL",HttpStatus.FORBIDDEN);
        }
        
        
    }
    
    

}
