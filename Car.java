package module2_activity3;

public class Car {
    private String brand;
    private String model;

    public Car() {
        this.brand = "";
        this.model = "";
    }

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Brand:   " + brand);
        System.out.println("Model:   " + model);
    }

    public void driving() {
        System.out.println(brand + " " + model + "'s is currently driving");
    }

    public void addingFuel() {
        System.out.println(brand + " " + model + "'s is adding fuel");
        System.out.println();
    }
    
    public String getBrand() { 
    	
    	return brand; 
    	
    }
    public void setBrand(String brand) {
    	
    	this.brand = brand; 
    	
    }

    public String getModel() { 
    	
    	return model; 
    	
    }
    
    public void setModel(String model) { 
    	
    	this.model = model; 
    	
    }
}

