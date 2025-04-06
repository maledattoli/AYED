package Practica1.ejercicio7;



public class Estudiante extends Persona{

	
	public Estudiante(String nombre, String apellido, String email,int comision, String direccion) {
		super(nombre,apellido,email);
		this.comision = comision;
		this.direccion = direccion;
	}
	private int comision;
    
    private String direccion;
	
	public int getComision() {
		return comision;
	}
	public void setComision(int comision) {
		this.comision = comision;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String tusDatos() {
		return super.tusDatos()+ " comision: "+ this.getComision()+ " direccion: "+ this.getDireccion();
	}
}
