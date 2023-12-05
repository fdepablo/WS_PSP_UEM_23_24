package test;

import modelo.entidad.Pelicula;
import modelo.negocio.ServicioProxyPelicula;

public class ClienteTest {
	public static void main(String[] args) {
		// Solo sirve para probar que funciona alta y obtener la 
		// película desde el cliente.
		// Tiene que estar arrancado el servidor
		

		ServicioProxyPelicula spl = new ServicioProxyPelicula();
			
		Pelicula pelicula = spl.obtenerPorId(1);
		
		System.out.println("CLIENTE: pelicula: " + pelicula);
		
		pelicula = new Pelicula();
		pelicula.setId(5);
		pelicula.setDirector("Hermanos Marx");
		pelicula.setPrecio(20);
		pelicula.setTitulo("Los hermanos Marx en el oeste");
		
		boolean alta = spl.alta(pelicula);
		System.out.println("CLIENTE -> alta: " + alta);
		
	}
}
