package hilos;

public class HiloPrimos implements Runnable{

	private long numero;
	
	@Override
	public void run() {
		long t1 = System.currentTimeMillis();
		
		boolean primo = esPrimo(numero);
		if(primo) {
			System.out.println("Es primo: " + numero);
		}else {
			System.out.println("No es primo " + numero);
		}
		
		long t2 = System.currentTimeMillis();
		long tt = t2 -t1;
		System.out.println("El tiempo total ded calculo del numero: + " 
					+ numero + " ha sido " + tt);
		
	}
	
	/**
	 * 
	 * @param numero
	 * @return
	 */
	private boolean esPrimo(long numero) {
		for(int i = 2;i < numero /2 ;i++) {
			if(numero % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public void setNumero(long numero) {
		this.numero = numero;
	}
}
