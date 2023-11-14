package captitulo04.bloque07;

public class Ex05CasillasSaltarAlfil {

	public static void main(String[] args) {

		char aljadrez[][] = new char[9][9];
		int count = 0;

		for (int i = 0; i < aljadrez.length; i++) {
			for (int j = 0; j < aljadrez[i].length; j++) {
				if (count % 2 == 0) {
					aljadrez[i][j] = 9633;
				} else
					aljadrez[i][j] = 9632;
				count++;
			}
		}

		for (int i = 0; i < aljadrez.length; i++) {
			aljadrez[i][0] = (char) (48 + i);
		}
		for (int i = 1; i < aljadrez.length; i++) {
			aljadrez[0][i] = (char) (64 + i);
		}
		aljadrez[0][0] = 9636;

		for (int i = 0; i < aljadrez.length; i++) {
			for (int j = 0; j < aljadrez[i].length; j++) {
				System.out.print(aljadrez[i][j] + " ");
			}
			System.out.println();
		}

		int posicionColumnaReal = 0;
		int mark, markLow = 0;
		String pos = Utils.Arrays.requestString("Diga la columna (a-h)");
		char posColumna = pos.charAt(0);

		if (posColumna == 97)
			posicionColumnaReal = 1;
		if (posColumna == 98)
			posicionColumnaReal = 2;
		if (posColumna == 99)
			posicionColumnaReal = 3;
		if (posColumna == 100)
			posicionColumnaReal = 4;
		if (posColumna == 101)
			posicionColumnaReal = 5;
		if (posColumna == 102)
			posicionColumnaReal = 6;
		if (posColumna == 103)
			posicionColumnaReal = 7;
		if (posColumna == 104)
			posicionColumnaReal = 8;

		int posicionFila = Utils.Arrays.requestNumber("Diga la fila (1-8)");

		if (posicionFila > posicionColumnaReal) {
			mark = posicionFila;
			markLow = posicionColumnaReal;
		} else {
			mark = posicionColumnaReal;
			markLow = posicionFila;
		}
		for (int i = 0; mark + i < aljadrez.length; i++) {
			aljadrez[posicionFila + i][posicionColumnaReal + i] = 88;
		}

		for (int i = 0; markLow - i > 0; i++) {
			aljadrez[posicionFila - i][posicionColumnaReal - i] = 88;
		}

		for (int i = 0; i < aljadrez.length; i++) {
			if ((posicionFila + i) < aljadrez.length && (posicionColumnaReal - i) > 0)
				aljadrez[posicionFila + i][posicionColumnaReal - i] = 88;
		}
		for (int i = 0; i < aljadrez.length; i++) {
			if ((posicionColumnaReal + i) < aljadrez.length && (posicionFila - i) > 0)
				aljadrez[posicionFila - i][posicionColumnaReal + i] = 88;
		}

		aljadrez[posicionFila][posicionColumnaReal] = 9711;
		System.out.println("Las posiciones posibles son: ");
		for (int i1 = 0; i1 < aljadrez.length; i1++) {
			for (int j = 0; j < aljadrez[i1].length; j++) {
				System.out.print(aljadrez[i1][j] + " ");
			}
			System.out.println();
		}

	}

}
