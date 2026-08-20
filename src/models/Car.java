package models;

/**
 * Bean "Car".
 * 
 *  @author BUD
 */
public class Car {
   private String brand;
   private String name;
   private String gearbox;
   private String fuel;
   private String picture;
   private int price;
   private int power; //exprimée en PS
   private int seat;
  

   public Car(String brand, String name, String gearbox, String fuel, String picture, int price, int power, int seat) {
      this.brand = brand;
      this.name = name;
      this.gearbox = gearbox;
      this.fuel = fuel;               
      this.picture = picture;
      this.price = price;
      this.power = power;
      this.seat = seat;
   }

   public String getBrand() {
      return brand;
   }

   public String getName() {
      return name;
   }


   public String getGearbox() {
      return gearbox;
   }


   public String getFuel() {
      return fuel;
   }

   public String getPicture() {
      return picture;
   }

   public int getPrice() {
      return price;
   }


   public int getPower() {
      return power;
   }


   public int getSeat() {
      return seat;
   }

   @Override  
   public String toString(){
     return brand + " " + name +"\n" + "\n";
   }
}
