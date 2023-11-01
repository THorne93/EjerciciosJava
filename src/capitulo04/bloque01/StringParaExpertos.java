package capitulo04.bloque01;

public class StringParaExpertos {

	public static void main(String[] args) {
		String string1 = Utils.Arrays.requestString("Dime algo");
//		String string1 = "Hola que tal vosotros";

		// ex01
//		System.out.print(eliminarEspaciosEnBlanco(string1));

		//ex02
//		cifradoCesar(string1);

		//ex03
//		contarOcurrencias(string1);

		//ex04
//		encontrarPalabraMasLarga(string1);
		
		//ex05
//		System.out.print(intertirContenidoPalabras(string1));
		
		//ex06
		buscarPangrama(string1);
		}




	private static void buscarPangrama(String string1) {
		String alfabeto = "abcdefghijklmnopqrstuvwxyz";
		char[] stringAlfabeto = alfabeto.toCharArray();
		
		String stringx = capitulo04.bloque01.ArraysDeCaracteresYString.textoMeniscula(string1);

		stringx = eliminarEspaciosEnBlanco(stringx);
		
		char[] stringPrueba = stringx.toCharArray();
		int j;
		boolean esPangrama = true;
		
		for (int i = 0; i < alfabeto.length(); i++) {
			
			 boolean found = false;
			    for (j = 0; j < stringx.length(); j++) {
			        if (stringPrueba[j] == stringAlfabeto[i]) {
			            found = true;
			            break;
			        }
			    }
			    if (!found) {
			        esPangrama = false;
			    }
			}
			
		if (esPangrama == true) System.out.println(string1 +" Es una pangrama");
		else System.out.println(string1 +" No es una pangrama");
	}
	/*
	 * 
	 */	
	
	private static String intertirContenidoPalabras(String string1) {
		int posicionPalabra = 0;
		int posicionPalabraFinal = 0;
		int j = 0;
		int limit = string1.length();
		String stringx = ("");
		
		for (int i = 0; i < string1.length(); i++) {
			
			if ((string1.charAt(i) >= 65 && string1.charAt(i) <= 90) || (string1.charAt(i) >= 97 && string1.charAt(i) <= 122)) {
				posicionPalabra = i;
				j = i;
				
				//  (string1.charAt(j) !=32 && j < limit) no funciona, pero al reves si
				while (j < limit && string1.charAt(j) != 32) {
					j++;
				}

				posicionPalabraFinal = j-1;
				for (int k = posicionPalabraFinal; k >= posicionPalabra; k--) {
					stringx += string1.charAt(k);
				}
				i = posicionPalabraFinal;
			}
			
			else stringx += " ";
		}
		return stringx;
	}

	/*
	 * 
	 */
	private static void encontrarPalabraMasLarga(String string1) {
		int caraLength = 0;
		int caraLengthTemp = 0;
		int posicionPalabra = 0;
		int posicionPalabraTemp = 0;
		int posicionPalabraFinal = 0;
		int posicionPalabraFinalTemp = 0;

		for (int i = 0; i < string1.length(); i++) {
			if (string1.charAt(i) != 32) {
				posicionPalabraTemp = i;
				int j = i;
				while (string1.charAt(j) != 32 && (i + j) <= string1.length()) {
					caraLengthTemp++;
					j++;
				}
				i = j;
				posicionPalabraFinalTemp = j;
			}

			if (caraLengthTemp > caraLength) {
				caraLength = caraLengthTemp;
				posicionPalabra = posicionPalabraTemp;
				posicionPalabraFinal = posicionPalabraFinalTemp;
			}

			caraLengthTemp = 0;
		}
		System.out.println("La palabra más grande es: " + string1.substring(posicionPalabra, posicionPalabraFinal));
	}

	/*
	 * 
	 */
	private static void contarOcurrencias(String string1) {
		String string2 = Utils.Arrays.requestString("Que buscas?");
		int wordCount = 0;
		System.out.println(string1);
		for (int i = 0; i < string1.length(); i++) {

			if (string1.charAt(i) == string2.charAt(0)) {
				boolean isSame = false;

				for (int j = 0; j < string2.length(); j++) {
					if (string1.charAt(i + j) == string2.charAt(j)) {
						isSame = true;
					} else
						isSame = false;
				}

				if (isSame)
					wordCount++;
			}

		}
		System.out.println("La palabra '" + string2 + "' aparece " + wordCount + " veces");
	}

	/*
	 * 
	 */
	private static void cifradoCesar(String string1) {
		int factor = Utils.Arrays.requestNumber("Por cuantos posiciones quieres mover?");
		char[] string2 = string1.toCharArray();
		String stringx = ("");

		if (factor >= 0) {
			for (int i = 0; i < factor; i++) {

				for (int j = 0; j < string1.length(); j++) {

					if (string2[j] == 90) {
						string2[j] = 65;
						continue;
					}
					if (string2[j] == 122) {
						string2[j] = 97;
						continue;
					}
					if (string2[j] == 32) {
						string2[j] = 32;
						continue;
					} else
						string2[j] += 1;
				}
			}
		} else {
			int factorPositivo = (factor * -1);
			for (int i = 0; i < factorPositivo; i++) {

				for (int j = 0; j < string1.length(); j++) {

					if (string2[j] == 65) {
						string2[j] = 90;
						continue;
					}
					if (string2[j] == 97) {
						string2[j] = 122;
						continue;
					}
					if (string2[j] == 32) {
						string2[j] = 32;
						continue;
					} else
						string2[j] -= 1;
				}
			}
		}
		for (int j = 0; j < string1.length(); j++) {
			stringx += string2[j];
		}
		System.out.println(stringx);
	}

	/*
	 * 
	 */
	private static String eliminarEspaciosEnBlanco(String string1) {
		char[] string2 = string1.toCharArray();
		String stringx = ("");
		for (int i = 0; i < string1.length(); i++) {
			if (string2[i] != 32) {
				stringx += string2[i];
			}
		}
		return stringx;
	}

}
