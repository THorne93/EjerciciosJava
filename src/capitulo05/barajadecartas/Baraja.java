package capitulo05.barajadecartas;

public class Baraja {
	private Carta[] cartas = new Carta[52];
	
	 public Baraja() {
		 for (int i = 0; i < cartas.length; i++) {
			cartas[i] = new Carta();
			cartas[i].setId(i);
			if( i < 13) {
				cartas[i].setCartaPalo("Picas");
			}
			if (i >=13 && i < 26) {
				cartas[i].setCartaPalo("Diamantes");
			}
			if (i >=26 && i < 39) {
				cartas[i].setCartaPalo("Tréboles");
			}
			if (i >=39 && i < 52) {
				cartas[i].setCartaPalo("Corazones");
			}
		}
		 int cartaNumero = 1;
		 for (int i = 0; i < cartas.length; i++) {
			cartas[i].setCartaNumero(cartaNumero);
			cartaNumero++;
			if (cartaNumero ==14) {
				cartaNumero =1;
			}
		}
		 System.out.println();
	 }
	 
	 public void pasaCartaDebajoArriba() {
			Carta temp = cartas[0];
			for (int i = 0; i < cartas.length-1; i++) {
				cartas[i] = cartas[i + 1];
			}
			cartas[cartas.length-1] = temp;		
	}
	
	 public void pasaCartaArribaAbajo() {
			Carta temp = cartas[cartas.length-1];
			for (int i = cartas.length-1; i > 0; i--) {
				cartas[i] = cartas[i - 1];
			}
			cartas[0] = temp;
	 }
	 
	 public void mezclaCartas() {
		 for (int i = 0; i < cartas.length; i++) {
				int azar1 = Utils.Arrays.getRandomNumber(0, cartas.length-1);
				int azar2 = Utils.Arrays.getRandomNumber(0, cartas.length-1);
				
				Carta aux = cartas[azar1];
				cartas[azar1] = cartas[azar2];
				cartas[azar2] = aux;
			}
	 }
	 
	 public void ordenaCartas() {
			boolean hayCambios = true;
			
			do {
				 hayCambios = false;
					for (int i = 0; i < cartas.length-1; i++) {
						if (cartas[i].getId() > cartas[i+1].getId()) {
							hayCambios = true;
							Carta temp = cartas[i+1];
							cartas[i+1] = cartas[i];
							cartas[i] = temp;
						}
					}
			} while (hayCambios == true);
	 }
}
