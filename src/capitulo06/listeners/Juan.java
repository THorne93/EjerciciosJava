package capitulo06.listeners;

public class Juan extends Object implements MathListener {

	public Juan () {
		Programa.addMathListener(this);
	}
	

	@Override
	public void masDeMil(MathEvent e) {
		System.out.println("Soy Juan y tienes un número más de 1000");
		
	}

	@Override
	public void numeroNegativo(MathEvent e) {
		System.out.println("Soy Juan y tienes un número negativo");
		
	}

	@Override
	public void divisionZero(MathEvent e) {
		System.out.println("Soy Juan y has intentado dividir con 0");
		
	}

	@Override
	public void raizNegativo(MathEvent e) {
		System.out.println("Soy Juan has intentado buscar la raiz de un negativo");
		
	}

	@Override
	public void numeroIntroducido(MathEvent event) {
		// TODO Auto-generated method stub
		
	}
}
