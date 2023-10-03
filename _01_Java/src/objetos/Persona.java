package objetos;

//JAvaBean es una estructura muy usada en JAVA
//Son atributos privados con getter y setters publicos
public class Persona {
	private String nombre;
	private int edad;
	private double peso;
	
	static int numeropPersona = 0;
	
	//Asociacion
	
	//Cuando la dependecia de persona con direccion
	//es fuerte, se considera Composicion
	//Cuanod la dependecia de persona con direccion
	//es debir, se considera agregación
	
	//Dependecia fuerte es si exite la persona
	//tiene que existir la direccion
	//Dependecia debil es si existe la persona
	//puede existir o no la direccion
	private Direccion direccion;
	
	
	
	public Persona() {
		super();
	}
	public Persona(String nombre, int edad, double peso, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.direccion = direccion;
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
}
