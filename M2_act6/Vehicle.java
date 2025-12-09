package module2_activity6;

public abstract class Vehicle {
	private int numberOfWheels;
	private String brand;
	
	public Vehicle(int numberOfWheels, String brand) {
		this.numberOfWheels = numberOfWheels;
        this.brand = brand;
	}
	
	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public abstract void startEngine();
	
	public void destroy() {
		System.out.println("Destroying Vehicle: " + brand);
		System.out.println("Wheels: "+ numberOfWheels);
		System.out.println("Vehicle Destroyed");
		System.out.println();
	}
	
	
	
	
}
