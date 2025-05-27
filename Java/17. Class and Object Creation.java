class Car {
    String make, model;
    int year;
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    void displayDetails() {
        System.out.println(year + " " + make + " " + model);
    }
}
public class CarDemo {
    public static void main(String[] args) {
        Car c1 = new Car("Toyota", "Corolla", 2022);
        c1.displayDetails();
    }
}
