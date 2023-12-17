package capitulo05.bloque01Herencia.coleccionAntiguedades;

public class Moneda extends Antiguedad {
	
	protected String metal;
	
	public Moneda() {
		super();
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("nombre: " +nombre + " ");
		sb.append("origen: " +origen + " ");
		sb.append("año de fabricación: " +anoFabricacion + " ");
		sb.append("material: " +metal);
		sb.append("precio: " +precio + "€ ");
		
		return sb.toString();
	}

	public String getMetal() {
		return metal;
	}

	public void setMetal(String metal) {
		this.metal = metal;
	}
	public void pideDatos() {
		
		this.nombre = Utils.Arrays.requestString("Escribe el nombre");
		this.anoFabricacion = Utils.Arrays.requestString("Escribe año de fabricación");
		this.origen = Utils.Arrays.requestString("Escribe el origen");
		this.metal = Utils.Arrays.requestString("Escribe su material");
		this.precio = Utils.Arrays.requestNumber("Escribe el precio");
	}
	

}
