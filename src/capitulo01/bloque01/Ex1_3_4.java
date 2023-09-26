package capitulo01.bloque01;

import java.util.Scanner;

public class Ex1_3_4 {

	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame un número : ");
		int num1 = sc.nextInt();
		
		System.out.println("Dame otro número: ");
		float num2 = sc.nextFloat();
		
		System.out.println("Dame un número más: ");
		int num3 = sc.nextInt();
		
		System.out.println("la suma es: " + (num3 + num2 + num1));
		System.out.println("la media es: " + ((num3 + num2 + num1)/3));	
	}
}