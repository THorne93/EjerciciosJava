package capitulo06.bloque01;

import java.util.ArrayList;
import java.util.List;

public class ListaIntegers {

	public static void main(String[] args) {
		boolean end = false;
		List<Integer> list = new ArrayList<Integer>();

		do {
			String selector = Utils.Arrays.requestString(
					"a) Abandonar el programa \nb) Crear aleatoriamente la lista de valores \nc) Calcula suma, media, mayor y menor"
							+ "\nd) Agregar una cantidad de nuevos valores \ne) Eliminar valores cuyo valor esté en un intervalo \nf)"
							+ " Imprimir la lista");

			switch (selector) {
			case "a":
				end = true;
				break;
			case "b":
				crearLista(list);
				break;
			case "c":
				calculos(list);
				break;
			case "d":
				agregarValores(list);
				break;
			case "e":
				eliminarValores(list);
				break;
			case "f":
				imprimeLista(list);
				break;
			}
			

		} while (end == false);

	

	}

	private static void imprimeLista(List<Integer> list) {
		System.out.println();
		for (int j = 0; j < list.size(); j++) {
			System.out.println(list.get(j));
		}
	}

	private static void eliminarValores(List<Integer> list) {
		int minimo = Utils.Arrays.requestNumber("Desde donde quieres eliminar?");
		int maximo = Utils.Arrays.requestNumber("Hasta donde quires eliminar?");
		
		for (int i = 0; i <= (maximo-minimo); i++) {
			list.remove(maximo - i);
		}
	}

	private static void agregarValores(List<Integer> list) {
		int count = Utils.Arrays.requestNumber("Cuantós números más quieres añadir?");
		int minimo = Utils.Arrays.requestNumber("escribe el minimo");
		int maximo = Utils.Arrays.requestNumber("escribe el maximo");
		int posicion = Utils.Arrays.requestNumber("En que posición quieres añadir los números?");
		
		List<Integer> list2 = new ArrayList<Integer>();
		
		for (int i = 0; i < count; i++) {
			list2.add(Utils.Arrays.getRandomNumber(minimo, maximo));
		}
		
		list.addAll(posicion, list2);
		
		

		
	}

	private static void calculos(List<Integer> list) {
		int suma = 0, media = 0; 
		int menor = list.get(1);
		int mayor = list.get(1);
		
		for (int i = 0; i < list.size(); i++) {
			suma += list.get(i);
			if (menor > list.get(i)) {
				menor = list.get(i);
			}
			if (mayor < list.get(i)) {
				mayor = list.get(i);
			}
			
		}
		
		media = (suma/list.size());
		System.out.println("Suma: " +suma +"\nMedia: " +media +"\nMenor: " +menor +"\nMayor: " +mayor);
	}

	private static void crearLista(List<Integer> list) {
		int longitud = Utils.Arrays.requestNumber("de que longitud quieres la lista?");
		int minimo = Utils.Arrays.requestNumber("escribe el minimo");
		int maximo = Utils.Arrays.requestNumber("escribe el maximo");

		list.clear();
		
		for (int i = 0; i < longitud; i++) {
			list.add(Utils.Arrays.getRandomNumber(minimo, maximo));
		}
		
	}



}
