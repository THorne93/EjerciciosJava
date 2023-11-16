package capitulo04.bloque09;

public class Ex04countOccurrences {

	public static void main(String[] args) {
		
		int array[] = new int[20];
		Utils.Arrays.makeArray(array, 0, 50);
		Utils.Arrays.printArray(array);
		
		int numeroBuscado = Utils.Arrays.requestNumber("Que numero quieres buscar?");
		
		System.out.println("\nHay " +countOccurrences(array,numeroBuscado) +" ocurrencia(s) de " +numeroBuscado);
	}
	
	public static int countOccurrences(int[] array, int numeroBuscado) {
		int count = 0;
			
		for (int i = 0; i < array.length; i++) {
			if (array[i] == numeroBuscado) {
				count++;
			}
		}
			
		return count;
	}

}
