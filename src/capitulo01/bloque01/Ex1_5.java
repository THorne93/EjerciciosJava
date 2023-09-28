package capitulo01.bloque01;

import java.util.Scanner;

public class Ex1_5 {

	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame un numero: "); 
		int num1 = sc.nextInt();
		
		System.out.println("Dame otro numero: ");
		int num2 = sc.nextInt();
		
		System.out.println("Los valores de antes son: " +num1 + " y " +num2);
		
		int aux = num1;
		num1 = num2;
		num2 = aux;
		
		
		System.out.println("Los valores cambiados son: " +num1+ " y " +num2);
	}
}