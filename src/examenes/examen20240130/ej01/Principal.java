package examenes.examen20240130.ej01;

import java.util.HashMap;
import java.util.Iterator;

import hashMap.Articulo;

public class Principal {

	public static void main(String[] args) {
		
		boolean end = false;
		Biblioteca biblioteca = new Biblioteca();
		
		do {
			
			int selector = Utils.Arrays.requestNumber(
					"0 - Salir \n1 - Prestar Libro \n2 - Devolver Libro");

			switch (selector) {
			case 0:
				end = true;
				break;
			case 1:
				biblioteca.prestarLibro(biblioteca.getHm(), biblioteca.getList());
				break;
			case 2:
				biblioteca.devolverLibro(biblioteca.getHm(), biblioteca.getList());
				break;
			}
				
		} while (end == false);
		

	
		}

	}

		