package capitulo04.bloque01;

import javax.swing.JOptionPane;

public class Primeros_arrays {
	
	public static void main(String[] args) {
//		ex01();
		ex02();
//		ex03();
//		ex04();
//		ex05();
//		ex06();
	}
		public static void ex01 () {
			
			int array[] = new int[150];
			int suma = 0;
			int menor = 0;
			int mayor = 0;
			
			Utils.Arrays.makeArray(array, 0, 150);
			
			Utils.Arrays.printArray(array);
						for (int i : array) {
							suma = (suma + array[i]);
						}
			float media = suma / array.length;
			System.out.println("\n" +"La suma es: " +suma);
			System.out.println("La media es: " +media);	
			menor = array[0];
			mayor = array[0];
			
			for (int i = 0; i < array.length; i++) {
		
				if (array[i] > mayor) {
					mayor = array[i];
				}
				if (array[i] < menor) {
					menor = array[i];
				}			
			}
			System.out.println("El número mayor es: " +mayor);
			System.out.println("Y el número menor es: " +menor);
			
		}
		
		public static void ex02() {

			int limiteinf  = Utils.Arrays.requestNumber("Introduzca un limite inferior");
			int limitesup  = Utils.Arrays.requestNumber("Introduzca un limite superior");
			int array[] = new int[150];
			
			Utils.Arrays.makeArray(array, limiteinf, limitesup);
			Utils.Arrays.printArray(array);
		}
		
		public static void ex03() {
			int numeros[] = new int[150];
			for (int i = 0; i < numeros.length; i++) {
				numeros[i] = (int) Math.floor(Math.random() * 101);
			}
			for (int i = 0; i < numeros.length; i++) {
				System.out.print(numeros[i] + " ");
			} 
			for (int i = (numeros.length -1) ; i >= 0; i--) {
				System.out.print(numeros[i] + " ");
			}
		}
		
		public static void ex04() {
			int numeros[] = new int[150];
			String str;
			for (int i = 0; i < numeros.length; i++) {
				numeros[i] = (int) Math.floor(Math.random() * 101);
			}
			str = JOptionPane.showInputDialog("Busca un número");
			int buscado  = Integer.parseInt(str);
			int buscadocount = 0;
			System.out.println("Se encuentra en posicion(es): ");
			for (int i = 0; i < numeros.length; i++) {
				if (numeros[i] == buscado) {
					System.out.println(i);
					buscadocount++;
				}
			}
			if (buscadocount == 0) {
				System.out.println("No se encuentra el número");
			}
			
		}
		public static void ex05() {
			int numeros[] = new int[150];
			int totalimpar = 0;
			int totalpar = 0;
			for (int i = 0; i < numeros.length; i++) {
				numeros[i] = (int) Math.floor(Math.random() * 101);
			}
			for (int i = 0; i < numeros.length; i++) {
				if ((numeros[i] & 1) == 1) {
					totalimpar += numeros[i];
				}
				else totalpar += numeros[i];
			}
				System.out.println("La suma de los pares es: " +totalpar + " Y la suma de los impares es: " +totalimpar);
		}
			
		public static void ex06() {
			int numeros[] = new int[150];
			int total = 0;
			for (int i = 0; i < numeros.length; i++) {
				numeros[i] = (int) Math.floor(Math.random() * 101);
			}
			for (int i = 0; i < numeros.length; i++) {
				if ((i & 1) == 1) {
					total += numeros[i];
				}
			}
				System.out.println("La suma de los indices pares es: " +total);
		}	
}	
	