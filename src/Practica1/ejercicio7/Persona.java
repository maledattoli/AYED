package Practica1.ejercicio7;

public abstract class Persona {
	
	public Persona(String nombre, String apellido, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	private String nombre;
    private String apellido;
    private String email;
    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    public String tusDatos() {
    	return "Tus datos son apellido: " + this.getApellido() + " nombre: "+ this.getNombre()+" email: "+ this.getEmail();
    }
}
