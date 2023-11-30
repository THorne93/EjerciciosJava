package capitulo04.bloque01;

public class algoritmosDeOrdenación2 {

	private static final int ARRAYLENGTH = 150;

	public static void main(String[] args) {

		
		int array[] = new int[ARRAYLENGTH];

		crearArray(array);
		Utils.Arrays.printArray(array);

		algoritmoSeleccion(array);

		System.out.println();
		Utils.Arrays.printArray(array);
	}

	private static void algoritmoSeleccion(int[] array) {
		int posicionArray;
		int posibleMasPequeno;
		int lowest;
		for (posicionArray = 0; posicionArray < array.length ; posicionArray++) {
			
			lowest = posicionArray;

			for (posibleMasPequeno = posicionArray; posibleMasPequeno < array.length; posibleMasPequeno++) {
				
				if (array[posibleMasPequeno] < array[lowest]) {
					lowest = posibleMasPequeno;
				}

				int temp = array[posicionArray];
				array[posicionArray] = array[lowest];
				array[lowest] = temp;

			}
		}
	}

	private static void crearArray(int[] array) {
		int posicionArray;
		for (posicionArray = 0; posicionArray < array.length; posicionArray++) {
			
			int random = (int) Math.round(Math.random() * 1000);
			
			array[posicionArray] = random;
		}
	}

}