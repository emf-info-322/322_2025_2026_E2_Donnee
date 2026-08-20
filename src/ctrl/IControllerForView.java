package ctrl;

import java.util.List;

import models.Car;

public interface IControllerForView {

   List<String> getMarques();

   List<Car> filtrerCar(String brand);
}
