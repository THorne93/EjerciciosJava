package capitulo04.bloque01;

public class algoritmosDeOrdenación {
	

	public static void main(String[] args) {
//		Ex01();
//		Ex02();
		Ex03();
//		Ex04();
	}

	public static void Ex01 () {
		int array[] = new int[150];
		boolean hayCambios = true;
		
		Utils.Arrays.makeArray(array, 0, 1000);
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
		
		System.out.println();
		Utils.Arrays.printArray(array);
	}
/*
 * 
 */
	public static void Ex02 () {
		int array[] = new int[150];
		int i, j;
		int current;
		
		Utils.Arrays.makeArray(array, 0, 1000);
		Utils.Arrays.printArray(array);
		
		for (i = 1; i < array.length; i++) {
			current = array[i];
			for (j = i; j > 0 && array[j-1] > current; j--) {
				array[j] = array[j-1];
			}
			array[j] = current;
		}
		
		System.out.println();
		Utils.Arrays.printArray(array);
	}
/*
 * 		
 */
	public static void Ex03 () {
		int array[] = new int[150];
		int i;
		int shell = array.length/5;
		
		Utils.Arrays.makeArray(array, 0, 1000);
		Utils.Arrays.printArray(array);
		
		do {
			for (i = 0; i < array.length; i++) {
				for (int j = i; j < array.length-shell; j++) {
					if (array[j] > array[j+shell]) {
						int temp = array[j+shell];
						array[j+shell] = array[j];
						array[j] = temp;
					}
				}
			}			
			shell /= 2;
		} while (shell > 0);	
	
		System.out.println();
		Utils.Arrays.printArray(array);
	}
/*
 * 
 */	
	public static void Ex04() {

		int array[] = new int[150];
		int i, j;
		int lowest;

		Utils.Arrays.makeArray(array, 0, 1000);
		Utils.Arrays.printArray(array);

		for (i = 0; i < array.length - 1; i++) {
			lowest = i;

			for (j = i; j < array.length; j++) {
				if (array[j] < array[lowest]) {
					lowest = j;
				}

				int temp = array[i];
				array[i] = array[lowest];
				array[lowest] = temp;

			}
		}

		System.out.println();
		Utils.Arrays.printArray(array);
	}
}