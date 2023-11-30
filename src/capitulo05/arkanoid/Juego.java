package capitulo05.arkanoid;

public class Juego {
	private Ladrillo[] ladrillos = new Ladrillo[20];
	private Pelota pelota = new Pelota();
	public String[] colores = {"rojo","verde","azul"};
	public String[] coloresEspecial = {"plateado","dorado"};
	public Ladrillo[] ladrillosDestruido = new Ladrillo[20];
	int numeroDestruido = 0;
	
	public Juego() {
		for (int i = 0; i < ladrillos.length; i++) {

			ladrillos[i] = new Ladrillo();
			ladrillos[i].setNombre("Ladrillo-" +i);
				if (ladrillos[i].getPuntosVida() == 1) {
					ladrillos[i].setColor(colores[Utils.Arrays.getRandomNumber(0, 2)]);
				}
			
				else ladrillos[i].setColor(coloresEspecial[ladrillos[i].getPuntosVida()-2]);
		}
		System.out.println();
	}
	
	public Pelota getPelota() {
		return pelota;
	}
	
	public Ladrillo[] getLadrillo() {
		return ladrillos;
	}
	
	public boolean hayVivos() {
		for (int i = 0; i < ladrillos.length; i++) {
			if (ladrillos[i].isVivo() == true) {
				return true;
			}
		}
	return false;
	}
	
	public void muestraEstadoActual () {
		for (int i = 0; i < ladrillos.length; i++) {
			if (ladrillos[i].getPuntosVida() > 0) {
				System.out.print(ladrillos[i] + " - ");
			}
		}
		System.out.println();

	}
	
	public void crearPosicionPelota() {
		pelota.setX(Utils.Arrays.getRandomNumber(0, 800));
		pelota.setY(Utils.Arrays.getRandomNumber(0, 500));
	}
	
	public void compruebeHit() {
		int pelotaX = pelota.getX();
		int pelotaY = pelota.getY();
		
		for (int i = 0; i < ladrillos.length; i++) {
			if (pelotaX > ladrillos[i].getX() && pelotaX < (ladrillos[i].getX() + ladrillos[i].getAncho()) &&
					pelotaY > ladrillos[i].getY() && pelotaY < (ladrillos[i].getY() + ladrillos[i].getAlto()) && ladrillos[i].isVivo()) {
						ladrillos[i].quitaPuntos();
						if (ladrillos[i].getPuntosVida() == 0) {
							ladrillosDestruido[numeroDestruido] = ladrillos[i];
							numeroDestruido++;
						}
						System.out.println("STRIKE");
						muestraEstadoActual();

					}

		}
	}
	
	
}
