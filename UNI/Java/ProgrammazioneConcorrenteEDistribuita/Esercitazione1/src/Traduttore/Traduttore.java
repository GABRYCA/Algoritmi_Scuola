package Traduttore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Traduttore {
	
	private static HashMap<String, String> dizionario = new HashMap<String, String>();
	private static String pathDizionario = "dictionary.txt";

	public static void main(String[] args) {
		if (args.length > 0) pathDizionario = args[0];
		if (!inizializzazione()) return;
		
		String inputUtente = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(inputUtente != "Fine") {
			System.out.println("Inserire parola da tradurre");
			try {
				inputUtente = in.readLine();
			} catch (IOException e) {}
			if (inputUtente == null || inputUtente.split(" ").length != 1) {
				System.out.println("Input non valido!");
			} else if (inputUtente != "Fine"){
				System.out.println("Italiano: " + inputUtente + " Inglese: " + dizionario.get(inputUtente));
			} else {
				System.out.println("Hai deciso di uscire, chiusura in corso...");
			}
		}
		System.out.println("Chiuso con successo!");
	}
	
	/**
	 * Caricamento dizionario
	 * */
	public static boolean inizializzazione() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(pathDizionario));
			String riga;
			while ((riga = bufferedReader.readLine()) != null) {
				String[] pezzi = riga.split(" ");
				dizionario.put(pezzi[0], pezzi[1]);
			}
			bufferedReader.close();
			return true;
		} catch (IOException e) {
			System.out.println("Errore durante l'inizializzazione del dizionario!");
			return false;
		}
	}

}
