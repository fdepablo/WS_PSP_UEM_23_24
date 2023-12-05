package modelo.negocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entidad.Pelicula;

public class ServicioProxyPelicula {
	
	// IP y Puerto a la que nos vamos a conectar
	public static final int PUERTO = 2021;
	public static final String IP_SERVER = "localhost";

	public Pelicula obtenerPorId(int id) {
		String textoEnvio = "1-" + id; 
		String textoRespuesta = conexionServidorRemoto(textoEnvio);
		Pelicula Pelicula = deserializarPelicula(textoRespuesta);
		return Pelicula;
	}
	
	public Pelicula obtenerPorTitulo(String titulo) {
		String textoEnvio = "2-" + titulo; 
		String textoRespuesta = conexionServidorRemoto(textoEnvio);
		Pelicula Pelicula = deserializarPelicula(textoRespuesta);
		return Pelicula;
	}
	
	public List<Pelicula> obtenerPorDirector(String director) {
		String textoEnvio = "3-" + director; 
		String textoRespuesta = conexionServidorRemoto(textoEnvio);
		List<Pelicula> listaPeliculas = deserializarPeliculas(textoRespuesta);
		return listaPeliculas;
	}
	
	public boolean alta(Pelicula Pelicula) {
		String textoEnvio = "4-" + Pelicula.getId() + "-" + Pelicula.getTitulo() +
				"-" + Pelicula.getDirector() + "-" + Pelicula.getPrecio(); 
		String textoRespuesta = conexionServidorRemoto(textoEnvio);
		return Boolean.parseBoolean(textoRespuesta);
	}
	
	
	private String conexionServidorRemoto(String textoEnvio) {
		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		try {

			Socket socketAlServidor = new Socket();
			socketAlServidor.connect(direccionServidor);
			System.out.println("CLIENTE: Esperando a que el servidor acepte la conexión");
			System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER 
					+ " por el puerto " + PUERTO);	
			
			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
			
			salida.println(textoEnvio);

			System.out.println("CLIENTE: Esperando al resultado del servidor...");	
			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
			BufferedReader bf = new BufferedReader(entrada);
			String textoRespuesta = bf.readLine();				
				
			socketAlServidor.close();		
			
			return textoRespuesta;
		}catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la dirección" + IP_SERVER);
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
			return null;
		}
	}
	
	private Pelicula deserializarPelicula(String sPelicula) {
		if(sPelicula.equals("")) {
			return null;
		}
		String[] datos = sPelicula.split("-");
		
		Pelicula Pelicula = new Pelicula();
		Pelicula.setId(Integer.parseInt(datos[0]));
		Pelicula.setTitulo(datos[1]);
		Pelicula.setDirector(datos[2]);
		String sPrecio = datos[3];
		double precio = Double.parseDouble(sPrecio);
		Pelicula.setPrecio(precio);
		
		return Pelicula;
	}
	
	private List<Pelicula> deserializarPeliculas(String sListaPeliculas){
		if(sListaPeliculas.equals("")) {
			return null;
		}
		
		List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
		String[] arrayPeliculas = sListaPeliculas.split("_");
		for(String Pelicula : arrayPeliculas) {
			String[] sPelicula = Pelicula.split("-");
			Pelicula p = new Pelicula();
			p.setId(Integer.parseInt(sPelicula[0]));
			p.setTitulo(sPelicula[1]);
			p.setDirector(sPelicula[2]);
			p.setPrecio(Double.parseDouble(sPelicula[3]));
			
			listaPeliculas.add(p);
		}
		
		return listaPeliculas;
	}
}
