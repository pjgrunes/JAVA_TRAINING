package module2_activity6;

public class MainApplication {

	public static void main(String[] args) {
		Car car = new Car(4, "Toyota");
		car.startEngine();
		car.refuel();
		destroyVehicle(car);
		
		Truck truck = new Truck(8, "Hino");
		truck.startEngine();
		truck.refuel();
		destroyVehicle(truck);
		
	}

	private static void destroyVehicle(Vehicle vehicle) {
        vehicle.destroy();
    }

}


