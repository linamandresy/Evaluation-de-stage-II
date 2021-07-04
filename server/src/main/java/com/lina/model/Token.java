package com.lina.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.lina.helper.Encrypt;
import com.lina.model.dao.DBConnect;

public class Token {
	private String token;
	private int idUtilisateur;
	private Timestamp expiration;

	public Token(String token, int idUtilisateur, Timestamp expiration) {
		this.token = token;
		this.idUtilisateur = idUtilisateur;
		this.expiration = expiration;
	}

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

	public static Token getValidToken(Connection c, String token) throws Exception {
		String sql = "SELECT TOKEN,IDUTILISATEUR,EXPIRATION FROM TOKEN WHERE TOKEN = ? AND EXPIRATION > ?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setString(1, token);
		pst.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
		ResultSet rs = null;
		try {
			rs = pst.executeQuery();
			if (rs.next()) {
				return new Token(rs.getString(1), rs.getInt(2), rs.getTimestamp(3));
			}
			throw new Exception("Token invalide");
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (rs != null)
				rs.close();
		}
	}
	public static Token getValidToken(String token)throws Exception{
		Connection c = null;
		try{
			c = DBConnect.getDAO().connect();
			return getValidToken(c,token);
		}catch(Exception ex){
			throw ex;
		}finally{
			if(c!=null) c.close();
		}
	}
}
