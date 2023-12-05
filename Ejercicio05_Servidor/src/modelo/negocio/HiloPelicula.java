package modelo.negocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

import modelo.entidad.Pelicula;
import modelo.persistencia.DaoPelicula;

public class HiloPelicula extends Thread {
	private DaoPelicula daoPelicula;
	private Socket socketAlCliente;
	
	public HiloPelicula(DaoPelicula daoPelicula, Socket socketAlCliente) {
		this.daoPelicula = daoPelicula;
		this.socketAlCliente = socketAlCliente;
	}

	@Override
	public void run() {
		PrintStream salida = null;
		InputStreamReader entrada = null;
		BufferedReader entradaBuffer = null;
		
		try {
			//Salida del servidor al cliente
			salida = new PrintStream(socketAlCliente.getOutputStream());
			//Entrada del servidor al cliente
			entrada = new InputStreamReader(socketAlCliente.getInputStream());
			entradaBuffer = new BufferedReader(entrada);
			
			String texto = "";			

			texto = entradaBuffer.readLine();

			//Vamos a tener 4 tipos de ordenes diferentes
			//1- Consultar pelicula por id (1-345)
			//2- Consultar pelicula por titulo (2-El se�or de las moscas)
			//3- Consultar peliculas por director (3-tolkien)
			//4- Alta pelicula (4-1234-matrix-hermanos güasoski-20)

			String[] datos = texto.split("-");
			String codigoPeticion = datos[0];
			String textoRespuesta = "";
			Pelicula pelicula = null;
			
			switch (codigoPeticion) {
			case "1":
				int id = Integer.parseInt(datos[1]);
				pelicula = daoPelicula.buscarPorId(id);
				textoRespuesta = serializarPelicula(pelicula);
				break;
			case "2":
				String titulo = datos[1];
				pelicula = daoPelicula.buscarPorTitulo(titulo);
				textoRespuesta = serializarPelicula(pelicula);		
				break;
			case "3":
				String director = datos[1];
				List<Pelicula> listaPeliculas = daoPelicula.buscarPorDirector(director);
				textoRespuesta = serializarPelicula(listaPeliculas);
				break;
			case "4":
				pelicula = deserializarPelicula(datos);
				boolean respuesta = daoPelicula.agregar(pelicula);
				System.out.println("SERVIDOR: Actualizada lista de películas:");
				System.out.println(daoPelicula.listar());
				textoRespuesta = String.valueOf(respuesta);
				break;
			default:
				textoRespuesta = "0";
				break;
			}
			
			salida.println(textoRespuesta);
			
			//Cerramos el socket
			socketAlCliente.close();
		} catch (IOException e) {
			System.err.println("HiloContadorLetras: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("HiloContadorLetras: Error");
			e.printStackTrace();
		}
	}
	
	private Pelicula deserializarPelicula(String[] datos) {
		Pelicula pelicula = new Pelicula();
		pelicula.setId(Integer.parseInt(datos[1]));
		pelicula.setTitulo(datos[2]);
		pelicula.setDirector(datos[3]);
		String sPrecio = datos[4];
		double precio = Double.parseDouble(sPrecio);
		pelicula.setPrecio(precio);
		
		return pelicula;
	}

	/**
	 * Metodo que serializa una lista de peliculas con el siguiente formato
	 * ID-TITULO-DIRECTOR-PRECIO*ID-TITULO-DIRECTOR-PRECIO_ID-TITULO-DIRECTOR-PRECIO..
	 * @param listaPeliculas
	 * @return String con el formato ID-TITULO-DIRECTOR-PRECIO_ID-TITULO-DIRECTOR-PRECIO*ID-TITULO-DIRECTOR-PRECIO..
	 */
	private String serializarPelicula(List<Pelicula> listaPeliculas) {
		if(listaPeliculas.isEmpty()) {
			return "";
		}
		String peliculasSerializadas = "";
		for(Pelicula p : listaPeliculas) {
			peliculasSerializadas+=serializarPelicula(p);
			peliculasSerializadas+="_";
		}
		//Eliminamos el ultimo "_"
		String peliculasSerializadasFinales = 
				peliculasSerializadas.substring(0, peliculasSerializadas.length() - 1);
		return peliculasSerializadasFinales;
	}

	/**
	 * Metodo que serializa una pelicula con el siguiente formato:
	 * ISBN-TITULO-AUTOR-PRECIO
	 * @param pelicula el libro a serializar
	 * @return string con el formato "ID-TITULO-DIRECTOR-PRECIO"
	 */
	public String serializarPelicula(Pelicula pelicula) {
		if(pelicula == null) {
			return "";
		}
		String peliculaSerializada = "";
		peliculaSerializada+=pelicula.getId();
		peliculaSerializada+="-";
		peliculaSerializada+=pelicula.getTitulo();
		peliculaSerializada+="-";
		peliculaSerializada+=pelicula.getDirector();
		peliculaSerializada+="-";
		peliculaSerializada+=pelicula.getPrecio();
		return peliculaSerializada;
	}
}
