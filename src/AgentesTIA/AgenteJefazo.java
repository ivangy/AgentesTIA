package AgentesTIA;
/**
 * 
 * @author Ivan Sanchez
 * @author Gil Pablo Blanco
 *
 */
public final class AgenteJefazo extends Agentes{
	
	private int anos_mandato;

	public AgenteJefazo(String nombre, int edad, String direccion, float salario, int anos_mandato) {
		super(nombre, edad, direccion, salario);
		this.anos_mandato = anos_mandato;
	}

	public int getAnos_mandato() {
		return anos_mandato;
	}

	public void setAnos_mandato(int anos_mandato) {
		this.anos_mandato = anos_mandato;
	}

	@Override
	public String toString() {
		return 	"********************************"+ "\n"+
				"nombre= " + super.nombre + "\n"+
				"edad= " + super.edad + "\n"+
				"dirección= " + super.direccion + "\n"+ 
				"salario= " +super.salario + "€" + "\n"+
				"anos_mandato= " + anos_mandato + "\n"+
				"********************************";
	}
	
	
	
	

}
