package capitulo05.arkanoid;

public class Interfaz {

	public static void main(String[] args) {
		boolean playAgain = true;
	
		do {
			Juego juego = new Juego();
	
			System.out.println();
			
			
			juego.muestraEstadoActual();
			
			do {
				
				juego.crearPosicionPelota();
				juego.compruebeHit();
				
				//
				//juego.muestraEstadoActual();
				
				
			} while (juego.hayVivos() != false);
			
			System.out.println("El primero ladrillo destruido es: " +juego.ladrillosDestruido[0].getNombre() +" Y el último ladrillo destruido es: "+juego.ladrillosDestruido[juego.ladrillosDestruido.length-1].getNombre());
			if (Utils.Arrays.requestNumber("Quieres jugar otra vez? (1 por si, 0 por no)") == 0) {
				playAgain = false;
			}
		}while (playAgain ==true);
	}
}
