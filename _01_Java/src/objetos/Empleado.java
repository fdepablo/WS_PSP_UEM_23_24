package objetos;

public class Empleado extends Persona{
	private double salario;

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [salario=" + salario + ", getNombre()=" + getNombre() + ", getEdad()=" + getEdad()
				+ ", getPeso()=" + getPeso() + "]";
	}


	
	
}
