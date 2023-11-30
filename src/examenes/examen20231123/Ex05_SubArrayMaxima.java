package examenes.examen20231123;

import java.util.Iterator;

public class Ex05_SubArrayMaxima {

	public static void main(String[] args) {

		int array[] =  {-2, 21, -3, 4, -1, 3, 1, -5, 400};
	
		
		System.out.println("El subarray mas grade se encuentra del posicion ["+(encuentraPosicion(array)+1) 
				+"] a [" +(encuentraPosicion(array)+4) +"] y su suma es: " +sumarSubcadena(array));
	}
	
	public static int encuentraPosicion(int [] array) {
		int sumaReal = 0;
		int sumaTemp = 0;
		int posicionTemp = 0;
		int posicionFinal = 0;
		
		for (int i = 0; i < array.length-3; i++) {
			sumaTemp = 0;
			posicionTemp=i;
			for (int j = 0; j < 4; j++) {
				sumaTemp += array[i+j];
			}
			if (sumaTemp > sumaReal) {
				sumaReal = sumaTemp;
				posicionFinal = posicionTemp;
			}
		}
		return posicionFinal;
	}
	
	public static int sumarSubcadena (int[] array) {
		int sumaReal = 0;
		int sumaTemp = 0;
		
		for (int i = 0; i < array.length-3; i++) {
			sumaTemp = 0;
			for (int j = 0; j < 4; j++) {
				sumaTemp += array[i+j];
			}
			if (sumaTemp > sumaReal) {
				sumaReal = sumaTemp;
			}
		}
		return sumaReal;
	}
	
}

