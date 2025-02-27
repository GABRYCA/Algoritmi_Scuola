package TestIOTerminale;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestIOTerminale {

	public static void main(String[] args) {
		System.out.println("Leggo un numero da input termianale");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String parolaDiFine = "Basta";
		while (true) {
			String input = null;
			System.out.println("Inserire un numero: ");
			try {
			    input = bufferedReader.readLine();
			} catch (IOException e) {
				System.out.println("Input non valido");
				continue;
			}
			
			if (input != null) {
				if (input.equalsIgnoreCase(parolaDiFine)) break;
				try {
					int numero = Integer.parseInt(input);
					System.out.println("Numero letto: " + numero);
				} catch (NumberFormatException e) {
					System.out.println("Numero non valido!");
				}
			}
		}
		
		System.out.println("Fine programma!");
	}
}
