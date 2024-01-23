package com.uem.psp.entidad;

import org.springframework.stereotype.Component;

@Component
public class EntidadBancaria {
	private int id;
	private String numeroCuenta = "ISB45666";
	private double saldo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "EntidadBancaria [id=" + id + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + "]";
	}
	
	
}
