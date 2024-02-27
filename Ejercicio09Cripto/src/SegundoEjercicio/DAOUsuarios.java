package SegundoEjercicio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuarios {
	public List<Usuario> listaUsers;
	private MessageDigest md;

	public DAOUsuarios() throws NoSuchAlgorithmException {
		md = MessageDigest.getInstance("SHA-512");
		byte[] pwd1 = "Caramelo24".getBytes();
		md.update(pwd1);
		Usuario usr1 = new Usuario("usr1", md.digest());
		byte[] pwd2 = "MiPerraDuna".getBytes();
		md.update(pwd2);
		Usuario usr2 = new Usuario("usr2", md.digest());
		byte[] pwd3 = "SoySuperGuay".getBytes();
		md.update(pwd3);
		Usuario usr3 = new Usuario("usr3", md.digest());
		listaUsers = new ArrayList<Usuario>();
		listaUsers.add(usr3);
		listaUsers.add(usr2);
		listaUsers.add(usr1);
	}

	public Usuario get(String usr) {
		Usuario usrAux = null;
		for (Usuario usuario : listaUsers) {
			if (usuario.getNickname().equals(usr)) {
				usrAux = usuario;
			}
		}
		if (usrAux == null) {
			System.out.println("No esta registrado este usuario");
		}
		return usrAux;
	}

}
