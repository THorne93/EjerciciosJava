package capitulo05.bloque01Herencia.coleccionAntiguedades;

public class Antiguedad {

	protected String nombre;
	protected double precio;
	protected String anoFabricacion;
	protected String origen;

	public Antiguedad() {

	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("nombre: " +nombre + " ");
		sb.append("origen: " +origen + " ");
		sb.append("año de fabricación: " +anoFabricacion + " ");
		sb.append("precio: " +precio + "€ ");
		
		return sb.toString();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAnoFabricacion() {
		return anoFabricacion;
	}

	public void setAnoFabricacion(String anoFabricacion) {
		this.anoFabricacion = anoFabricacion;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

	
	
}
