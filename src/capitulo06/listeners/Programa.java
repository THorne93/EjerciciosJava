package capitulo06.listeners;

import java.util.ArrayList;
import java.util.List;

public class Programa {

	private static List<MathListener> listeners = new ArrayList<MathListener>();

	public static void addMathListener(MathListener l) {
		listeners.add(l);
	}

	public static void removeMathListener(MathListener l) {
		listeners.remove(l);
	}

	public static void main(String[] args) {

		boolean end = false;
		Juan juan1 = new Juan();

		do {
			int selector = Utils.Arrays.requestNumber(
					"0 - Salir \n1 - Sumar \n2 - Restar" + "\n3 - Multiplicar \n4 - Dividir \n5 - Raíz cuadrada");

			switch (selector) {
			case 0:
				end = true;
				break;
			case 1:
				sumar();
				break;
			case 2:
				restar();
				break;
			case 3:
				multiplicar();
				break;
			case 4:
				dividir();
				break;
			case 5:
				raiz();
				break;
			}

		} while (end == false);
	}

	private static void raiz() {
		int num1 = Utils.Arrays.requestNumber("Introduzca un número");

		double num3 = Math.sqrt(num1);

		if (num1 < 0) {
			MathEvent e = new MathEvent();
			e.setNumeroIntroducido((int) num1);
			fireRaizNegativo(e);
		}

		System.out.println(num3);

	}

	private static void dividir() {
		int num1 = Utils.Arrays.requestNumber("Introduzca un número");
		int num2 = Utils.Arrays.requestNumber("Introduzca otro número");

		

		try {
		int num3 = num1 / num2;
		System.out.println(num3);
		} catch (ArithmeticException ex) {
			MathEvent e = new MathEvent();
			e.setNumeroIntroducido((int) num2);
			fireDivisionCero(e);
			
		}
	}

	private static void multiplicar() {
		int num1 = Utils.Arrays.requestNumber("Introduzca un número");
		int num2 = Utils.Arrays.requestNumber("Introduzca otro número");

		int num3 = num1 * num2;

		if (num3 > 1000) {
			MathEvent e = new MathEvent();
			e.setNumeroIntroducido((int) num3);
			fireNumeroMasDeMil(e);
		}

		System.out.println(num3);

	}

	private static void restar() {
		int num1 = Utils.Arrays.requestNumber("Introduzca un número");
		int num2 = Utils.Arrays.requestNumber("Introduzca otro número");

		int num3 = num1 - num2;

		if (num3 < 0) {
			MathEvent e = new MathEvent();
			e.setNumeroIntroducido((int) num3);
			fireNumeroNegativo(e);
		}
		System.out.println(num3);

	}

	private static void sumar() {
		int num1 = Utils.Arrays.requestNumber("Introduzca un número");
		int num2 = Utils.Arrays.requestNumber("Introduzca otro número");

		int num3 = num1 + num2;

		if (num3 > 1000) {
			MathEvent e = new MathEvent();
			e.setNumeroIntroducido((int) num3);
			fireNumeroMasDeMil(e);
		}
		System.out.println(num3);

	}

	private static void fireNumeroMasDeMil(MathEvent e) {
		for (MathListener l : listeners) {
			l.masDeMil(e);
		}
	}

	private static void fireNumeroNegativo(MathEvent e) {
		for (MathListener l : listeners) {
			l.numeroNegativo(e);
		}
	}

	private static void fireDivisionCero(MathEvent e) {
		for (MathListener l : listeners) {
			l.divisionZero(e);
		}
	}

	private static void fireRaizNegativo(MathEvent e) {
		for (MathListener l : listeners) {
			l.raizNegativo(e);
		}
	}
}
