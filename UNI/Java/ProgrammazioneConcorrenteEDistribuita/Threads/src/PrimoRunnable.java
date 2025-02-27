
public class PrimoRunnable implements Runnable {
	private final int id;
	
	public void run() {
		System.out.println("Sono nel run del Runnable di id: " + this.id);
	}
	
	public PrimoRunnable() {
		this.id = 13; // Random number, personal choice
		System.out.println("Creando runnable");
	}
	
	public PrimoRunnable(int id) {
		this.id = id;
	}

}
