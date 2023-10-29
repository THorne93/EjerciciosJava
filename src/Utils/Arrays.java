package Utils;

import javax.swing.JOptionPane;

public class Arrays {

	public static int getRandomNumber() {
		return (int) Math.round(Math.random() * 100);
	}

	public static void makeArray(int array[], int limiteinf, int limitesup) {
		for (int i = 0; i < array.length; i++) {
			array[i] = limiteinf + (int) Math.round(Math.random() * (limitesup - limiteinf));
		}
	}

	public static int requestNumber(String text) {
		String str;
		str = JOptionPane.showInputDialog(text);
		int n = Integer.parseInt(str);
		return n;
	}
	
	public static String requestString(String text) {
		String input = JOptionPane.showInputDialog(text);
		return input;
	}

	public static void printArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void cambiaSignoEnValores(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print((array[i] *= -1) + " ");
		}
	}

	public static int[] creaTercerArray(int array[], int array2[]) {

		int array3[] = new int[150];
		for (int i = 0; i < array.length; i++) {
			if ((i & 1) != 1) {
				array3[i] = array[i];
			} else
				array3[i] = array2[i];
		}
		return array3;
	}

	public static void multiplicaValoresPorFactor(int array[], int factor) {
		for (int i = 0; i < array.length; i++) {
			System.out.print((array[i]) * factor + " ");
		}
	}

	public static void desplazaCiclicoDerecha(int array[]) {
		int temp = array[0];

		array[0] = array[4];
		array[4] = array[3];
		array[3] = array[2];
		array[2] = array[1];
		array[1] = temp;
	}

	public static void desplazaCiclicoIzquierda(int array[], int posiciones) {
		int temp;
		for (int i = 0; i < posiciones; i++) {
			temp = array[0];
			array[0] = array[1];
			array[1] = array[2];
			array[2] = array[3];
			array[3] = array[4];
			array[4] = temp;
		}
	}

	public static void desplazaCiclicoDerecha(int array[], int posiciones) {
		int temp;
		for (int i = 0; i < posiciones; i++) {
			temp = array[0];
			array[0] = array[4];
			array[4] = array[3];
			array[3] = array[2];
			array[2] = array[1];
			array[1] = temp;
		}
	}

	public static void desplazaCiclicoDerechaNew(int array[], int posiciones) {

		int temp = array[array.length - 1];
		for (int i = array.length - 1; i > 0; i--) {
			array[i] = array[i - 1];
		}
		array[0] = temp;
	}

	public static void desplazaCiclico(int array[], int posiciones, int direccion) {
		if (direccion == 0)
			desplazaCiclicoIzquierda(array, posiciones);
		else if (direccion == 1)
			desplazaCiclicoDerechaNew(array, posiciones);

	}

//	public static int

}