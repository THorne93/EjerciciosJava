package examenes.examen20231024;

public class ExD {

	public static void main(String[] args) {

		// inicializa los variables/integers
		String str;
		int array[] = new int[100];
		boolean esPrimo = true;
		int primocount = 0;

		// crear el array
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
		}

		// primer bucle
		for (int i = 0; i < array.length; i++) {

			for (int j = 2; j < array[i]; j++) {

				// bucle para identificar numero primo
				while (array[i] > j) {
					if (array[i] % j == 0) {
						esPrimo = false;
					}
					j++;
				}

				// si el numero es primo, primocount incrementa
				if (esPrimo == true) {
					primocount++;
					System.out.print(array[i] +" ");
				}

			}

			// antes de volver al bucle, esPrimo vuelve a ser true
			esPrimo = true;

		}
		// imprimir el resultado
		System.out.println("Hay " + primocount + " numeros primo: ");
	}

}