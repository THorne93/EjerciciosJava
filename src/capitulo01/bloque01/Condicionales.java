package capitulo01.bloque01;

import java.util.Scanner;

public class Condicionales {



//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		
//		System.out.println("Dame un número: ");
//		int num1 = sc.nextInt();
		
//		System.out.println("Dame otro número: ");
//		int num2 = sc.nextInt();
		
//	if (num1 > num2) {
//		System.out.println("El número mayor es: " +num1);
//		System.out.println("El número menor es: " +num2);
//		}
//	else {
//		System.out.println("El número mayor es: " +num2);
//		System.out.println("El número menor es: " +num1);
//	}
//	}}

//public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
	
//	System.out.println("Dame un número: ");
//	int num3 = sc.nextInt();
	
//	System.out.println("Dame otro número(2): ");
//	int num4 = sc.nextInt();
	
//	System.out.println("Dame otro número(3): ");
//	int num5 = sc.nextInt();
	
//	System.out.println("Dame otro número(4): ");
//	int num6 = sc.nextInt();
	
//	System.out.println("Dame otro número(5): ");
//	int num7 = sc.nextInt();
	
//	System.out.println("el numero mayor es: " + Math.max( (Math.max(num3, num4) ),(Math.max( (Math.max(num5, num6) ),num7))));
//	System.out.println("el numero menor es: " + Math.min( (Math.min(num3, num4) ),(Math.min( (Math.min(num5, num6) ),num7))));
//}
//}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Dame un número: ");
		int num8 = sc.nextInt();
	
		if (num8 % 2 == 0) {
		System.out.println("el número es par");
		}
		else {
		System.out.println("el número es impar");
		}
	
	}
}