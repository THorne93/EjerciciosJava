package capitulo05.bloque01Herencia.articulosComestibles;

public class ArticuloPerecedero extends Articulo {
	
	protected int fechaCaducidad;
	
	public ArticuloPerecedero() {
	
	}

	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("nombre: " +nombre + " ");
		sb.append("precio: " +precio + "€ ");
		sb.append("codigo: " +codigo + " ");
		sb.append("fecha de caducidad: " +fechaCaducidad);
		
		return sb.toString();
	}
	
	public int getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(int fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

}
