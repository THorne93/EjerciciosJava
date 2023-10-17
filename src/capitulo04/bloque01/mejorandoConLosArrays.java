package capitulo04.bloque01;

import javax.swing.JOptionPane;

import Utils.Arrays;

public class mejorandoConLosArrays {
	
	private static final int y = 0;
	private static int x;

	public static void main(String[] args) {
//		ex01();
//		ex02();
//		ex03();
//		ex04();
//		ex05();
		ex06();
	}
		
		public static void ex01 () {
			int array[] = new int[150];
			
			Utils.Arrays.makeArray(array, -100, 100);
			Utils.Arrays.printArray(array);
			System.out.println();
			Utils.Arrays.cambiaSignoEnValores(array);
		}
		
		public static void ex02 () {
			int array[] = new int[150];
			int array2[] = new int[150];
			
			Utils.Arrays.makeArray(array, 0, 100);
			Utils.Arrays.makeArray(array2, 0, 100);
			
			Utils.Arrays.printArray(array);
			System.out.println();
			
			Utils.Arrays.printArray(array2);
			System.out.println();
			
			Utils.Arrays.printArray(Utils.Arrays.creaTercerArray(array, array2));
			
		}		
		
		public static void ex03 () {
			int array[] = new int[150];
			
			Utils.Arrays.makeArray(array, 0, 100);
			
			Utils.Arrays.printArray(array);
			System.out.println();
			int factor  = Utils.Arrays.requestNumber("Introduzca un factor de multiplicacion");
			Utils.Arrays.multiplicaValoresPorFactor(array, factor);
			
		}
		
		public static void ex04 () {
			int array[] = new int[5];
			
			Utils.Arrays.makeArray(array, 0, 100);			
			Utils.Arrays.printArray(array);		
			Utils.Arrays.desplazaCiclicoDerecha(array);
			System.out.println();
			Utils.Arrays.printArray(array);
			}	
		
		public static void ex05 () {
			int array[] = new int[5];
			
			Utils.Arrays.makeArray(array, 0, 100);			
			Utils.Arrays.printArray(array);		
			int factor  = Utils.Arrays.requestNumber("Cuántos posiciones quieres desplazar?");
			Utils.Arrays.desplazaCiclicoIzquierda(array, factor);
			System.out.println();
			Utils.Arrays.printArray(array);
		}	
	
		public static void ex06 () {
			int array[] = new int[5];
			
			Utils.Arrays.makeArray(array, 0, 100);			
			Utils.Arrays.printArray(array);		
			int factor  = Utils.Arrays.requestNumber("Cuántos posiciones quieres desplazar?");
			int direccion = Utils.Arrays.requestNumber("En que direccion? (0 para izquierda, 1 para derecha)");
			Utils.Arrays.desplazaCiclico(array, factor, direccion);
			System.out.println();
			Utils.Arrays.printArray(array);
		}	
		
}