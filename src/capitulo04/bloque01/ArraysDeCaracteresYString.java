package capitulo04.bloque01;

import Utils.Arrays;

public class ArraysDeCaracteresYString {

	public static void main(String[] args) {

		String string1 = Arrays.requestString("Escribe unas palabras");
//		String string2 = Arrays.requestString("Escribe mas palabras");

//		invertir(string1);

		System.out.print(mostrarConsonantesVocales(string1));

//		esPalindromo(string1);
//		ifBoolean(string1);

//		System.out.print(numeroPalabras(string1));

//		compararCadenas(string1, string2);
//		systemOutComparar(string1, string2);

//		System.out.println(textoMeniscula(string1));
	}

	private static void ifBoolean(String string1) {
		if (esPalindromo(string1)) {
			System.out.println("\nEs un palindromo");
		} else {
			System.out.println("\nNo es un palindromo");
		}
		;
	}

	/*
	 * 
	 */
	private static void systemOutComparar(String string1, String string2) {
		if (compararCadenas(string1, string2) == 1) {
			System.out.println("string 1 es mas grande que string 2");
		}
		;
		if (compararCadenas(string1, string2) == -1) {
			System.out.println("string 1 es menos grande que string 2");
		}
		;
		if (compararCadenas(string1, string2) == 0) {
			System.out.println("las dos cadenas son iguales");
		}
		;
	}

	/*
	 * 
	 */
	public static void invertir(String string1) {
		for (int i = string1.length() - 1; i >= 0; i--) {
			System.out.print(string1.charAt(i));
		}
	}

	/*
	 * 
	 */
	public static String mostrarConsonantesVocales(String string1) {
		int consonantes = 0;
		int vocales = 0;
		for (int i = string1.length() - 1; i >= 0; i--) {

			char posicion = string1.charAt(i);

			if (string1.charAt(i) >= 65 && string1.charAt(i) <= 90 | string1.charAt(i) >= 97
					&& string1.charAt(i) <= 122) {

				if (posicion == 65 | posicion == 69 | posicion == 73 | posicion == 79 | posicion == 85 | posicion == 97
						| posicion == 101 | posicion == 105 | posicion == 111 | posicion == 117) {
					vocales++;
				} else
					consonantes++;
			}
		}
		return ("Hay " + vocales + " vocales y " + consonantes + " consonantes");
	}

	/*
	 * 
	 */
	public static boolean esPalindromo(String string1) {

		for (int i = 0; i < string1.length() - 1; i++) {

			if (string1.charAt(i) == string1.charAt(string1.length() - 1 - i)) {
				return true;
			}

		}
		return false;
	}

	/*
	 * 
	 */
	public static String numeroPalabras(String string1) {
		int wordcount = 1;
		if (string1.length() == 0) {
			return ("No hay palabras");
		} else {
			for (int i = string1.length() - 1; i >= 0; i--) {
				if (string1.charAt(i) == 32 && string1.charAt(i - 1) != 32) {
					wordcount += 1;
				}
			}
			return ("Hay " + wordcount + " palabras ");

		}
	}

	/*
	 * 
	 */
	public static int compararCadenas(String string1, String string2) {
		int n = 0;

		for (int i = 0; i < string1.length() && i < string2.length(); i++) {
			if (string1.charAt(i) < string2.charAt(i)) {
				return -1;
			} else if (string1.charAt(i) > string2.charAt(i)) {
				return 1;
			}
		}

		if (string1.length() < string2.length()) {
			return -1;
		} else if (string1.length() > string2.length()) {
			return 1;
		} else
			return 0;

	}

	/*
	 * 
	 */
	public static String textoMeniscula(String string1) {
		char[] string3 = string1.toCharArray();
		String stringx = ("");
		for (int i = 0; i < string1.length(); i++) {
			if (string3[i] <= 90 && string3[i] >= 65) {
				string3[i] += 32;
			}
		}

		for (int i = 0; i < string1.length(); i++) {

			stringx += string3[i];

		}

		return stringx;

	}
}








