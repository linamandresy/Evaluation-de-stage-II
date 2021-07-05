package com.lina.service;

import java.sql.Connection;

import com.lina.model.Semaine;
import com.lina.model.dao.DBConnect;

public class SemaineService {
	public static Response nouvelleSemaine(String token)throws Exception{
		Connection c = null;
		try{
			c = DBConnect.getDAO().connect();
			UtilisateurService.checkToken(c, token);
			Semaine.insertNewSemaine(c);
			c.commit();
			return new Response(200,"Nouvelle semaine ajouté");
		}catch(Exception ex){
			if(c!=null)c.rollback();
			return new Response(400,ex.getMessage());
		}finally{
			if(c!=null) c.close();
		}
	}
	public static Response getSemaines(){
		try{
			return new Response(200,DBConnect.getDAO().find(Semaine.class));
		}catch(Exception ex){
			return new Response(400,ex.getMessage());
		}
	}
}
