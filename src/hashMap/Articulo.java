package hashMap;


public class Articulo {

	private String codigo;
	private String numeroEstante;
	private Integer cantidad;
	
	public Articulo() {
		super();
		
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNumeroEstante() {
		return numeroEstante;
	}

	public void setNumeroEstante(String numeroEstante) {
		this.numeroEstante = numeroEstante;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		return "Articulo [Codigo=" + codigo + ", Numero de estante=" + numeroEstante + ", Cantidad=" + cantidad + "]";
	}

}
