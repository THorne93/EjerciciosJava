package capitulo06.listeners;

public interface MathListener {

	public void masDeMil(MathEvent e);
	
	public void numeroNegativo(MathEvent e);
	
	public void divisionZero(MathEvent e);
	
	public void raizNegativo(MathEvent e);

	public void numeroIntroducido(MathEvent event);
}
