/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ARSW.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author cristian
 */
@SpringBootApplication
@ComponentScan(basePackages = {"ARSW"})
public class CinemaAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaAPIApplication.class, args);
    }
}
