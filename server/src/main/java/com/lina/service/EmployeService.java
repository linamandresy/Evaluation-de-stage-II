package com.lina.service;

import java.sql.Connection;
import java.sql.Date;

import com.lina.model.Employe;
import com.lina.model.dao.DAOLina;
import com.lina.model.dao.DBConnect;
import com.lina.model.label.EmployeLabel;

public class EmployeService {
	public static Response getListEmploye()throws Exception{
		try{
			return new Response(200,EmployeLabel.find());
		}catch(Exception ex){
			return new Response(400,ex.getMessage());
		}
	}
	public static Response insertEmploye(String token,String nom, String prenom,  Date naissance, Date embauche,Date finContrat, int idCategorie)throws Exception{
		Connection c = null;
		try {
			DAOLina dao = DBConnect.getDAO();
			c = dao.connect();
			UtilisateurService.checkToken(c, token);
			Employe emp = new Employe(nom, prenom, null, naissance, embauche, finContrat, idCategorie);
			dao.insert(c, emp);
			c.commit();
			return new Response(200,"Employé inséré");
		} catch (Exception e) {
			if(c!=null) c.rollback();
			return new Response(400,e.getMessage());
		}finally{
			if(c!=null) c.close();
		}
	}
	public static Response getEmployeById(int id)throws Exception{
		try {
			return new Response(200,Employe.findById(id));
		} catch (Exception e) {
			return new Response(400,e.getMessage());
		}
	}
	public static Response updateEmploye(String token,int idEmploye, String nom, String prenom, String matricule, Date naissance, Date embauche,Date finContrat, int idCategorie)throws Exception{
		Connection c = null;
		try {
			DAOLina dao = DBConnect.getDAO();
			c = dao.connect();
			UtilisateurService.checkToken(c, token);
			Employe emp = new Employe(idEmploye, nom, prenom, matricule, naissance, embauche, finContrat, idCategorie);
			dao.update(c, emp);
			c.commit();
			return new Response(200,"Employé modifié");
		} catch (Exception ex) {
			if(c!=null) c.rollback();
			return new Response(400,ex.getMessage());
		}finally{
			if(c!=null) c.close();
		}
	}
}
