package AnalisiTesto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Testo {
	private final File file;
	private String parolaDaCercare = null;
	
	public Testo(File file) {
		this.file = file;
		
		System.out.println("Numero parole: " + numeroParole());
		System.out.println("Numero parole distinte: " + numeroParoleDistinte());
		if (parolaDaCercare != null) System.out.println("Numero occorrenza parola: " + contaOccorrenzeParola(this.parolaDaCercare));
		System.out.println("Parole distinte in ordine alfabetico: " + paroleDistinteInOrdineAlfabetico().toArray());
	}
	
	public void setParolaDaCercare(String parola) {
		this.parolaDaCercare = parola;
	}
	
	public int numeroParole() {
		if (!file.exists()) {
			System.out.println("File non esiste!");
			return 0;
		}
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file));
			String linea;
			int contatore = 0;
			while ((linea = bufferedReader.readLine()) != null) {
				StringTokenizer strk = new StringTokenizer(linea, " .,;:'\"");
				contatore += strk.countTokens();
			}
			bufferedReader.close();
			return contatore;
		} catch (IOException e) {
			System.out.println("Errore durante la lettura!");
			return 0;
		}
	}
	
	public int numeroParoleDistinte() {
		if (!file.exists()) {
			System.out.println("File non esiste!");
			return 0;
		}
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file));
			String linea;
			int contatore = 0;
			LinkedList<String> parole = new LinkedList<String>();
			while ((linea = bufferedReader.readLine()) != null) {
				StringTokenizer strk = new StringTokenizer(linea, " .,;:'\"");
				while (strk.hasMoreTokens()) {
					String parola = strk.nextToken();
					if (!parole.contains(parola)) {
						contatore++;
						parole.add(parola);
					}
				}
			}
			bufferedReader.close();
			return contatore;
		} catch (IOException e) {
			System.out.println("Errore durante la lettura!");
			return 0;
		}
	}
	
	public int contaOccorrenzeParola(String daCercare) {
		if (!file.exists()) {
			System.out.println("File non esiste!");
			return 0;
		}
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file));
			String linea;
			int contatore = 0;
			while ((linea = bufferedReader.readLine()) != null) {
				StringTokenizer strk = new StringTokenizer(linea, " .,;:'\"");
				while (strk.hasMoreTokens()) {
					if (strk.nextToken() == daCercare) contatore++;
				}
			}
			bufferedReader.close();
			return contatore;
		} catch (IOException e) {
			System.out.println("Errore durante la lettura!");
			return 0;
		}
	}
	
	public LinkedList<String> paroleDistinteInOrdineAlfabetico(){
		if (!file.exists()) {
			System.out.println("File non esiste!");
			return null;
		}
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file));
			LinkedList<String> parole = new LinkedList<String>();
			String linea;
			while ((linea = bufferedReader.readLine()) != null) {
				StringTokenizer strk = new StringTokenizer(linea, " .,;:'\"");
				while (strk.hasMoreTokens()) {
					String parola = strk.nextToken();
					if (!parole.contains(parola)) {
						inserisci(parola, parole);
					}
				}
			}
			bufferedReader.close();
			//Collections.sort(parole); // Non serve, usiamo la nostra implementazione inserisci()^
			return parole;
		} catch (IOException e) {
			System.out.println("Errore durante la lettura!");
			return null;
		}
	}
	
	public void inserisci(String parola, LinkedList<String> lista) {
		int posizione = 0;
		while (posizione < lista.size() && (lista.get(posizione).compareTo(parola) < 0)) posizione++;

		lista.add(posizione, parola);
	}
}
