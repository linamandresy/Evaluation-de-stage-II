package com.lina.model;

import java.sql.Timestamp;

import com.lina.helper.Encrypt;

public class Token {
	private String token;
	private int idUtilisateur;
	private Timestamp expiration;

	public void setExpiration(Timestamp expiration) {
		this.expiration = expiration;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Timestamp getExpiration() {
		return expiration;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public String getToken() {
		return token;
	}

	public Token(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
		this.token = Encrypt.Sha1(
				"Token".concat(String.valueOf(this.idUtilisateur).concat(String.valueOf(System.currentTimeMillis()))));
		expiration = new Timestamp(System.currentTimeMillis() + (24 * 3600000));
	}
}
