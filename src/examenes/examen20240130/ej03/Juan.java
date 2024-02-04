package examenes.examen20240130.ej03;

public class Juan extends Object implements WeatherListener {

	public Juan () {
		Programa.addWeatherListener(this);
	}
	

	@Override
	public void lluvia(WeatherEvent e) {
		System.out.println("Soy Juan y esta lloviendo!!!");
		
	}

	public void lluviaAlSol(WeatherEvent e) {
		// TODO Auto-generated method stub
		
	}



	
}


