package CopiaFileArgs; // Rimuovere e compilare javac CopiaFileArgs per semplicità, evita errore classe main

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiaFileArgs {

	public static void main(String[] args) throws IOException {
		System.out.println("Avvio programma...");
		if (args.length != 2) {
			System.out.println("Parametri mancanti! Inserire <nome file origine> e <destinazione>");
			return;
		}
		
		System.out.println("Copia da " + args[0] + " a " + args[1]);
		
		FileReader in = new FileReader(args[0]);
		FileWriter out = new FileWriter(args[1]);
		int input;
		int caratteri = 0;
		while ((input = in.read()) != -1) {
			out.write(input);
			caratteri++;
		}
		
		System.out.println("Finita copia. Numero caratteri copiati: " + caratteri);
		in.close();
		out.flush();
		out.close();
	}
}
