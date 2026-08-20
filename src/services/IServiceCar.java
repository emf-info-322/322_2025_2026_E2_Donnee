package services;

import java.util.ArrayList;

import models.Car;

/**
 * Cette interface définit les services "métier" de l'application.
 *
 * @author ...
 */
public interface IServiceCar {

    public ArrayList<String> getMarques();
    
    public ArrayList<Car> filtrerCar(String brand);
     
}