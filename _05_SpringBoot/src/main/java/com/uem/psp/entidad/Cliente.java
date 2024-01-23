package com.uem.psp.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cliente {
	private int id;
	private String dni;
	
	@Autowired
	private EntidadBancaria entidadBancaria;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public EntidadBancaria getEntidadBancaria() {
		return entidadBancaria;
	}
	public void setEntidadBancaria(EntidadBancaria entidadBancaria) {
		this.entidadBancaria = entidadBancaria;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", dni=" + dni + ", entidadBancaria=" + entidadBancaria + "]";
	}
	
	
}
