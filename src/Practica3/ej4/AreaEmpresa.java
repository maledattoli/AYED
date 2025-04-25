package Practica3.ej4;

public class AreaEmpresa {
	private int tiempo;
	private String id;
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AreaEmpresa( String id,int tiempo) {
		this.tiempo = tiempo;
		this.id = id;
	}
	public AreaEmpresa() {
	}
	
	
	
}
