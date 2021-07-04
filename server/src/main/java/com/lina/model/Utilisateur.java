package com.lina.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lina.helper.Encrypt;
import com.lina.model.dao.DBConnect;

public class Utilisateur {
	private int idUtilisateur;
	private String logins;
	private String passwords;
	private boolean admin;

	public Utilisateur(String logins, String passwords, boolean admin) {
		this.logins = logins;
		this.passwords = Encrypt.Sha1(passwords);
		this.admin = admin;
	}

	public Utilisateur(int idUtilisateur, String logins, String passwords, boolean admin) {
		this.setIdUtilisateur(idUtilisateur);
		this.setLogins(logins);
		this.setPasswords(passwords);
		this.setAdmin(admin);
	}

	public Utilisateur() {
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public String getLogins() {
		return logins;
	}

	public String getPasswords() {
		return passwords;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public void setLogins(String logins) {
		this.logins = logins;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public static Utilisateur authentificate(Connection c, String logins, String passwords) throws Exception {
		String sql = "SELECT idUtilisateur,logins,passwords,admins FROM utilisateur WHERE logins=? and passwords=?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setString(1, logins);
		passwords = Encrypt.Sha1(passwords);
		pst.setString(2, passwords);
		ResultSet rs = null;
		try {
			rs = pst.executeQuery();
			if (rs.next()) {
				return new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
			}
			throw new Exception("Authentification incorrecte");
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (rs != null)
				rs.close();
		}
	}
	public static Utilisateur authentificate(String logins,String passwords)throws Exception{
		Connection c = null;
		try {
			c = DBConnect.getDAO().connect();
			return authentificate(c, logins, passwords);
		} catch (Exception e) {
			throw e;
		}finally{
			if(c!=null) c.close();
		}
	}
}
