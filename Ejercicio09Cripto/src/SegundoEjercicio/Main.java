package SegundoEjercicio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		DAOUsuarios dao = new DAOUsuarios();
		Scanner in = new Scanner(System.in);
		System.out.print("Bienvenido! Por favor introduzca su nickname: ");
		String usrNick = in.next();
		Usuario usr = dao.get(usrNick);
		if (usr != null) {
			System.out.print("Introduzca la contraseña: ");
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] pwdString = in.next().getBytes();
			md.update(pwdString);
			if (Arrays.equals(usr.getPwd(), md.digest())) {
				System.out.println("Bienvenido a la aplicación!");
			} else {
				System.out.println("Contraseña incorrecta!");
			}
		}
	}
}
