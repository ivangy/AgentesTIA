package AgentesTIA;

public class Agentes {
	
	private String nombre;
	
	private int edad;
	
	private String direccion;
	
	private int salario;
	
	
	public Agentes (String nombre, int edad, String direccion, int salario) {
		
		super ();
		
		this.nombre = nombre;
		
		this.edad = edad;
		
		this.direccion = direccion;
		
		this.salario = salario;
		
	}


	public String getNombre() {
		return nombre;
	}	


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getSalario() {
		return salario;
	}


	public void setSalario(int salario) {
		this.salario = salario;
	}


	@Override
	public String toString() {
		return "Agentes [nombre=" + nombre + ", edad=" + edad + ", direccion=" + direccion + ", salario=" + salario
				+ "]";
	}
	
	
}
