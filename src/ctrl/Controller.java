package ctrl;

import views.View;

import java.util.ArrayList;

import models.Car;
import services.ServiceCar;
import views.IViewForController;


public class Controller implements IControllerForView {

    private final IViewForController view;
    private ServiceCar serviceCar;

    public Controller() {
        view = new View(this);
        serviceCar = new ServiceCar();
    }

    public void start() {
        view.start();
    }

    @Override
    public ArrayList<String> getMarques() {
        return serviceCar.getMarques();
    }

    @Override
    public ArrayList<Car> filtrerCar(String brand) {
        return serviceCar.filtrerCar(brand);
    }
}
