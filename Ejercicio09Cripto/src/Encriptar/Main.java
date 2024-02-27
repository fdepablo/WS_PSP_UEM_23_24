package Encriptar;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Scanner sc = new Scanner(System.in);
		byte[] bytesMensajeCifrado = null;
		byte[] bytesMensajeOriginal = null;
		SecretKey paloEspartano = null;
		String mensajeOriginal = null;
		
		int opcion = 1;
		while(opcion!=4) {
			System.out.println("Por favor usuario, introduzca un numero del 1 al 4 para seleccionar una opcion ");

			System.out.println("1. Encriptar frase\r\n" + "2. Mostrar frase encriptada\r\n" + "3. Desencriptar frase\r\n"
					+ "4. Salir del programa");
			opcion = Integer.parseInt(sc.nextLine());
			if (opcion == 1) {
				try {
					KeyGenerator generador = KeyGenerator.getInstance("AES");
					System.out.println("Paso 1: Se ha obtenido el generador de claves");
					paloEspartano = generador.generateKey();
					System.out.println("Paso 2: Se ha obtenido la clave");
					Cipher cifrador = Cipher.getInstance("AES");
					System.out.println("Paso 3: Hemos obtenido el cifrador/descifrador");
					cifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);
					System.out.println("Paso 4: Hemos configurado el cifrador");
					System.out.print("Introduzca el mensaje a cifrar: ");
					mensajeOriginal = sc.nextLine();
					bytesMensajeOriginal = mensajeOriginal.getBytes();
					System.out.println("Paso 5.1: Ciframos el mensaje original");
					bytesMensajeCifrado = cifrador.doFinal(bytesMensajeOriginal);
					System.out.println("**********************************************");

				} catch (GeneralSecurityException gse) {
					System.out.println("Algo ha fallado.." + gse.getMessage());
					gse.printStackTrace();
				}
			}
			else if (opcion == 2) {
				if(bytesMensajeCifrado!=null) {
				String mensajeCifrado = new String(bytesMensajeCifrado);
				System.out.println("Paso 5.2: Mensaje Original: " + mensajeOriginal);
				System.out.println("Paso 5.3: Mensaje Cifrado: " + mensajeCifrado);
				System.out.println("**********************************************");

				} else {
					System.out.println("Por favor, seleccione primero el 1 para encriptar una frase");
					System.out.println("**********************************************");

				}

			}
			else if (opcion == 3) {
				if(bytesMensajeCifrado!=null) {
				System.out.println("Paso 6.1: Desciframos el criptograma:");
				Cipher descifrador = Cipher.getInstance("AES");
				descifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
				byte[] bytesMensajeDescifrado = descifrador.doFinal(bytesMensajeCifrado);
				System.out.println("Paso 6.2: Mensaje Descifrado: " + new String(bytesMensajeDescifrado));
				System.out.println("**********************************************");

				} else {
					System.out.println("Por favor, seleccione primero el 1 para encriptar una frase");
					System.out.println("**********************************************");

				}
			}
			else if(opcion==4) {
				System.out.println("Gracias por usar este programa!");
			}
			else {
				System.out.println("Opción no válida. Introduzca un número del 1 al 4.");
			}
		}
			

	}

}
