package captitulo04.bloque07;

public class Ex04MatrizNumerosNoRepetidos {

	public static void main(String[] args) {

		int m[][] = new int[6][10];
		int temp;
		int test[] = new int[60];
		int count = 0;
		boolean existe = false;
		
		int mayor = 0, menor = 0;
		int posicionMenorI = 0;
		int posicionMenorJ = 0;
		int posicionMayorI = 0;
		int posicionMayorJ = 0;
		
		
		rellenaMatriz(m, test, count);

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}

		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				
				
				if(i == 0) {
					mayor = m[i][j];
					menor = m[i][j];
					posicionMenorI = i;
					posicionMenorJ = j;
					posicionMayorI = i;
					posicionMayorJ = j;
				}
				else if (m[i][j] > mayor) {
						mayor = m[i][j];
						posicionMayorI = i;
						posicionMayorJ = j;
					}
					else if (m[i][j] < menor) {
						menor = m[i][j];
						posicionMenorI = i;
						posicionMenorJ = j;

					}
			}

		}
		
		
		System.out.println();
		System.out.print("El maximo es " +mayor +" y se encuentra en m[" +posicionMayorI +"][" +posicionMayorJ +"]" );
		System.out.print("\nEl minimo es " +menor +" y se encuentra en m[" +posicionMenorI +"][" +posicionMenorJ +"]" );
		
		
	}

	private static void rellenaMatriz(int[][] m, int[] test, int count) {
		int temp;
		boolean existe;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {

				do {
					existe = false;
					temp = (int) Math.round(Math.random() * 1000);
					for (int k = 0; k < test.length; k++) {
						if (test[k] == temp) {
							existe = true;
						}
					}

				} while (existe == true);

				m[i][j] = temp;
				test[count] = temp;
				count++;

			}
		}
	}
		
	
	
}
