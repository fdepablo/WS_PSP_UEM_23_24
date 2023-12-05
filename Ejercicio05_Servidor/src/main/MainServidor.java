package main;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import modelo.entidad.Pelicula;
import modelo.negocio.HiloPelicula;
import modelo.persistencia.DaoPelicula;

public class MainServidor {
	
	public static final int PUERTO = 2021;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("      APLICACIÓN DE SERVIDORA DE PELICULAS     ");
		System.out.println("--------------------------------------------");
		
		//Instanciamos el Dao de la app
		DaoPelicula daoPelicula = inicializarDaoPeliculas();
		
		Socket socketAlCliente = null;		
		InetSocketAddress direccion = new InetSocketAddress(PUERTO);

		try (ServerSocket serverSocket = new ServerSocket()){			

			serverSocket.bind(direccion);
			
			int peticion = 0;
			
			while(true){		
				
				System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);
				
				socketAlCliente = serverSocket.accept();
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");
				
				//El daoPelicula tiene todas las péliculas y debe ser compartido por
				//todos los hilos
				HiloPelicula hl = new HiloPelicula(daoPelicula, socketAlCliente);
				hl.start();				
			}
		} catch (IOException e) {
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error -> " + e);
			e.printStackTrace();
		}
	}//FIN DEL PROGRAMA

	private static DaoPelicula inicializarDaoPeliculas() {
		DaoPelicula daoPelicula = new DaoPelicula(new ArrayList<>());
		
		Pelicula p = new Pelicula();
		p.setId(1);
		p.setDirector("George Lucas");
		p.setTitulo("La guerra de las galaxias");
		p.setPrecio(25);
		
		daoPelicula.agregar(p);
		
		p = new Pelicula();
		p.setId(2);
		p.setDirector("Steven Spielberg");
		p.setTitulo("Jurasic Park");
		p.setPrecio(20);
		
		daoPelicula.agregar(p);
		
		p = new Pelicula();
		p.setId(3);
		p.setDirector("Amenabar");
		p.setTitulo("Tesis");
		p.setPrecio(18);
		
		daoPelicula.agregar(p);
		
		p = new Pelicula();
		p.setId(4);
		p.setDirector("Amenabar");
		p.setTitulo("Abre los ojos");
		p.setPrecio(19);
		
		daoPelicula.agregar(p);
		
		return daoPelicula;
	}

}
