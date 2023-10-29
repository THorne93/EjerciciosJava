package examenes.examen20231024;

import javax.swing.JOptionPane;

public class ExB {

	public static void main(String[] args) {

		// inicializa los int
		String str;
		str = JOptionPane.showInputDialog("Que numero?");
		int num = Integer.parseInt(str);
		int count = 0;

		// el bucle que identifica los numeros perfectos
		for (int i = num - 1; i > 0; i--) {
			if ((num % i) == 0) {
				count += i;
			}
		}

		// imprime si es perfecto u no
		if (count == num) {
			System.out.println("el numero " + num + " es perfecto!");
		} else
			System.out.println("el numero " + num + " no es perfecto");

	}
}