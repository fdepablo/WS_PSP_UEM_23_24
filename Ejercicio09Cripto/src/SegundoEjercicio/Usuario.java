package SegundoEjercicio;

import java.util.Arrays;

public class Usuario {
	private String nickname;
	private byte[] pwd;

	public Usuario(String nickname, byte[] pwd) {
		this.nickname = nickname;
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public byte[] getPwd() {
		return pwd;
	}

	public void setPwd(byte[] pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Usuario [nickname=" + nickname + ", pwd=" + Arrays.toString(pwd) + "]";
	}
}
