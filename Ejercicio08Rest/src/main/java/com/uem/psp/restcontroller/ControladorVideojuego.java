package com.uem.psp.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uem.psp.modelo.entidad.Videojuego;
import com.uem.psp.modelo.negocio.GestorVideojuego;

@RestController
public class ControladorVideojuego {
	
	@Autowired
	private GestorVideojuego gv;


	// metodos
	@PostMapping(path = "videojuegos", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> altaVideojuego(@RequestBody Videojuego v) {
		try {
			v = gv.crearActualizar(v);
			if(v != null)
				return new ResponseEntity<Videojuego>(v, HttpStatus.CREATED);
			else
				return new ResponseEntity<Videojuego>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Videojuego>(v, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(path = "videojuegos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> getVideojuego(@PathVariable("id") int id) {
		try {
			Videojuego v = gv.get(id);
			if(v == null) {
				return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<Videojuego>(v,HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Videojuego>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(path = "videojuegos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> listarVideojuegos(
			@RequestParam(name = "compania", required = false) String compania) {
		List<Videojuego> listaaux = null;
		if (compania == null) {
			listaaux = gv.listar();
		} else {
			listaaux = gv.listarPorCompañia(compania);
		}
		if(listaaux != null) {
			return new ResponseEntity<List<Videojuego>>(listaaux, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Videojuego>>(HttpStatus.NOT_FOUND);
		}
		

	}

	@PutMapping(path = "videojuegos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> modificarVideojuego(@PathVariable("id") int id, @RequestBody Videojuego v) {
		try {
			v.setId(id);
			v = gv.crearActualizar(v);
			if(v != null)
				return new ResponseEntity<Videojuego>(v, HttpStatus.OK);
			else
				return new ResponseEntity<Videojuego>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Videojuego>(v, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping(path = "videojuegos/{id}")
	public ResponseEntity<Videojuego> borrarVideojuego(@PathVariable("id") int id) {
		try {
			gv.eliminar(id);
			return new ResponseEntity<Videojuego>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Videojuego>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
} 

