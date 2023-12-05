package modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Pelicula;

/**
 * Esta clase simula un acceso a BBDD donde deberían estan guardadas las películas
 * 
 * Realmente están almacenadas en una lista en memoria
 * 
 * @author Félix
 *
 */
public class DaoPelicula {
	private List<Pelicula> listaPeliculas;
	
	public DaoPelicula(List<Pelicula> listaPeliculas){
		this.listaPeliculas = listaPeliculas;
	}

	public Pelicula buscarPorId(int id) {
		Pelicula pelicula = null;
		
		for(Pelicula p : listaPeliculas) {
			if(p.getId() == id) {
				pelicula = p;
				break;
			}
		}
		
		return pelicula;
	}
	
	public Pelicula buscarPorTitulo(String titulo) {
		Pelicula pelicula = null;
		
		for(Pelicula p : listaPeliculas) {
			if(p.getTitulo().equalsIgnoreCase(titulo)) {
				pelicula = p;
				break;
			}
		}
		
		return pelicula;
	}
	
	public List<Pelicula> buscarPorDirector(String director) {
		List<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
		
		for(Pelicula p : this.listaPeliculas) {
			if(p.getDirector().equalsIgnoreCase(director)) {
				listaPeliculas.add(p);
			}
		}
		
		return listaPeliculas;
	}
	
	//Lo hacemos sincronizado para evitar que varios hilos entren a la vez
	public synchronized boolean agregar(Pelicula p) {
		return listaPeliculas.add(p);
	}
	
	public List<Pelicula> listar(){
		return this.listaPeliculas;
	}
}
