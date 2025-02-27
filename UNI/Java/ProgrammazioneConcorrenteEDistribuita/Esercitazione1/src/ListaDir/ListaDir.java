package ListaDir;

import java.io.File;

public class ListaDir {

	public static void main(String[] args) {
		if (args.length == 1) {
			File file = new File(args[0]);
			if (!file.exists()) {
				System.out.println("Il file non esiste");
				return;
			}
			if (file.isFile()) {
				System.out.println("Percorso assoluto: " + file.getAbsolutePath());
				System.out.println("Dimensioni (byte): " + file.length());
				return;
			} else {
				stampaDirectory(file);
			}
		} else {
			File file = new File(".");
			System.out.println("Percorso cartella: " + file.getAbsolutePath());
			stampaDirectory(file);
		}
	}
	
	public static void stampaDirectory(File file) {
		String[] lista = file.list();
		for (String item : lista) {
			System.out.println(item);
		}
	}

}
