package capitulo04.bloque01;

public class ampliacionCadenasCaracteres {

	public static void main(String[] args) {
		String string1 = Utils.Arrays.requestString("dime algo");

//		eliminarCaracteresRepetidos(string1);

		buscaAnagrama(string1);

//		cambiarPalabra(string1);
		
//		System.out.println(rotacionDeCadenas(string1));
	}

	private static String rotacionDeCadenas(String string1) {
		String string2 = Utils.Arrays.requestString("dime algo más");
		char[] string1Array = string1.toCharArray();
		char[] string2Array = string2.toCharArray();

		boolean esRotacion = false;
		if (string1Array.length != string2Array.length) {
			return (string1 + " no es una rotacion de " + string2);
		}
		for (int i = 0; i < string1.length(); i++) {

			for (int j = 0; j < string1.length(); j++) {
				esRotacion = false;
				if (string1Array[j] == string2Array[j]) {
					esRotacion = true;
				}

			}
			if (esRotacion == true) {
				break;
			}

			char temp = string2Array[0];
			for (int j = 0; j < string2Array.length - 1; j++) {
				string2Array[j] = string2Array[j + 1];
			}
			string2Array[string2Array.length - 1] = temp;

		}
		if (esRotacion == true) {
			return ("Si, " + string2 + " es una rotacion de " + string1);
		} else
			return (string1 + " no es una rotacion de " + string2);
	}

	private static void cambiarPalabra(String string1) {
		String string2 = Utils.Arrays.requestString("Que quieres cambiar?");
		String string3 = Utils.Arrays.requestString("A que lo quieres cambiar?");
		String stringx = "";
		int wordCount = 0;
		int posibleCadena = 0;
		int cadenaEnd = 0;
		int wordLength = 0;
		System.out.println(string1);
		for (int i = 0; i < string1.length(); i++) {

			if (string1.charAt(i) == string2.charAt(0)) {
				boolean isSame = false;

				for (int j = 0; j < string2.length(); j++) {
					if (string1.charAt(i + j) == string2.charAt(j)) {
						posibleCadena = i;
						isSame = true;
						wordLength++;
						cadenaEnd = i + j;

					} else
						isSame = false;
				}

				System.out.println(+posibleCadena + " " + cadenaEnd);

			}
		}

		// crear hasta cambia
		for (int j = 0; j < posibleCadena; j++) {
			stringx += string1.charAt(j);
		}

		// poner el cambio
		for (int j = 0; j < string3.length(); j++) {
			stringx += string3.charAt(j);
		}

		// poner lo que falta
		for (int j = cadenaEnd + 1; j < string1.length(); j++) {
			stringx += string1.charAt(j);
		}
		System.out.print(stringx);

		wordLength = 0;
	}

	private static void buscaAnagrama(String string1) {
		String string2 = Utils.Arrays.requestString("dime algo mas");

		char[] stringPrueba = string1.toCharArray();
		char[] stringAnagrama = string2.toCharArray();

		boolean esDiferente = true;

		for (int i = 0; i < string1.length(); i++) {
			esDiferente = true;

			for (int j = 0; j < string1.length(); j++) {

				if (stringPrueba[i] == stringAnagrama[j]) {
					esDiferente = false;
					break;
				}

			}
			stringPrueba[i] = 0;
			if (esDiferente == true) {
				break;
			}

		}
		if (esDiferente == false) {
			System.out.println(string1 + " es una anagrama de " + string2);
		} else
			System.out.println(string1 + " no es una anagrama de " + string2);
	}

	private static void eliminarCaracteresRepetidos(String string1) {

		char[] string2 = string1.toCharArray();
		String string3 = "";
		boolean esDiferente;

		for (int i = 0; i < string1.length(); i++) {
			esDiferente = true;
			for (int j = 0; j < string3.length(); j++) {
				int charPosible = string2[i];
				if (charPosible == 32) {
					break;
				}
				if (charPosible == string3.charAt(j)) {
					esDiferente = false;
					break;
				}

			}
			if (esDiferente == true) {
				string3 += string2[i];
			}
		}
		System.out.println(string3);
	}

}
