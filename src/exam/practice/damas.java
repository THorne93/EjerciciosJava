package exam.practice;

public class damas {

	public static void main(String[] args) {
		
		char damas[][] = new char[10][10];
		
		imprimeDamas(crearDamas(damas));
		
	}	
	public static char[][] crearDamas (char[][] damas){
		

		int count = 1;

		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < damas[i].length; j++) {
				if (count % 2 == 0) {
					damas[i][j] = 49;
				} else
					damas[i][j] = 48;
				count++;
			}
			count++;
		}
		
		for (int i = 4; i < 6; i++) {
			for (int j = 0; j < damas[i].length; j++) {
				damas[i][j] = 48;
			}
		}

		for (int i = 6; i < damas.length; i++) {

			for (int j = 0; j < damas[i].length; j++) {
				if (count % 2 == 0) {
					damas[i][j] = 49;
				} else
					damas[i][j] = 48;
				count++;
			}
			count++;
		}
		
		return damas;
	
	}

	public static char[][] imprimeDamas  (char[][] damas){
		for (int i = 0; i < damas.length; i++) {
			for (int j = 0; j < damas[i].length; j++) {
				System.out.print(damas[i][j] + " ");
			}
			System.out.println();
		}
		return damas;
	}
	

}
