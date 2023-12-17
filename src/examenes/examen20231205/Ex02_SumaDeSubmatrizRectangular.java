package examenes.examen20231205;

public class Ex02_SumaDeSubmatrizRectangular {
	

	public static void main(String[] args) {
		int m1[][] = new int[5][5];
		int suma = 0;
		
//		int m1[][] =  {{1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1},{1, 2, 1, 2, 1},{1, 2, 1, 2, 1}}; 
		llenarMatriz(m1);
		imprimeMatriz(m1);
		System.out.println();
		
		for (int i = 1; i < 4; i++) {
			for (int j = 2; j < 5; j++) {
				System.out.print(m1[i][j] + "\t");
				suma += m1[i][j];
			}
			System.out.println();
		}
		System.out.println("La suma de los elementos de la submatriz es: " +suma);
		
	
	
	
	}
	public static void imprimeMatriz (int [][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void llenarMatriz (int [][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = Utils.Arrays.getRandomNumber(0, 100);
			}
		}
	}
	
}
