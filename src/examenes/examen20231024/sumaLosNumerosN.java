package examenes.examen20231024;

import javax.swing.JOptionPane;

public class sumaLosNumerosN {
	
	public static void main(String[] args) {	

		int i = 0;	
		int j = 2;
		int k = 1;
		boolean esPrimo = true;
		
		String str;
		str = JOptionPane.showInputDialog("Cuantos numeros primos quieres?");
		int tot  = Integer.parseInt(str);

		while (i < tot) {
			
				esPrimo=true;
				j = 2;
				while (j < k) {
					if (k % j == 0) {
						esPrimo = false;
					}
					j++;
				}

				// si el numero es primo, primocount incrementa
				if (esPrimo == true) {
					System.out.println(k);
					i++;
				}
				k++;
			}
			}
			
		
	}
