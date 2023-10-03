package objetos;

import java.util.ArrayList;
import java.util.List;

public class MainObjetos {

	public static void main(String[] args) {
		int numero = 5;
		// TODO Auto-generated method stub
		
		new Persona();
		
		Persona p1 = new Persona();
		Object o = p1;
		
		p1.setEdad(44);
		
		var p2 = p1;
		p2.setEdad(55);
		
		//55 55 /  44 55
		System.out.println(p1.getEdad());
		System.out.println(p2.getEdad());
		
		numero = 10;
		
		p1 = null;
		
		int numero2 = 20;
		
		numero2 = numero;
		numero2 = 100;
		
		System.out.println(numero);
		System.out.println(numero2);
		
		Persona p4 = null;
		{
			Persona p3 = new Persona();
			p3.setNombre("illojuan");
			
			cambiarNombre(p3);
			System.out.println(p3.getNombre());
			p4 = p3;
		}//La referencia p3 va a morir :(
		
		//p3.setNombre("fe");
		
		List<Persona> listaPersonas = new ArrayList<>();
		Persona p5 = new Persona();
		listaPersonas.add(p5);
		
		p5.setNombre("Ibai");
	
		System.out.println(listaPersonas);
		
		listaPersonas.add(p4);
		
		listaPersonas.get(0).setNombre("Tomasin");
		System.out.println(p5.getNombre());
		
		p5 = p4;//he perdido a ibai
		listaPersonas.get(1).setNombre("Ana la loca");
		System.out.println(p5.getNombre());
		
		listaPersonas = null;
		
		int n = 0b101;
		System.out.println(n);
		int n2 = 0xF;
		System.out.println(n2);
		int cp = 05100;
		System.out.println(cp);
		
		Persona p6 = new Persona();
		Direccion d1 = new Direccion();
		p6.setDireccion(d1);
		p6.getDireccion().setCp("28224");
		System.out.println(p6.getDireccion().getCp());
		
		d1.setNombreVia("Gran via");
		System.out.println(p6.getDireccion().getNombreVia());
		
		String cad1 = "hola";
		cad1 = "adios";
		cad1 = cad1 + " pepe";
		
		String cad2 = "felix";
		String cad3 = "felix";
		System.out.println(cad2 == cad3);
		
		String cad4 = new String("felix");
		String cad5 = new String("felix");
		System.out.println(cad4 == cad5);
		
		System.out.println(cad2 == cad5);
		
		System.out.println(cad2.equals(cad3));
		System.out.println(cad4.equals(cad5));
		System.out.println(cad2.equals(cad5));
		
		MainObjetos mo = new MainObjetos();
		mo.metodo1();
		
		Empleado em1 = new Empleado();
		em1.setNombre("Currito");
		System.out.println(em1.toString());
		
		Persona p7 = new Empleado();
		//p7 = new Bebe();
		em1 = (Empleado)p7;
		em1.setSalario(34444);
		
		Persona e2 = new Empleado();
		e2.setNombre("Ibai");
		e2.setEdad(34);
		System.out.println(e2);
		
		Object o2 = new Persona();
		o2 = new ArrayList<>();
		o2 = 5;
	}
	
	public void metodo1() {
		System.out.println("Hola :)");
	}
	
	public static void cambiarNombre(Persona p) {
		p.setNombre("Nekro");
	}
	
	public static void cambiarNombre(Persona p, Persona p2) {

	}
	
	public static void cambiarNombre() {

	}

	public static void cambiarNombre(int n1) {

	}
	
	/*
	public static String cambiarNombre(int n1) {

	}*/
}
