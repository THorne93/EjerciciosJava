package examenes.examen20231123;

public class Ex03_SumaElementosDiagonal {

	public static void main(String[] args) {

		int m[][] = new int[2][2];
		
		rellenaMatriz(m);
		imprimeMatriz(m);
		System.out.println("La suma de los elementos diagonal secundaria es: " +sumaElementos(m));
		
		
		
	}
	private static int sumaElementos (int m[][]){
		int suma = 0;
		
		for (int i = m.length-1, j = 0; i > 0 || j < m.length; i--, j++) {
			suma += m[i][j];
		}
		
		return suma;
	}
	
	private static void imprimeMatriz(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	private static void rellenaMatriz(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = (int) Math.round(Math.random() * 100);

			}
		}
	}
}
