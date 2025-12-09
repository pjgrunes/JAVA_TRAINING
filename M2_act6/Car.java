package module2_activity6;

public class Car extends Vehicle implements Refuelable {
	
	public Car(int numberOfWheels, String brand) {
		super(4, brand);
	}
	
	public void startEngine() {
		System.out.println(getBrand() + " engine started.");
	}
	
	public void refuel() {
		System.out.println("Refueling "+ getBrand());
		
	}

}
