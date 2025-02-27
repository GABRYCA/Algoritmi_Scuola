
public class MainThread {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Avviato Main");
		PrimoThread t1 = new PrimoThread();
		Thread t2 = new Thread(new PrimoRunnable(17)); // Runnable
		t1.setName("Primo Thread");
		t2.setName("Inutile ma lo setto comunque");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	
		System.out.println("Terminazione Programma");
	}
}
