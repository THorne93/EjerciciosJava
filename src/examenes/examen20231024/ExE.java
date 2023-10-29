package examenes.examen20231024;

import javax.swing.JOptionPane;

public class ExE {

	public static void main(String[] args) {

		// inicializo los integers
		int digitos = 0;
		int numero = (int) Math.round(Math.random() * 10000);
		
		// imprimo el numero generado
		System.out.println(numero);
		
		//si el numero dividido entre 10000 da 1, suma el int digitos
		if (numero / 10000 != 0) {
			digitos += 1;
		}
		
		//si el numero dividido entre 1000 da 1 o mas, suma el int digitos
		if (numero / 1000 != 0) {
			digitos += 1;
		}
		
		//si el numero dividido entre 100 da 1 o mas, suma el int digitos
		if (numero / 100 != 0) {
			digitos += 1;
		}
		
		//si el numero dividido entre 10 da 1 o mas, suma el int digitos
		if (numero / 10 != 0) {
			digitos += 1;
		}
		
		//si el numero dividido entre 1 da 1 o mas, suma el int digitos
		if (numero / 1 != 0) {
			digitos += 1;
		}

		//imprimo el resuelto
		System.out.println("El número " + numero + " tiene " + digitos + " digitos");
	}
}