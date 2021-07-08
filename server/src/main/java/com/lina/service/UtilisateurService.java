package com.lina.service;

import java.sql.Connection;

import com.lina.model.Token;
import com.lina.model.Utilisateur;
import com.lina.model.dao.DAOLina;
import com.lina.model.dao.DBConnect;

public class UtilisateurService {
	public static Response authentificate(String login,String password)throws Exception{
		Connection c = null;
		try{
			DAOLina dao = DBConnect.getDAO();
			c = dao.connect();
			Utilisateur user = Utilisateur.authentificate(c,login, password);
			Token t = new Token(user.getIdUtilisateur());
			dao.insert(c, t);
			c.commit();
			return new Response(200,t.getToken());
		}catch(Exception ex){
			c.rollback();
			return new Response(400,ex.getMessage());
		}finally{
			if(c!=null) c.close();
		}
	}
	public static Token checkToken(Connection c,String token)throws Exception{
		return Token.getValidToken(c,token.substring(7));
	}
	public static Token checkToken(String token)throws Exception{
		return Token.getValidToken(token.substring(7));
	}
	public static Response checkValidToken(String token){
		try {
			return new Response(200,checkToken(token));
		} catch (Exception e) {
			return new Response(400,e.getMessage());
		}
	}
}
