package com.lina.service;

import java.sql.Connection;

import com.lina.model.HeureSup;
import com.lina.model.dao.DAOLina;
import com.lina.model.dao.DBConnect;

public class HeureSupService {
	public static Response getHeureSup(){
		try {
			return new Response(200,DBConnect.getDAO().find(HeureSup.class));
		} catch (Exception e) {
			return new Response(400,e.getMessage());
		}
	}
	public static Response insertHeureSup(String token,String nomHS,int nbHeure, int idHSPrec,double pourcentage)throws Exception{
		Connection c = null;
		try {
			DAOLina dao = DBConnect.getDAO();
			c = dao.connect();
			UtilisateurService.checkToken(c, token);
			HeureSup hs = new HeureSup(nomHS, nbHeure, idHSPrec, pourcentage);
			dao.insert(c,hs);
			c.commit();
			return new Response(200,"Heure Sup inséré");
		} catch (Exception e) {
			if(c!=null) c.rollback();
			return new Response(400,e.getMessage());
		}finally{
			if(c!=null) c.close();
		}
	}
	public static Response findHeureSupById(int id){
		try {
			return new Response(200,DBConnect.getDAO().findById(HeureSup.class, id));
		} catch (Exception e) {
			return new Response(400,e.getMessage());
		}
	}
	public static Response updateHeureSup(String token,int id,String nomHS, int nbHeure, int idHSPrec, double pourcentage)throws Exception{
		Connection c = null;
		try {
			DAOLina dao = DBConnect.getDAO();
			c = dao.connect();
			UtilisateurService.checkToken(c, token);
			HeureSup hs = new HeureSup(id,nomHS, nbHeure, idHSPrec, pourcentage);
			dao.update(c, hs);
			c.commit();
			return new Response(200,"Heure supplémentaire modifié");
		} catch (Exception e) {
			if(c!=null) c.rollback();
			return new Response(400,e.getMessage());
		}finally{
			if(c!=null) c.close();
		}
	}
}
