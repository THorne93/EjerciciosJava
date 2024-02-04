package examenes.examen20240130.ej03;

public class Donna extends Object implements WeatherListener {

	public Donna () {
		Programa.addWeatherListener(this);
	}
	



	@Override
	public void lluviaAlSol(WeatherEvent e) {
		System.out.println("Soy Donna y ha dejado de llover. Ahora sale el sol!");
		
	}




	public void lluvia(WeatherEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

