package examenes.examen20231123;

public class Ex01_SumaDeMatrices {

	public static void main(String[] args) {

		int m1[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; 
		int m2[][] =  {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
				
		imprimeMatriz(m1);
		System.out.println();
		imprimeMatriz(m2);
		System.out.println();
		imprimeMatriz(sumaMatriz(m1,m2));

		
		
	}
	
	public static int[][] sumaMatriz(int[][] m1, int[][] m2) {
		int m3[][] = new int[3][3];
		
		for (int i = 0; i < m3.length; i++) {
			for (int j = 0; j < m3[i].length; j++) {
				m3[i][j] = (m1[i][j] + m2[i][j]);
			}
		}
		return m3;
	}
	
	public static void imprimeMatriz (int [][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
}
