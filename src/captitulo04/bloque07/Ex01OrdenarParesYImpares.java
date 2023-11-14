package captitulo04.bloque07;

public class Ex01OrdenarParesYImpares {

	public static void main(String[] args) {

		int array[] = new int[20];
		int auxArray[] = new int[array.length];
		Utils.Arrays.makeArray(array, 0, 100);
		Utils.Arrays.printArray(array);
		System.out.println();
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				auxArray[j] += array[i];
				j++;
			}
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) {
				auxArray[j] = array[i];
				j++;
			}
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = auxArray[i];
		}

		Utils.Arrays.printArray(array);

	}

}
