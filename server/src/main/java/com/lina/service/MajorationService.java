package com.lina.service;

import com.lina.model.Majoration;
import com.lina.model.dao.DBConnect;

public class MajorationService {
	public static Response getMajoration(){
		try {
			return new Response(200,Majoration.find());
		} catch (Exception e) {
			return new Response(400,e.getMessage());
		}
	}
	public static Response getById(int id){
		try {
			return new Response(200,DBConnect.getDAO().findById(Majoration.class, id));
		} catch (Exception e) {
			return new Response(400,e.getMessage());
		}
	}
	public static Response updateMajoration(int idMajoration, String nomMaj, double pourcentage){
		try{
			Majoration maj = new Majoration(idMajoration,nomMaj,pourcentage);
			DBConnect.getDAO().update(maj);
			return new Response(200,"Update Réussi");
		}	catch(Exception ex){
			return new Response(400,ex.getMessage());
		}
	}
}
