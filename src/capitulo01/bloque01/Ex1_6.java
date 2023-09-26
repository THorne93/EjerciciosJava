package capitulo01.bloque01;

import java.util.Scanner;

public class Ex1_6 {

	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Pon el capital: "); 
		float capital = sc.nextFloat();
		
		System.out.println("Pon el diferencial: ");
		float diferencial = sc.nextFloat();
		
		System.out.println("Pon el Euribor: ");
		float euribor = sc.nextFloat();

		System.out.println("Cuántos meses vas a pagar?: ");
		int mes = sc.nextInt();
		
		float Im = ((+euribor + diferencial)/12/100);
		float var1 = (float) Math.pow((1 + Im),mes);
		
		float cuota = (capital*((Im*var1)/(var1-1)));
		System.out.println("la cuota mensual es: €" +cuota);
	}
}