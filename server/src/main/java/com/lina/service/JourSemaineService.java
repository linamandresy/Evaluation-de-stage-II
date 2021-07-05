package com.lina.service;

import com.lina.model.JourSemaine;
import com.lina.model.dao.DBConnect;

public class JourSemaineService {
	public static Response getJourSemaine(){
		try{
			return new Response(200,DBConnect.getDAO().find(JourSemaine.class));
		}catch(Exception ex){
			return new Response(400,ex.getMessage());
		}
	}
}
