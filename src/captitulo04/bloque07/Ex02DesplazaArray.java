package captitulo04.bloque07;

import java.util.Iterator;

public class Ex02DesplazaArray {

	public static void main(String[] args) {

		int array[] = new int[10];
		int numCount = 1;
		int posInicial, posFinal, diferencia;

		for (int i = 0; i < array.length; i++) {
			array[i] = Utils.Arrays.requestNumber("Pon un número (" + numCount + ")");
			numCount++;
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(i + " - " + array[i] + ", ");
		}

		posInicial = Utils.Arrays.requestNumber("Que posicion incicial quieres?");
		posFinal = Utils.Arrays.requestNumber("Que posicion final quieres?");
		diferencia = (posFinal - posInicial + 1);

		int arrayTemp[] = new int[diferencia];
		int j = 0;

		for (int i = posInicial; i <= posFinal; i++) {
			arrayTemp[j] = array[i];
			j++;
		}

		int arrayMover[] = new int[array.length - diferencia];
		j = 0;
		for (int i = 0; i < posInicial; i++) {
			arrayMover[j] = array[i];
			j++;
		}
		for (int i = (posFinal + 1); i < array.length; i++) {
			arrayMover[j] = array[i];
			j++;
		}

		Utils.Arrays.desplazaCiclicoDerechaNew(arrayMover, 1);

		j = 0;
		int moverPosicion = 0;

		for (int i = 0; i < posInicial; i++) {
			array[j] = arrayMover[i];
			j++;
			moverPosicion++;
		}

//		
		for (int i = 0; i < arrayTemp.length; i++) {
			array[j] = arrayTemp[i];
			j++;
		}

//		
		for (int i = moverPosicion; i < arrayMover.length; i++) {
			array[j] = arrayMover[i];
			j++;
		}
		System.out.println();
//		
		for (int i = 0; i < array.length; i++) {
			System.out.print(i + " - " + array[i] + ", ");
		}
	}

}
