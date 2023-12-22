package capitulo06.bloque01;

import java.util.ArrayList;
import java.util.List;

public class EditorDeTextos {

	public static void main(String[] args) {

		boolean end = false;
		List<String> list = new ArrayList<String>();
		List<String> listTemp = new ArrayList<String>();
		do {
			String selector = Utils.Arrays.requestString(
					"a) Abandonar el programa \nb) Agregar una línea te texto \nc) Insertar una línea en cualquier posición del texto"
							+ "\nd) Editar una línea \ne) Borrar una línea \nf) Cortar un conjunto de líneas"
							+"\ng) Pegar un conjunto de líneas cortadas en una determinada posición \nh) Imprimir el fichero");

			switch (selector) {
			case "a":
				end = true;
				break;
			case "b":
				agregarLinea(list);
				break;
			case "c":
				insertarLinea(list);
				break;
			case "d":
				editarLinea(list);
				break;
			case "e":
				borrarLinea(list);
				break;
			case "f":
				cortarLineas(list, listTemp);
				break;
			case "g":
				pegarLineas(list, listTemp);
				break;
			case "h":
				imprimeFichero(list);
				break;
			}
			

		} while (end == false);

	}

	private static void imprimeFichero(List<String> list) {
		System.out.println();
		for (int j = 0; j < list.size(); j++) {
			System.out.println(j +": " +list.get(j));
		}
		
	}

	private static void pegarLineas(List<String> list, List<String> listTemp) {
		int posicion = Utils.Arrays.requestNumber("En que linea quieres pegar el texto?");
		
		for (int i = listTemp.size()-1; i >= 0 ; i--) {
			list.add(posicion, listTemp.get(i));
		}
	}

	private static void cortarLineas(List<String> list, List<String> listTemp) {
		listTemp.removeAll(listTemp);
		int inicial = Utils.Arrays.requestNumber("Desde que linea quieres cortar?");
		int ultima = Utils.Arrays.requestNumber("Hasta que linea quieres corta?");
		
		for (int i = inicial; i <= ultima; i++) {
			String a = list.get(i);
			listTemp.add(a);
		
		}
		for (int i = ultima; i >= inicial; i--) {
			list.remove(i);
		}
		
	}

	private static void borrarLinea(List<String> list) {
		boolean esBien = false;
		do {
			int posicion = Utils.Arrays.requestNumber("Que linea quieres borrar?");
			if (posicion < list.size() && posicion > 0) {
				list.remove(posicion);
				esBien = true;
			}
			else System.out.println("La posicion no existe");
		} while (esBien == false);
	}

	private static void editarLinea(List<String> list) {
		boolean esBien = false;
		do {
			int posicion = Utils.Arrays.requestNumber("Que linea quieres cambiar?");
			if (posicion < list.size() && posicion > 0) {
				String input = Utils.Arrays.requestString(list.get(posicion));
				list.set(posicion, input);
				esBien = true;
			}
			else System.out.println("La posicion no existe");
		} while (esBien == false);

		
	}

	private static void insertarLinea(List<String> list) {
		String input = Utils.Arrays.requestString("Escribe");
		boolean esBien = false;
		do {
			int posicion = Utils.Arrays.requestNumber("Donde quieres poner el texto?");
			if (posicion < list.size() && posicion > 0) {
				list.add((posicion), input);
				esBien = true;
			}
			else System.out.println("La posicion no existe");
		} while (esBien == false);
	}

	private static void agregarLinea(List<String> list) {
		
		String input = Utils.Arrays.requestString("Escribe");
		
		list.add(input);
		
	}

}
