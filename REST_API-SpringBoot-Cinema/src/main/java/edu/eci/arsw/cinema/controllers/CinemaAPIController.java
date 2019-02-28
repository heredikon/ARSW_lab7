/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.controllers;

import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import persistence.impl.InMemoryCinemaPersistence;
import services.CinemaServices;

/**
 *
 * @author cristian
 */
@RestController
@RequestMapping(value = "/cinema")
public class CinemaAPIController {

    public InMemoryCinemaPersistence imcp;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> manejadorGetRecursoXX() {
//        try {
        //obtener datos que se enviarán a través del API
        return new ResponseEntity<>(imcp.cs.getAllCinemas(), HttpStatus.ACCEPTED);
//        } catch (ResourceNotFoundException ex) {
//            Logger.getLogger(XXController.class.getName()).log(Level.SEVERE, null, ex);
//            return new ResponseEntity<>("Error bla bla bla", HttpStatus.NOT_FOUND);
//        }
    }
}
