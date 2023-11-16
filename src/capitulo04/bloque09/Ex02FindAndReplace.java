package capitulo04.bloque09;

public class Ex02FindAndReplace {

	public static void main(String[] args) {

		int array[] = new int[20];
		Utils.Arrays.makeArray(array, 0, 10);
		Utils.Arrays.printArray(array);
		
		int numeroBuscado = Utils.Arrays.requestNumber("Que número quieres reemplazar?");
		int numeroNuevo = Utils.Arrays.requestNumber("Con que número lo quieres reemplazar?");
		
		System.out.println();
		Utils.Arrays.printArray(findAndReplace(array,numeroBuscado,numeroNuevo));
		
	}
	
	public static int[] findAndReplace(int[] array, int numeroBuscado, int numeroNuevo) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == numeroBuscado) {
				array[i] = numeroNuevo;
			}
		}
		return array;
	}

}
