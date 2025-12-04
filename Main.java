package module2_activity3;


public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setBrand("Hyundai");
        car1.setModel("Stargazer");
        car1.displayDetails();
        car1.driving();
        car1.addingFuel();

        Car car2 = new Car("Toyota", "Innova");
        car2.displayDetails();
        car2.driving();
        car2.addingFuel();

    }
}
