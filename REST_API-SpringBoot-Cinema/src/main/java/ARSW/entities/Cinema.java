/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARSW.entities;

import ARSW.entities.CinemaFunction;
import java.util.List;

import org.springframework.stereotype.Service;


/**
 * @author cristian
 */

public class Cinema {
    private String name;
    private List<CinemaFunction> functions;


    public Cinema() {
    }

    public Cinema(String name, List<CinemaFunction> functions) {
        this.name = name;
        this.functions = functions;
    }

    public Cinema(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addFunction(CinemaFunction cf){
        this.functions.add(cf);
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CinemaFunction> getFunctions() {
        return this.functions;
    }

    public void setSchedule(List<CinemaFunction> functions) {
        this.functions = functions;
    }
}
