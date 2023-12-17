package capitulo05.bloque01Herencia.coleccionAntiguedades;

public class Joya extends Antiguedad {
	
	protected String materialDeFabricacion;
	
	
	public Joya() {
		super();
	}

	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("nombre: " +nombre + " ");
		sb.append("origen: " +origen + " ");
		sb.append("año de fabricación: " +anoFabricacion + " ");
		sb.append("material: " +materialDeFabricacion + " ");
		sb.append("precio: " +precio + "€ " + " ");
		
		return sb.toString();
	}

	public String getMaterialDeFabricacion() {
		return materialDeFabricacion;
	}


	public void setMaterialDeFabricacion(String materialDeFabricacion) {
		this.materialDeFabricacion = materialDeFabricacion;
	}
	
	public void pideDatos() {
		
		this.nombre = Utils.Arrays.requestString("Escribe el nombre");
		this.anoFabricacion = Utils.Arrays.requestString("Escribe año de fabricación");
		this.origen = Utils.Arrays.requestString("Escribe el origen");
		this.precio = Utils.Arrays.requestNumber("Escribe el precio");
		this.materialDeFabricacion = Utils.Arrays.requestString("Escribe el material de fabricación");

	}

}
