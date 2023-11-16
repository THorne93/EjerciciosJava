package capitulo04.bloque09;

public class Ex03addInteger {

	public static void main(String[] args) {

		int array[] = new int[20];
		Utils.Arrays.makeArray(array, 0, 50);
		Utils.Arrays.printArray(array);
		
		int numeroNuevo = Utils.Arrays.requestNumber("Que numero quieres añadir?");
		System.out.println();
		Utils.Arrays.printArray(addInteger(array, numeroNuevo));
		
	}

	public static int[] addInteger(int[] array, int numeroNuevo) {
		
		int arrayX[] = new int[array.length+1];
		
		for (int i = 0; i < array.length; i++) {
			arrayX[i] = array[i];
		}
		
		arrayX[arrayX.length-1] = numeroNuevo;
		
		return arrayX;
	}


}