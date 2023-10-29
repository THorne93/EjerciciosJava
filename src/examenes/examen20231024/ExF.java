package examenes.examen20231024;

import javax.swing.JOptionPane;

public class ExF {

	public static void main(String[] args) {

		// inicializa los variables/integers
		String str;
		int array[] = new int[10];
		int numcount = 0;
		int finish = 0;

		// crear el array
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 5) + 1;
		}

		// imprimir el array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		// un bucle para volver a pedir si el usuario se equivoca
		while (finish < 1) {
			str = JOptionPane.showInputDialog("Que numero quieres ver?");
			int numero = Integer.parseInt(str);

			// segundo bucle para contar instancias del numero introducido
			if (numero > 0 && numero <= 6) {
				for (int i = 0; i < array.length; i++) {
					if (array[i] == numero) {
						numcount++;
					}
				}

				// un sysout para decir el numero y un accumulador para terminar el primer bucle
				System.out.println("Hay " + numcount + " instancia(s) de " + numero);
				finish++;
			}

		}
	}
}