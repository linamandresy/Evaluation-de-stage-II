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
			return new Response(200,user);
		}catch(Exception ex){
			c.rollback();
			return new Response(400,ex.getMessage());
		}finally{
			if(c!=null) c.close();
		}
	}
}
