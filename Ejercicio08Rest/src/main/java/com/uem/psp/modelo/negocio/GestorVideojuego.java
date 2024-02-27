package com.uem.psp.modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uem.psp.modelo.entidad.Videojuego;
import com.uem.psp.modelo.persistencia.VideojuegoDao;

@Service
public class GestorVideojuego {

	@Autowired
	private VideojuegoDao vDao;
	
	public Videojuego crearActualizar(Videojuego v) {
		if(v.getNombre().isEmpty()) {
			return null;
		}
		return vDao.save(v);
	}
	
	public void eliminar(int id) {
		vDao.deleteById(id);
	}
	
	public List<Videojuego> listar() {
		return vDao.findAll();
	}
	
	public List<Videojuego> listarPorCompañia(String compa){
		return vDao.findByCompania(compa);
	}
	
	public Videojuego get(int id){
		Optional<Videojuego> opV;
		opV = vDao.findById(id);
		if(opV.isPresent()){
			return opV.get();
		}else {
			return null;
		}
	}
}
