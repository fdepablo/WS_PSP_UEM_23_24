package vista;

import java.util.List;
import java.util.Scanner;

import modelo.entidad.Pelicula;
import modelo.negocio.ServicioProxyPelicula;

public class ClientePelicula {
	
	private Scanner sc; 
	private ServicioProxyPelicula spp;
	
	//Nos creamos un método dinamico, prefiero evitar lo estatico en la medida
	//de lo posible
	public void arrancarApp() {
		// Arrancar el servidor y probar que funciona alta y obtener la pelicula
		
		System.out.println("Bienvenidos a nuestra app de gestión de películas");
		System.out.println("-------------------------------------------------");
		
		//inicializamos los objetos y las variables
		sc = new Scanner(System.in); 
		spp = new ServicioProxyPelicula();
		int opcion = 0;
		Pelicula pelicula = null;
		List<Pelicula> listaPeliculas = null;
		
		//Ejecutamos el programa mientras la opción sea distinta de 5
		do {
			opcion = mostrarMenu();
			switch (opcion) {
			case 1:
				System.out.println("Introduzca el ID de la película a buscar");
				int id = recogerEntero();
				pelicula = spp.obtenerPorId(id);
				mostrarResultado(pelicula);
				break;
			case 2:
				System.out.println("Introduzca el título de la película a buscar");
				String titulo = sc.nextLine();
				pelicula = spp.obtenerPorTitulo(titulo);
				mostrarResultado(pelicula);
				break;
			case 3:
				System.out.println("Introduzca el director de las películas a buscar");
				String director = sc.nextLine();
				listaPeliculas = spp.obtenerPorDirector(director);
				if(listaPeliculas != null) {
					for(Pelicula p : listaPeliculas) {
						mostrarResultado(p);
					}
				}else {
					System.out.println("No hay coincidencias");
				}
				break;
			case 4:
				pelicula = pedirDatosPelicula();
				boolean correcto = spp.alta(pelicula);
				System.out.println("Alta película: " + correcto);
				break;
			case 5:
				System.out.println("Saliendo del programa");
				break;
			default:
				System.out.println("Opcion no reconocida, opciones válidas 1-5");
				break;
			}
		}while(opcion != 5);
	}

	private Pelicula pedirDatosPelicula() {
		Pelicula p = new Pelicula();
		System.out.println("Introduzca el ID de la película");
		int id = recogerEntero();
		//TODO
		p.setId(id);
		System.out.println("Introduzca el título de la película");
		String titulo = sc.nextLine();
		p.setTitulo(titulo);
		System.out.println("Introduzca el director de la pélicula");
		String director = sc.nextLine();
		p.setDirector(director);
		System.out.println("Introduzca el precio de la película");
		int precio = recogerEntero();
		p.setPrecio(precio);
		
		return p;
	}

	private void mostrarResultado(Pelicula pelicula) {
		System.out.println("Pelicula: " + pelicula);		
	}

	private int mostrarMenu() {
		int opcion = 0;
		System.out.println();
		System.out.println("1- Consultar película por ID");
		System.out.println("2- Consultar película por título");
		System.out.println("3- Consultar película por director");
		System.out.println("4- Añadir película");
		System.out.println("5- Salir de la aplicación");
		System.out.println();
		
		//Para evitar problemas con la clase escaner recogemos 
		opcion = recogerEntero();
		return opcion;
	}
	
	/**
	 * Método que recoge por teclado un entero como String y lo convierte a int
	 * Hacemos esto para evitar posibles problemas con la clase Scanner
	 * al mezclar cadenas con enteros
	 * @return el número recogido por teclado como entero convertido a String
	 */
	private int recogerEntero() {
		int n = Integer.parseInt(sc.nextLine());
		return n;
	}
	
}
