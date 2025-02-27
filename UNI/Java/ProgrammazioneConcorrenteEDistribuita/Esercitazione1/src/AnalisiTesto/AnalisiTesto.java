package AnalisiTesto;

import java.io.File;

public class AnalisiTesto {
	public static String pathInput = "infinito.txt";

	public static void main(String[] args) {
		if (args.length > 0) pathInput = args[0];
		Testo testo = new Testo(new File(pathInput));
	}

}
