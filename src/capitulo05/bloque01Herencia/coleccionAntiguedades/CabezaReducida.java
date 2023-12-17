package capitulo05.bloque01Herencia.coleccionAntiguedades;

public class CabezaReducida extends Antiguedad {
	
	protected String civilizacion;
	
	public CabezaReducida() {
		super();
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("nombre: " +nombre + " ");
		sb.append("origen: " +origen + " ");
		sb.append("año de fabricación: " +anoFabricacion + " ");
		sb.append("civilización: " +civilizacion + " ");
		sb.append("precio: " +precio + "€ ");
		
		return sb.toString();
	}

	public String getCivilizacion() {
		return civilizacion;
	}

	public void setCivilizacion(String civilizacion) {
		this.civilizacion = civilizacion;
	}

	public void pideDatos() {
		
		this.nombre = Utils.Arrays.requestString("Escribe el nombre");
		this.anoFabricacion = Utils.Arrays.requestString("Escribe año de fabricación");
		this.origen = Utils.Arrays.requestString("Escribe el origen");
		this.civilizacion = Utils.Arrays.requestString("Escribe su civilización de origen");
		this.precio = Utils.Arrays.requestNumber("Escribe el precio");

	}
}
