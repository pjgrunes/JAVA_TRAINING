package module2_activity5;

public abstract class Program {
	private String name;
	private boolean isRunning = false;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	
	public Program() {
		
	}
	
	public Program(String name) {
		this.name = name;
	}
	
	abstract void run();
	abstract void stop();
   
	
	
}


	
	
	


