package capitulo01.bloque01;

import java.util.Scanner;

public class Condicionales {



	public static void main(String[] args) {
	//ex1_2();
	//ex3_4_5();
	//ex6();
	ex7();	
	}
	
	public static void ex1_2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dame un número: ");
		int num1 = sc.nextInt();
		
		System.out.println("Dame otro número: ");
		int num2 = sc.nextInt();
		
	if (num1 > num2) {
		System.out.println("El número mayor es: " +num1);
		System.out.println("El número menor es: " +num2);
		}
	else {
		System.out.println("El número mayor es: " +num2);
		System.out.println("El número menor es: " +num1);
	}
	}

	public static void ex3_4_5() {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Dame un número: ");
	int num3 = sc.nextInt();
	
	System.out.println("Dame otro número(2): ");
	int num4 = sc.nextInt();

	System.out.println("Dame otro número(3): ");
	int num5 = sc.nextInt();
	
	System.out.println("Dame otro número(4): ");
	int num6 = sc.nextInt();
	
	System.out.println("Dame otro número(5): ");
	int num7 = sc.nextInt();
	
	if (num3 > num4 && num3 > num5 && num3 > num6 && num3 > num7){
		System.out.println("el número mayor es: " +num3);
	}
		else if (num4 > num5 && num4 > num6 && num4 > num7) {
			System.out.println("el número mayor es: " +num4);
		}
			else if (num5 > num6 && num5 > num7) {
				System.out.println("el número mayor es: " +num5);
			}
			else if (num6 > num7) {
				System.out.println("el número mayor es: " +num6);
			}
			else {
				System.out.println("el número mayor es: " +num7);
	}

	if (num3 < num4 && num3 < num5 && num3 < num6 && num3 < num7){
		System.out.println("el número menor es: " +num3);
	}
		else if (num4 < num5 && num4 < num6 && num4 < num7) {
			System.out.println("el número menor es: " +num4);
		}
			else if (num5 < num6 && num5 < num7) {
				System.out.println("el número menor es: " +num5);
			}
			else if (num6 < num7) {
				System.out.println("el número menor es: " +num6);
			}
			else {
				System.out.println("el número menor es: " +num7);
	}
	
	}
	//System.out.println("el numero mayor es: " + Math.max( (Math.max(num3, num4) ),(Math.max( (Math.max(num5, num6) ),num7))));
		//System.out.println("el numero menor es: " + Math.min( (Math.min(num3, num4) ),(Math.min( (Math.min(num5, num6) ),num7))));
	public static void ex6() {
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
	public static void ex7() {
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Dame un número: ");
		int num9 = sc.nextInt();
		var num10 = 1;		
		if ((num9 & 1) == num10) {
		System.out.println("el número es impar");
		}
		else {
		System.out.println("el número es par");
		}
	
	}
}