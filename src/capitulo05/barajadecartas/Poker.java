package capitulo05.barajadecartas;

public class Poker {

	public static void main(String[] args) {


		
		Baraja baraja = new Baraja();
		baraja.muestraEstadoActual();
		
		Jugador[] jugadores = new Jugador[5];
			for (int i = 0; i < jugadores.length; i++) {
				jugadores[i] = new Jugador();
			}
				
		baraja.pasaCartaDebajoArriba();
//		baraja.pasaCartaArribaAbajo();
		
		baraja.mezclaCartas();
		baraja.muestraEstadoActual();
		
		baraja.ordenaCartas();
		baraja.muestraEstadoActual();
		
		baraja.mezclaCartas();
		
		reparteCartas(jugadores, baraja);
		
		buscaParejaTriPoker(jugadores);
		
	}

	public static void reparteCartas(Jugador[] jugadores, Baraja baraja) {
		int i = 0;
		for (int j = 0; j < jugadores.length; j++) {
			for (int k = 0; k < jugadores[j].getMano().length; k++) {
				jugadores[j].getMano()[k] = baraja.getCartas()[i];
				i++;	
			}
		}
	}
	
	public static void buscaParejaTriPoker(Jugador[] jugadores) {
		boolean hayGanador = false;

		int temp = 0;
		int count = 0;
		for (int i = 0; i < jugadores.length; i++) {
			Carta[] mano = jugadores[i].getMano();
			
			for (int j = 0; j < mano.length; j++) {
				temp = jugadores[i].getMano()[j].getCartaNumero();

				for (int k = 0; k < mano.length; k++) {
					if (jugadores[i].getMano()[j].getCartaNumero() == jugadores[i].getMano()[k].getCartaNumero() && j != k && jugadores[i].getMano()[k].getCartaNumero() != 0) {
						count++;
						jugadores[i].getMano()[k].setCartaNumero(0);
					}
				}
				
				if (count > 0) {
					hayGanador = true;
					if (count == 1) {
						System.out.println("par! " +jugadores[i].getnombre() +": " + toString(temp));
					}
					if (count == 2) {
						System.out.println("trio! " +jugadores[i].getnombre() +": " +toString(temp));
					}
					if (count == 3) {
						System.out.println("Poker! " +jugadores[i].getnombre() +": " +toString(temp));
					}
				}
				count = 0;

			}	
		}
		if (hayGanador == false) {
			System.out.println("No tiene nada Nadie");
		};
	}
	
	
	public static String toString(int temp) {
		StringBuffer sb = new StringBuffer();
		
		switch(temp) {
		case 1:
			sb.append("As");
			break;
		case 11:
			sb.append("J");
			break;
		case 12:
			sb.append("Q");
			break;
		case 13:
			sb.append("K");
			break;
		default:
			sb.append(temp);
		}
		
		return sb.toString();
		
	}
	
}
