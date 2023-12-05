package hilos;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca 3 numeros para saber si son primos");
		long[] numeros = new long[3];
		for(int i = 0; i < 3; i++) {
			numeros[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 3; i++) {			
			HiloPrimos hp = new HiloPrimos();
			hp.setNumero(numeros[i]);
			Thread th = new Thread(hp);
			th.start();
		}
		
	}
}
