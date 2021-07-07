package com.lina.service;

import com.lina.model.label.FicheHorraire;

public class FicheHorraireService {
	public static Response findById(int id){
		try{
			return new Response(200,FicheHorraire.findById(id));
		}catch(Exception ex){
			return new Response(400,ex.getMessage());
		}
	}
}
