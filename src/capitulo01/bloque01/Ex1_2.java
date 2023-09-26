package capitulo01.bloque01;

import java.util.Scanner;

public class Ex1_2 {

	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame un número entero: ");
		int num1 = sc.nextInt();
		System.out.println("Valor de numEntero: " + num1);
		
		System.out.println("Dame un flotante: ");
		float num2 = sc.nextFloat();
		System.out.println("Valor de numFlotante: " + num2);
		
		System.out.println("Dame un número doble: ");
		int num3 = sc.nextInt();
		System.out.println("Valor de numDoble: " + num3);	
			
	}
}