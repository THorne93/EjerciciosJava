package examenes.examen20231205;

public class Ex01_MaximaSuma {

	public static void main(String[] args) {
		
		boolean hayCambios = true;
		int array[] = new int[20];
		Utils.Arrays.makeArray(array, 0, 20);
		Utils.Arrays.printArray(array);
		
		do {
			 hayCambios = false;
				for (int i = 0; i < array.length-1; i++) {
					if (array[i] > array[i+1]) {
						hayCambios = true;
						int temp = array[i+1];
						array[i+1] = array[i];
						array[i] = temp;
					}
				}
		} while (hayCambios == true);
		
		System.out.println("\nLos dos elementos maximos son: " +array[array.length-1] +" y " +array[array.length-2] +" y su suma es: " +(array[array.length-1]+array[array.length-2]));
		
	}

}
