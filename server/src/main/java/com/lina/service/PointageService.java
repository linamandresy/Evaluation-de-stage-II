package com.lina.service;

import java.sql.Connection;

import com.lina.helper.Jour7;
import com.lina.model.Pointage;
import com.lina.model.dao.DAOLina;
import com.lina.model.dao.DBConnect;

public class PointageService {
	public static Response insertPointage(String token,Jour7 j)throws Exception{
		Connection c = null;
		try{
			DAOLina dao = DBConnect.getDAO();
			c = dao.connect();
			UtilisateurService.checkToken(c, token);
			dao.insert(c, j.lundi);
			dao.insert(c, j.mardi);
			dao.insert(c, j.mercredi);
			dao.insert(c, j.jeudi);
			dao.insert(c, j.vendredi);
			dao.insert(c, j.samedi);
			dao.insert(c, j.dimanche);
			c.commit();
			return new Response(200,"Pointages enregistré");
		}catch(Exception ex){
			if(c!=null) c.rollback();
			return new Response(400,ex.getMessage());
		}finally{
			if(c!=null)c.close();
		}
	}
}
