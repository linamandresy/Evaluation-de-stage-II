package com.lina.service;

import java.sql.Connection;

import com.lina.model.Categorie;
import com.lina.model.Utilisateur;
import com.lina.model.dao.DAOLina;
import com.lina.model.dao.DBConnect;

public class CategorieService {
	public static Response insertCategorie(String token,String nomCategorie, double nbHeureN, double salaireHN, double indamnite) throws Exception{
		Connection c = null;
		try{
			DAOLina dao = DBConnect.getDAO();
			c = dao.connect();
			UtilisateurService.checkToken(c, token);
			dao.insert(c, new Categorie(nomCategorie, nbHeureN, salaireHN, indamnite));
			c.commit();
			return new Response(200,"Categorie inséré");
		}catch(Exception ex){
			if(c!=null)	c.rollback();
			throw ex;
		}finally{
			if(c!=null) c.close();
		}
	}
	public static Response listCategorie()throws Exception{
		try{
			return new Response(200,DBConnect.getDAO().find(Categorie.class));
		}catch(Exception ex){
			return new Response(400,ex.getMessage());
		}
	}
	public static Response findById(int id) throws Exception{
		try{
			return new Response(200,DBConnect.getDAO().findById(Categorie.class, id));
		}catch(Exception ex){
			return new Response(400,ex.getMessage());
		}
	}
	public static Response updateCategorie(String token,int id,String nomCategorie, double nbHeureN, double salaireHN, double indamnite)throws Exception{
		Connection c = null;
		try {
			DAOLina dao = DBConnect.getDAO();
			c = dao.connect();
			UtilisateurService.checkToken(c, token);
			Categorie cat = new Categorie(id, nomCategorie, nbHeureN, salaireHN, indamnite);
			dao.update(c, cat);
			c.commit();
			return new Response(200,"Categorie modifié");
		} catch (Exception e) {
			if(c!=null) c.rollback();
			return new Response(400,e.getMessage());
		}finally{
			if(c!=null) c.close();
		}
	}
}
