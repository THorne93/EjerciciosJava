package capitulo04.bloque06;

import capitulo03.bloque01.bucleFor;

public class Matrices {

	public static void main(String[] args) {
		int m[][] = new int[5][5];

//		int m[][] = new int[][] { 	{ 1, 5, 6, 0, 6 }, 
//									{ 0, 2, 3, 2, 1 }, 
//									{ 0, 0, 3, 2, 1 }, 
//									{ 0, 0, 0, 4, 1 },
//									{ 0, 0, 0, 0, 5 } };

		rellenaMatriz(m);
//
//		imprimeMatriz(m);
//
//		System.out.println();
//
//		esPositiva(m);
//
//		System.out.println("Es diagonal? " + esDiagonal(m));
//
//		System.out.println("Es triangulo superior? " + esTrianguloSuperior(m));
//
//		System.out.println("Es dispersa? " + esDispersa(m));
//
//		convertirEnArray(m);
//
//		esSimetrica(m);
//
//		crearMatrizTraspuesta(m);
//
//		crearMatrizOpuesta(m);
//
//		eliminarFila(m);

	}

	private static boolean esDispersa(int[][] m) {
		boolean esDispersa = false;
		for (int i = 0; i < m.length; i++) {
			esDispersa = false;
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] == 0) {
					esDispersa = true;
				}

			}
			if (esDispersa == false) {
				break;
			}

		}
		if (esDispersa == true) {
			return true;
		} else
			return false;

	}

	/*
	 * 
	 */
	private static boolean esTrianguloSuperior(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] != 0 && j < i) {
					return false;
				}
			}

		}
		return true;
	}

	/*
	 * 
	 */
	private static boolean esDiagonal(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] != 0 && j != i) {
					return false;
				}
			}

		}
		return true;
	}

	/*
	 * 
	 */
	private static void eliminarFila(int[][] m) {
		int fila = Utils.Arrays.requestNumber("Que fila quieres eliminar?");

		for (int i = 0; i < fila - 1; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();

		}

		for (int i = fila; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/*
	 * 
	 */
	private static void crearMatrizOpuesta(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] *= -1;
			}
		}
		imprimeMatriz(m);
	}

	/*
	 * 
	 */
	private static void crearMatrizTraspuesta(int[][] m) {
		int m2[][] = new int[5][5];
		for (int j = 0; j < m.length; j++) {
			for (int i = 0; i < m[j].length; i++) {
				m2[j][i] = m[i][j];
			}

		}
		for (int i = 0; i < m2.length; i++) {
			for (int j = 0; j < m2[i].length; j++) {
				System.out.print(m2[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/*
	 * 
	 */
	private static void esSimetrica(int[][] m) {
		boolean esSimetrica = true;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] != m[j][i]) {
					esSimetrica = false;
				}
			}
		}
		System.out.println("\nes simetrica = " + esSimetrica);
	}

	/*
	 * 
	 */
	private static void convertirEnArray(int[][] m) {
		int count = 0;
		int a[] = new int[25];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				a[count] += m[i][j];
				count++;
			}
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	/*
	 * 
	 */
	private static void esPositiva(int[][] m) {
		boolean esPositivo = true;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] < 0) {
					esPositivo = false;
				}
			}
		}
		if (esPositivo == true) {
			System.out.println("la matriz es positiva");
		} else
			System.out.println("la matriz no es positiva");
	}

	/*
	 * 
	 */
	private static void imprimeMatriz(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/*
	 * 
	 */
	private static void rellenaMatriz(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = (int) Math.round(Math.random() * 100);

			}
		}
	}
}
