package services;

import java.util.ArrayList;

import models.Car;

/**
 * Implémentation de la couche "métier" de l'application.
 *
 * @author ...
 */
public class ServiceCar implements IServiceCar {

  public static String LANDROVER = "LAND ROVER";
  public static String ASTONMARTIN = "ASTON MARTIN";
  public static String DODGE = "DODGE";
  public static String GMC = "GMC";
  public static String BUGATTI = "BUGATTI";
  public static String MERCEDESBENZ = "MERCEDES-BENZ";
  public static String MASERATI = "MASERATI";
  public static String FIAT = "FIAT";
  public static String PORSCHE = "PORSCHE";
  public static String AUDI = "AUDI";

  public static String Automatique = "Automatique";
  public static String Manuelle = "Manuelle";

  public static String Essence = "Essence";
  public static String Electrique = "Electrique";
  public static String Hybride = "Hybride";

  private ArrayList<Car> cars;

  public ServiceCar() {
    cars = new ArrayList<>();
    creerCar();
  }

  @Override
  public ArrayList<String> getMarques() {
    ArrayList<String> brands = new ArrayList<>();
    brands.add("Toutes les marques");
    brands.add(ASTONMARTIN);
    brands.add(AUDI);
    brands.add(BUGATTI);
    brands.add(DODGE);
    brands.add(FIAT);
    brands.add(GMC);
    brands.add(LANDROVER);
    brands.add(MASERATI);
    brands.add(MERCEDESBENZ);
    brands.add(PORSCHE);
    return brands;
  }


  @Override
  public ArrayList<Car> filtrerCar(String brand) {
    ArrayList<Car> carsFiltre = new ArrayList<>();
  

    for (Car car : this.cars) {
      if (car.getBrand().equals(brand) || brand.equals("Toutes les marques")) {
        carsFiltre.add(car);
      }
    }
    return carsFiltre;
  }

  private void creerCar() {
    cars.add(new Car(LANDROVER,
        "Defender 5.0 V8 Carpathian Edition",
        Automatique,
        Essence,
        "resources/images/LAND ROVER Defender.jpg",
        800,
        525,
        5));

    cars.add(new Car(ASTONMARTIN,
        "DBS Superleggera Volante",
        Automatique,
        Essence,
        "resources/images/ASTON MARTIN DBS.jpg",
        1000,
        725,
        2));

    cars.add(new Car(ASTONMARTIN,
        "DB2/4",
        Manuelle,
        Essence,
        "resources/images/ASTON MARTIN DB24.jpg",
        950,
        140,
        4));

    cars.add(new Car(ASTONMARTIN,
        "Vanquish V12 5.9-48 Touchtronic 2",
        Automatique,
        Essence,
        "resources/images/ASTON MARTIN Vanquish.jpg",
        1200,
        574,
        2));

    cars.add(new Car(BUGATTI,
        "CHIRON",
        Automatique,
        Essence,
        "resources/images/BUGATTI CHIRON.jpg",
        2000,
        1500,
        2));

    cars.add(new Car(DODGE,
        "DODGE VIPER ACR",
        Manuelle,
        Essence,
        "resources/images/DODGE VIPER ACR.jpg",
        1300,
        612,
        2));

    cars.add(new Car(DODGE,
        "Ram 1500",
        Automatique,
        Essence,
        "resources/images/DODGE Ram 1500 TRX.jpg",
        750,
        711,
        5));

    cars.add(new Car(DODGE,
        "Durango 6.2 Supercharger AWD",
        Automatique,
        Essence,
        "resources/images/DODGE Durango 6.2.jpg",
        700,
        719,
        6));

    cars.add(new Car(GMC,
        "GMC Sierra Denali 1500",
        Automatique,
        Essence,
        "resources/images/GMC Sierra Denali 1500.jpg",
        600,
        426,
        5));

    cars.add(new Car(MERCEDESBENZ,
        "G 63 AMG Speedshift Plus G-Tronic",
        Automatique,
        Essence,
        "resources/images/MERCEDES-BENZ G 63 AMG.jpg",
        800,
        585,
        5));

    cars.add(new Car(FIAT,
        "Multipla 1.6 16V ELX Bipower",
        Manuelle,
        Essence,
        "resources/images/FIAT Multipla.jpg",
        20,
        103,
        6));

    cars.add(new Car(PORSCHE,
        "Taycan GTS",
        Automatique,
        Electrique,
        "resources/images/PORSCHE Taycan.jpg",
        700,
        517,
        4));
    cars.add(new Car(AUDI,
        "e-tron GT quattro",
        Automatique,
        Electrique,
        "resources/images/AUDI quattro.jpg",
        700,
        476,
        5));

    cars.add(new Car(MERCEDESBENZ,
        " AMG GT 4 63 S 4Matic+ E",
        Automatique,
        Hybride,
        "resources/images/MERCEDES-BENZ AMG GT 4.jpg",
        1000,
        850,
        4));

  }
}
