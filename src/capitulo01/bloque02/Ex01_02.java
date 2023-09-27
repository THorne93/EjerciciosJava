package capitulo01.bloque02;

import java.util.Scanner;

public class Ex01_02 {


	public static void main(String[] args) {
	calc(5);
	}
	
		public static void calc(int numOfTimes) {
			Scanner sc = new Scanner(System.in);
			int negativos = 0;
			int bajos = 0;
			int medios = 0;
			int grandes = 0;
			
			int negcount = 0;
			int bajcount = 0;
			int medcount = 0;
			int gracount = 0;
			
			
			int i = 0;
			while (i < 5) {

			System.out.println("Dame un número: ");
			int num = sc.nextInt();
			
				if (num < 0) {
					int test = (+ negativos + num);
					negativos = test;
					negcount++;
				}
				else if (num >= 0 && num <= 25) {
					int test2 = (+ bajos + num);
					bajos = test2;
					bajcount++;
					
				}
				else if (num >= 26 && num <= 250) {
					int test3 = (+ medios + num);
					medios = test3;
					medcount++;
				}
				else {
					int test4 = (+ grandes + num);
					grandes = test4;
					gracount++;

				}
				i++;
				
			if (i == 5) {
				System.out.println("la suma de los negativos son " +negativos  +" y el total de números negativos son " +negcount);
				System.out.println("la suma de los bajos son " +bajos  +" y el total de números bajos son " +bajcount);
				System.out.println("la suma de los medios son " +medios  +" y el total de números medios son " +medcount);	
				System.out.println("la suma de las grandes son " +grandes  +" y el total de números grandes son " +gracount);
			}
			}
		}
			
}
	