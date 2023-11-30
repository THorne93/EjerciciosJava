package exam.practice;

import java.util.Iterator;

public class ordenarArray {

	public static void main(String[] args) {
		
		int array[] = new int[10];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = Utils.Arrays.requestNumber("Introduzca un número (" +(i+1) +")");
		}
		
		Utils.Arrays.printArray(array);
		System.out.println();
		Utils.Arrays.printArray(ordenarDescendente(array));
	}
	
	public static int[] ordenarDescendente(int[] array) {
		
		int i, j;
		int current;
		int arrayNew[] = new int[array.length];
		
		for (i = 1; i < array.length; i++) {
			current = array[i];
			for (j = i; j > 0 && array[j-1] > current; j--) {
				array[j] = array[j-1];
			}
			array[j] = current;
		}
		
		for (int k = 0; k < array.length; k++) {
			arrayNew[k] = array[array.length-1-k];
		}
		
		
		return arrayNew;
	}
}
