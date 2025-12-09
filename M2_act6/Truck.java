package module2_activity6;

public class Truck extends Vehicle implements Refuelable {
	public Truck(int numberOfWheels, String brand) {
		super(8, brand);
	}
	
	public void startEngine() {
		System.out.println(getBrand() + " truck engine started.");
	}
	
	public void refuel() {
		System.out.println("Refueling truck " + getBrand());
		
	}
}
