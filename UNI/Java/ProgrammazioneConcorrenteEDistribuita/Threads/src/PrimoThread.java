public class PrimoThread extends Thread {
	public void run() {
		System.out.println("Ciao, sono il Primo Thread " + getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Sono stato in sleep per 1 secondo");
	}
	
	public PrimoThread() {
		System.out.println("Creazione Primo Thread");
	}
	
	public PrimoThread(String name) {
		super(name);
		System.out.println("Creazione thread: " + getName());
	}
}
