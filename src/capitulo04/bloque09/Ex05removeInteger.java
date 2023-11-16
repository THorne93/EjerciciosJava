package capitulo04.bloque09;

public class Ex05removeInteger {

	public static void main(String[] args) {

		int array[] = new int[20];
		Utils.Arrays.makeArray(array, 0, 10);
		Utils.Arrays.printArray(array);
		
		int numBuscado = Utils.Arrays.requestNumber("Que numero quieres quitar?");
		int count = countOccurrences(array,numBuscado);

		System.out.println();
		Utils.Arrays.printArray(removeInteger(array,numBuscado,count));
	
	}

	
	public static int countOccurrences(int[] array, int numBuscado) {
		int count = 0;
			
		for (int i = 0; i < array.length; i++) {
			if (array[i] == numBuscado) {
				count++;
			}
		}
			
		return count;
	}
	
	public static int[] removeInteger(int[]array, int numBuscado,int count) {
		
		int arrayNew[] = new int[array.length-count];
		int j = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != numBuscado) {
				arrayNew[j] = array[i];
				j++;
			}
		}
		
		return arrayNew;
	}
}
